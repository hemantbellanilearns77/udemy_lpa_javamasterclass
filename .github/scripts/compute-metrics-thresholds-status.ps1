        $skipSonarPattern = "(?i)skip.*sonar|sonar.*skip"
        $skipFlagVal="$env:SKIP_FLAG"
        Start-Sleep -Seconds $env:SONAR_FETCH_SLEEP_TIME
        $projectKey = $env:SONAR_PROJECT_KEY
        $projectOrg = $env:SONAR_ORG
        $branch = $env:BRANCH_EXECUTED
        $repository = $env:REPOSITORY
        Write-Host "✅ SKIP_FLAG as received in publish summary composite is: $skipFlagVal"


        ############################################################
        # === Parse Checkstyle & PMD Reports ===
        ############################################################
        $checkstyleViolations = 0
        if (Test-Path "reports/checkstyle") {
          Get-ChildItem reports/checkstyle/*.txt | ForEach-Object {
            $checkstyleViolations += (Get-Content $_ | Where-Object { $_.Trim() -ne "" }).Count
          }
        }

        $pmdViolations = 0
        if (Test-Path "reports/pmd") {
          Get-ChildItem reports/pmd/*.txt | ForEach-Object {
            $pmdViolations += (Get-Content $_ | Where-Object { $_ -match "^[A-Za-z]:\\" }).Count
          }
        }
        $totalViolations = $checkstyleViolations + $pmdViolations

       ############################################################
       # === Compute Coverage, CoverageBar, Coverage Status  ===
       ############################################################
       if ($skipFlagVal -imatch $skipSonarPattern) {
            ############################################################
            # === Fetch SonarCloud Coverage Metrics ===
            ############################################################
            $encodedAuth = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes("$($env:SONAR_TOKEN):"))
            $headers = @{ Authorization = "Basic $encodedAuth" }

            function Get-SonarMetric($metricKey) {
              $url = "https://sonarcloud.io/api/measures/component?component=$projectKey&metricKeys=$metricKey"
              # Write-Host "Coverage Fetch URL is $url"
              try {
                $resp = Invoke-WebRequest -Uri $url -Method Get
                $json = $resp.Content | ConvertFrom-Json
                $returnVal = [double]$json.component.measures[0].value
                return $returnVal
              } catch {
                Write-Error "⚠ API call failed: $_"
                exit 1
              }
            }

            $sonarCoverage = Get-SonarMetric "coverage"
            Write-Output "Sonar-style Coverage as fetched from SonarCloud is $sonarCoverage"
        }
        else {
            ############################################################
            # === Parse JaCoCo XML (Overall) ===
            ############################################################

            $lineNode   = Select-Xml -Path reports\jacoco\jacoco-latest.xml -XPath "//report/counter[@type='LINE']"
            $branchNode = Select-Xml -Path reports\jacoco\jacoco-latest.xml -XPath "//report/counter[@type='BRANCH']"

            $lineMissed   = [int]$lineNode.Node.missed
            $lineCovered  = [int]$lineNode.Node.covered
            $branchMissed = [int]$branchNode.Node.missed
            $branchCovered= [int]$branchNode.Node.covered

            $total = $lineMissed + $lineCovered + $branchMissed + $branchCovered
            if ($total -gt 0) {
                $jacocoCoverage = [math]::Round(100 * ($lineCovered + $branchCovered) / $total, 1)
            } else {
                $jacocoCoverage = 0.0
            }
            $sonarCoverage = $jacocoCoverage
            Write-Output "Sonar-style Coverage as fetched from latest Jacoco Execution in runner is $sonarCoverage %"
        }
        function Get-AsciiBar($percent) {

          $blocks = 27
          $filled = [math]::Round($blocks * $percent / 100)
          $empty = $blocks - $filled
          $AsciiBar = ('█' * $filled) + ('░' * $empty)
          # return ('█' * $filled) + ('░' * $empty)
          return $AsciiBar
        }

        $coverageBar = Get-AsciiBar $sonarCoverage

        function FormatCoverageStatus($actualCoverage, $minNeeded) {
            if ($actualCoverage -is [array]) {
                $actualCoverage = $actualCoverage[0]
            }
            # sanitize and cast
            $actualCoverage = [double]($actualCoverage -replace '[^0-9\.]', '')

            if ($actualCoverage -ge 90.00) {
                $emoji = "🟢"
                $note  = "(GREAT)"
            } elseif ($actualCoverage -ge $minNeeded -and $actualCoverage -le 89.99) {
                $emoji = "🟡"
                $note  = "(NEARING THRESHOLD)"
            } else {
                $emoji = "🔴"
                $note  = "(OVERBOARD)"
            }
            return "/ 100% $emoji $note"
        }
        $coverageStatus = FormatCoverageStatus $sonarCoverage $env:JACOCO_MIN_COVERAGE

        ############################################################
        # === Fetch SonarCloud Issue Count (OPEN) ===
        ############################################################

        # Confirm if token is passed
        if (-not $env:SONAR_TOKEN) {
         Write-Error "⚠ SONAR_TOKEN is empty!"
         exit 1
        }
        $url = "https://sonarcloud.io/api/issues/search?organization=$projectOrg&componentKeys=$projectKey&issueStatuses=OPEN,CONFIRMED&facets=impactSeverities"
        Write-Host "?? Calling SonarCloud API: $url"
        $impactSeveritiesCounts = @{
             BLOCKER = 0
             HIGH    = 0
             MEDIUM  = 0
             LOW     = 0
             INFO    = 0
        }
        $blocker = $impactSeveritiesCounts["BLOCKER"]
        $high    = $impactSeveritiesCounts["HIGH"]
        $medium  = $impactSeveritiesCounts["MEDIUM"]
        $low     = $impactSeveritiesCounts["LOW"]
        $info    = $impactSeveritiesCounts["INFO"]

        try {
         $response = Invoke-WebRequest -Uri $url -Method Get
         $body = $response.Content
         $json = $body | ConvertFrom-Json
         $impactSeveritiesCounts = @{
             BLOCKER = 0
             HIGH    = 0
             MEDIUM  = 0
             LOW     = 0
             INFO    = 0
         }

         foreach ($val in $json.facets[0].values) {
                  $impactSeveritiesCounts[$val.val] = $val.count
          }
          $blocker = $impactSeveritiesCounts["BLOCKER"]
          $high    = $impactSeveritiesCounts["HIGH"]
          $medium  = $impactSeveritiesCounts["MEDIUM"]
          $low     = $impactSeveritiesCounts["LOW"]
          $info    = $impactSeveritiesCounts["INFO"]
         if ($body -match '"total"\s*:\s*(\d+)') {
           $totalSonarFetchedIssues = $matches[1]
           Write-Host "? Total SonarCloud Issues (OPEN): $totalSonarFetchedIssues"
         } else {
           Write-Error "? Could not extract issue count from response body: $body"
           exit 1
         }
        } catch {
         Write-Error "⚠ API call failed: $_"
         exit 1
        }

        ############################################################
        # === Derive Sonar Presentation Variables ===
        ############################################################

        if ($skipFlagVal -match $skipSonarPattern) {
            $sonarExecutionNote = "SKIPPED ⚡ (manual override)"
            $sonarIssuesNote    = "from last successful analysis : $totalSonarFetchedIssues"
        } else {
            $sonarExecutionNote = "EXECUTED ✅"
            $sonarIssuesNote    = "from just executed successful analysis : $totalSonarFetchedIssues"
        }
        # --- Fetch timestamp of last analysis dynamically from SonarCloud API ---
        $apiUrl = "https://sonarcloud.io/api/project_analyses/search?project=$projectKey&ps=1"
        try {
          $response = Invoke-RestMethod -Uri $apiUrl -Method Get
          if ($response.analyses.Count -gt 0) {
            $lastAnalysisUtc = [datetime]$response.analyses[0].date
            Write-Host "📅 Last Analysis UTC: $lastAnalysisUtc"
            $istZone = [System.TimeZoneInfo]::FindSystemTimeZoneById("India Standard Time")
            $lastAnalysisIst = [System.TimeZoneInfo]::ConvertTimeFromUtc($lastAnalysisUtc.ToUniversalTime(), $istZone)
            $lastSonarAnalysis = $lastAnalysisIst.ToString("yyyy-MM-dd HH:mm") + " IST"
          } else {
              $lastSonarAnalysis = "SonarCloud API Fetch Project Analysis did not return anything"
              Write-Warning "SonarCloud API Fetch Project Analysis did not return anything"
          }
        } catch {
          Write-Warning "Failed to fetch last Sonar analysis: $_"
          $lastSonarAnalysis = "N/A"
        }
        Write-Host "📅 Last Analysis IST: $lastSonarAnalysis"

        ############################################################
        # === Generate Severity URLs (global and per module) ===
        ############################################################
        $severityLinks = @{
          BLOCKER = "https://sonarcloud.io/project/issues?impactSeverities=BLOCKER&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          HIGH    = "https://sonarcloud.io/project/issues?impactSeverities=HIGH&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          MEDIUM  = "https://sonarcloud.io/project/issues?impactSeverities=MEDIUM&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          LOW     = "https://sonarcloud.io/project/issues?impactSeverities=LOW&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          INFO    = "https://sonarcloud.io/project/issues?impactSeverities=INFO&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
        }
        Write-Host "✅ Counts as extracted from API Call response after fetching total impact severities is: : $impactSeveritiesCounts"
        ############################################################
              # === Generate URLS ===
        ############################################################
         $sonarOverallCodeDashBoardUrl = "https://sonarcloud.io/summary/overall?id=$projectKey&branch=$branch"
         $sonarOpenIssuesDashboardUrl= "https://sonarcloud.io/project/issues?issueStatuses=OPEN%2CCONFIRMED&id=$projectKey"

        function FormatSonarStatus($count, $maxAllowed, $severity) {
            if ($count -eq 0) {
                $emoji = "✅"
                $note  = "(GREAT)"
            } elseif ($count -le $maxAllowed) {
                $emoji = "🟡"
                $note  = "(NEARING THRESHOLD)"
            } else {
                $emoji = "🔴"
                $note  = "(OVERBOARD)"
            }
            return " / $maxAllowed $emoji $note"
            #return "$severity Issues: $count / $maxAllowed $emoji $note"
        }


        $sonarBlockerStatus = FormatSonarStatus $blocker $env:BLOCKER_MAX "🟥 BLOCKER"
        $sonarHighStatus    = FormatSonarStatus $high    $env:HIGH_MAX    "🟧 HIGH"
        $sonarMediumStatus  = FormatSonarStatus $medium  $env:MEDIUM_MAX  "🟨 MEDIUM"
        $sonarLowStatus     = FormatSonarStatus $low     $env:LOW_MAX     "🟦 LOW"
        $sonarInfoStatus    = FormatSonarStatus $info    $env:INFO_MAX    "ℹ️ INFO"
        $sonarIssuesLegend = "Legend: ✅ = Excellent / No issues, 🟡 = Monitor Closely (NEARING THRESHOLD), 🔴 = Immediate Action Required (THRESHOLD BREACHED)"


        ###############################################################################
        # === SonarCloud Module Severity Breakdown (Aggregated per MODULE_PATHS) ===
        ###############################################################################

        # Normalize line endings, build map
        $modulePathMap = @{}
        $lines = ($env:MODULE_PATHS -replace "`r", "") -split "`n"

        foreach ($line in $lines) {
          if ($line.Trim()) {
          $parts = $line.Trim() -split "=", 2  # limit to 2 parts only
           # Write-Output "Next line: '$line' split into key='$($parts[1])' and value='$($parts[0])'"
            if ($parts.Count -eq 2) {
              # Write-Output "Creating map entry: key='$($parts[1])', value='$($parts[0])'"
              $modulePathMap[$parts[1]] = $parts[0]
            }
          }
        }

        <# Debug: print map
         foreach ($k in $modulePathMap.Keys) {
             Write-Output "Map Key: $k => Value: $($modulePathMap[$k])"
         } #>
        # Initialize aggregation buckets for each module
        $moduleAgg = @{}
        foreach ($pathKey in $modulePathMap.Keys) {
          # Write-Output "Iterating over modulePathMap next path key is $pathKey"
          $moduleName = $modulePathMap[$pathKey]
          # Write-Output "So moduleName is initialized to: $moduleName"
          if (-not $moduleAgg) {
                Write-Output "❌ moduleAgg is NULL"
          }

          if (-not $moduleAgg.ContainsKey($moduleName)) {

            $moduleAgg[$moduleName] = @{
            BLOCKER = 0; HIGH = 0; MEDIUM = 0; LOW = 0; INFO = 0
            }
          }
        }
        if (-not $moduleAgg) {
                Write-Output "❌ moduleAgg is NULL"
        }  else {
                # Write-Output "✅ moduleAgg exists. Current contents:"
                $moduleAgg.GetEnumerator() | ForEach-Object {
                $val = $_.Value
                if (-not $val) {
                  Write-Output ("   ⚠ Key = {0}, Value is NULL" -f $_.Key)
                }
                else {
                  # Write-Output ("   Key = {0}, Value = {1}" -f $_.Key, ($val | ConvertTo-Json -Compress))
                }
              }
           <# Debug: Print out current aggregate state
           Write-Output "----- Current Module Aggregates -----"
           foreach ($moduleName in $moduleAgg.Keys) {
                $bucket = $moduleAgg[$moduleName]
                Write-Output ("Module: {0} | BLOCKER={1}, HIGH={2}, MEDIUM={3}, LOW={4}, INFO={5}" -f `
                               $moduleName, $bucket.BLOCKER, $bucket.HIGH, $bucket.MEDIUM, $bucket.LOW, $bucket.INFO)
           } #>
           # Write-Output "--------------------------------------"
          }

        # Step 1: Get directory list from SonarCloud
        $dirFacetssUrl = "https://sonarcloud.io/api/issues/search?organization=$projectOrg&componentKeys=$projectKey&resolved=false&facets=directories&ps=1"
        # Write-Output "Fetching directories from: $dirFacetssUrl"
        $resp = Invoke-WebRequest -Uri $dirFacetssUrl -Headers $headers -Method Get
        $json = $resp.Content | ConvertFrom-Json
        $directories = $json.facets | Where-Object { $_.property -eq "directories" } | Select-Object -ExpandProperty values
        # Write-Output "Directories fetched as below:"
        # $directories | ForEach-Object { Write-Output " - $($_.val)" }

        # Step 2: Loop through directories and aggregate counts per module
        foreach ($dirObj in $directories) {

          $dir = $dirObj.val
          $matchedModule = $null
          # Write-Output "Next Directory during iteration is: $dir"

          # check if src of any key in modulePathMap matches the starting string of the current directory
          foreach ($pathKey in $modulePathMap.Keys) {
            if ($dir -like "$pathKey*") {
              # Write-Output "✅ Match: '$dir' starts with '$pathKey'"
              $matchedModule = $modulePathMap[$pathKey]
              # Write-Output "Matched module: $matchedModule"
              break
            }
          }
          # double check if any module has matched to account for current directory
          if (-not $matchedModule) {
            Write-Output "⚠ Skipping: '$dir' does not match any configured module"
            Write-Output " ⚠ Current Directory does not fall under any configured module so will skip for now flagging it $dir"
            Write-Output " ⚠ Also due to that mismatch $matchedModule is empty"
          } else {
                if (-not $moduleAgg) {
                  Write-Output "❌ moduleAgg is NULL"
                } else {
                # Write-Output "✅ moduleAgg exists. Will execute severity checks and aggregate"
                if ($null -ne $moduleAgg[$matchedModule]) {
                # Write-Output "✅ moduleAgg has a row for: $matchedModule and can be populated with severity numbers"

                # now fetch impact-severity-wise and then aggregate it
                  $dirIssuesUrl = "https://sonarcloud.io/api/issues/search?organization=$projectOrg&componentKeys=$projectKey&directories=$dir&issueStatuses=OPEN,CONFIRMED&resolved=false&ps=500"
                  Write-Output "✅ Calling Directory issues url for: $dir as : $dirIssuesUrl"
                  $response = Invoke-WebRequest -Uri $dirIssuesUrl -Headers $headers -Method Get | ConvertFrom-Json

                  # Initialize counts
                  $counts = @{
                  BLOCKER = 0
                  HIGH    = 0
                  MEDIUM  = 0
                  LOW     = 0
                  INFO    = 0
                }

                foreach ($issue in $response.issues) {
                    foreach ($impact in $issue.impacts) {
                      switch ($impact.severity) {
                        "BLOCKER"   { $counts.BLOCKER++ }
                          "HIGH"    { $counts.HIGH++ }
                          "MEDIUM"  { $counts.MEDIUM++ }
                          "LOW"     { $counts.LOW++ }
                          "INFO"    { $counts.INFO++ }
                        }
                    }
                }
                $totalIssuesDir = ($counts.BLOCKER + $counts.HIGH + $counts.MEDIUM + $counts.LOW + $counts.INFO)
                Write-Output "✅ Total issues for : $dir are : $totalIssuesDir"
                # Now add to moduleAgg
                  $moduleAgg[$matchedModule]["BLOCKER"] += $counts.BLOCKER
                  $moduleAgg[$matchedModule]["HIGH"]    += $counts.HIGH
                  $moduleAgg[$matchedModule]["MEDIUM"]  += $counts.MEDIUM
                  $moduleAgg[$matchedModule]["LOW"]     += $counts.LOW
                  $moduleAgg[$matchedModule]["INFO"]    += $counts.INFO


              } else {
                  Write-Output "⚠ Unexpected: \$moduleAgg['$matchedModule'] is null. Skipping severity count."
              }
            } # end of else of check for $moduleAgg being null
          } # end of else of matchedModule not being found
        } # end step 2

        # Before moving to next step printing it in logs...
        if (-not $moduleAgg) {
          Write-Output "❌ moduleAgg is NULL"
        }  else {
          # Write-Output "✅ moduleAgg exists. Current contents:"
          $moduleAgg.GetEnumerator() | ForEach-Object {
            $val = $_.Value
            if (-not $val) {
              # Write-Output ("   ⚠ Key = {0}, Value is NULL" -f $_.Key)
            }
            else {
              # Write-Output ("   Key = {0}, Value = {1}" -f $_.Key, ($val | ConvertTo-Json -Compress))
            }
          }
          <# Debug: Print out current aggregate state
          Write-Output "----- Current Module Aggregates -----"
          foreach ($moduleName in $moduleAgg.Keys) {
            $bucket = $moduleAgg[$moduleName]
            # Write-Output ("Module: {0} | BLOCKER={1}, HIGH={2}, MEDIUM={3}, LOW={4}, INFO={5}" -f `
                          # $moduleName, $bucket.BLOCKER, $bucket.HIGH, $bucket.MEDIUM, $bucket.LOW, $bucket.INFO)
          } #>
          # Write-Output "--------------------------------------"
        }
       function Mark($count) {
             if ($count -eq 0) { return "✅ $count" }
             elseif ($count -le 5) { return "🟡 $count" }
             else { return "🔴 $count" }
       } # end of function Mark
        # Step 4: Export results as an output variable for email step
        # Example: "udemy_lpa_javamasterclass:0,2,15,5,0;misc_utils:0,1,8,4,0"
        $emailModuleSevAggTable=""
        $emailModuleSevAggBreakdown = ($moduleAgg.Keys | ForEach-Object {
            $b = $moduleAgg[$_]
            "${_}:$(Mark $b.BLOCKER),$(Mark $b.HIGH),$(Mark $b.MEDIUM),$(Mark $b.LOW),$(Mark $b.INFO)"
        }) -join ";"

        $emailModuleSevAggTable = "<table border='1' cellpadding='5' cellspacing='0'>"
        $emailModuleSevAggTable += "<tr><th>Module</th><th>BLOCKER</th><th>HIGH</th><th>MEDIUM</th><th>LOW</th><th>INFO</th></tr>"
        foreach ($entry in $emailModuleSevAggBreakdown -split ";") {
            $parts = $entry -split ":"
            if ($parts.Count -eq 2) {
                $module = $parts[0]
                $counts = $parts[1] -split ","
                $emailModuleSevAggTable += "<tr>"
                $emailModuleSevAggTable += "<td>$module</td>"
                foreach ($c in $counts) {
                    $emailModuleSevAggTable += "<td align='center'>$c</td>"
                }
                $emailModuleSevAggTable += "</tr>"
            }
        }

      $emailModuleSevAggTable += "</table>"
      $githubModuleSevAggTable="Uninitialized"
      if ($moduleAgg.Count -gt 0) {
          $nl = "`n"   # newline for markdown readability
          $githubModuleSevAggTable = "### 📦 SonarCloud Module Impact-Severity$nl$nl"

          $githubModuleSevAggTable += "| Module | 🟥 BLOCKER | 🟧 HIGH | 🟨 MEDIUM | 🟦 LOW  | ℹ INFO |$nl"
          $githubModuleSevAggTable += "|--------|------------|---------|----------|--------|--------|$nl"
          foreach ($mod in $moduleAgg.Keys | Sort-Object) {
              $b = $moduleAgg[$mod]
              $githubModuleSevAggTable += "| **$mod** | $(Mark $b.BLOCKER) | $(Mark $b.HIGH) | $(Mark $b.MEDIUM) | $(Mark $b.LOW) | $(Mark $b.INFO) |$nl"
          }
      }

######################################################################################################################################################################################################################

        Write-Host "🧮 Evaluating metrics against strict thresholds..."
        $passed = $true
        $NextStepsHtml = ""
        $sonarHasNextSteps=$false

        # --- Convert coverage safely ---
        $coverageValue = [double]($sonarCoverage -replace '[^0-9\.]', '')

         # --- Aggregate violations ---
        if ($totalViolations -gt [int]$env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS) {
            $passed = $false
            $NextStepsHtml += "<li>Total code violations exceed allowed maximum ($totalCodeViolations > $($env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS)).</li>"
        }

        if ($checkstyleViolations -gt [int]$env:CHECKSTYLE_MAX_VIOLATIONS) {
            $passed = $false
            $NextStepsHtml += "<li>Fix Checkstyle violations ($checkstyleCount > $($env:CHECKSTYLE_MAX_VIOLATIONS)).</li>"
        }

        if ($pmdViolations -gt [int]$env:PMD_MAX_VIOLATIONS) {
            $passed = $false
            $NextStepsHtml += "<li>Fix pmdCount violations ($pmdCount > $($env:PMD_MAX_VIOLATIONS)).</li>"
        }
        # --- Sonar Severity Checks with detailed reporting ---
        $SonarNextStepsHtml += "<li>Resolve Issues that exceeded threshold per severity:</li>"
        $SonarNextStepsHtml += "<ul>"
        # Blocker
        if ($blocker -gt [int]$env:BLOCKER_MAX) {
            $sonarHasNextSteps=$true
            $SonarNextStepsHtml += "<li>🟥 BLOCKER Issues: $blocker / $($env:BLOCKER_MAX) 🔴 (Exceeded)</li>"
        }

        # High
        if ($high -gt [int]$env:HIGH_MAX) {
            $sonarHasNextSteps=$true
            $SonarNextStepsHtml += "<li>🟧 HIGH Issues: $high / $($env:HIGH_MAX) 🔴 (Exceeded)</li>"
        }

        # Medium
        if ($medium -gt [int]$env:MEDIUM_MAX) {
            $sonarHasNextSteps=$true
            $SonarNextStepsHtml += "<li>🟨 MEDIUM Issues: $medium / $($env:MEDIUM_MAX) 🔴 (Exceeded)</li>"
        }

        # Low
        if ($low -gt [int]$env:LOW_MAX) {
            $sonarHasNextSteps=$true
            $SonarNextStepsHtml += "<li>🟦 LOW Issues: $low / $($env:LOW_MAX) 🔴 (Exceeded)</li>"
        }

        # Info
        if ($info -gt [int]$env:INFO_MAX) {
            $sonarHasNextSteps=$true
            $SonarNextStepsHtml += "<li>ℹ️ INFO Issues: $info / $($env:INFO_MAX) 🔴 (Exceeded)</li>"
        }

        $SonarNextStepsHtml += "</ul>"
        if($sonarHasNextSteps) {$NextStepsHtml += $SonarNextStepsHtml }

        # --- Coverage ---
        if ($coverageValue -lt [double]$env:JACOCO_MIN_COVERAGE) {
            $passed = $false
            $NextStepsHtml += "<li>Increase test coverage (currently $coverageValue%, minimum required $($env:JACOCO_MIN_COVERAGE)%).</li>"
        }

        # --- Job Status ---
        $outcome="$env:JOB_STATUS"
        if ($outcome -ne "success") {
            $passed = $false
            $NextStepsHtml += "<li>The Hygiene sweep and upload reports step, did  not succeed (status: $outcome).</li>"
        }
        # --- Laud Hygiene if no issues ---
        if ([string]::IsNullOrWhiteSpace($NextStepsHtml)) {
            $NextStepsHtml = "<li>Great job! Hygiene is excellent ✅</li>"
        }

        # --- Final Status ---
        $HygieneCheckStatus = if ($passed) { "PASSED ✅" } else { "FAILED ❌" }
        Write-Host "✅ HygieneCheckStatus: $HygieneCheckStatus"


######################################################################################################################################################################################################################

        ############################################################
        # === Outputs for GITHUB SUMMARY and Email ===
        ############################################################
        "checkstyleCount=$checkstyleViolations" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "pmdCount=$pmdViolations" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarCoverage=$sonarCoverage %" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "coverageStatus=$coverageStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "coverageBar=$coverageBar" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        # expose for later consumers (email etc.)
        "sonarExecutionNote=$sonarExecutionNote" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarIssuesNote=$sonarIssuesNote" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "lastSonarAnalysis=$lastSonarAnalysis" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "totalSonarFetchedIssues=$totalSonarFetchedIssues" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarIssuesLegend=$sonarIssuesLegend" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarBlocker=$blocker" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarBlockerEmojiMark=$sonarBlockerStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarBlockerURL=$($severityLinks.BLOCKER)" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarHigh=$high" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarHighEmojiMark=$sonarHighStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarHighURL=$($severityLinks.HIGH)" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarMedium=$medium" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarMediumEmojiMark=$sonarMediumStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarMediumURL=$($severityLinks.MEDIUM)" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarLow=$low" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarLowEmojiMark=$sonarLowStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarLowURL=$($severityLinks.LOW)" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarInfo=$info" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarInfoEmojiMark=$sonarInfoStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarInfoURL=$($severityLinks.INFO)" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        "sonarOverallCodeDashBoardURL=$sonarOverallCodeDashBoardUrl" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarOpenIssuesDashboardURL=$sonarOpenIssuesDashboardUrl" | Out-File -FilePath $env:GITHUB_OUTPUT -Append

        # Export both plain breakdown and HTML table
        "moduleAgg=$moduleAgg" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "EMAIL_BREAKDOWN=$emailModuleSevAggBreakdown" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "EMAIL_MODULE_SEV_AGG_TABLE=$emailModuleSevAggTable" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        # Write as multi-line GitHub Action output
        $githubModuleSevAggTable | Out-File -FilePath module_table.md -Encoding utf8

        Write-Output "GITHUB_SUMMARY_MODULE_SEV_AGG_TABLE<<EOF" >> $env:GITHUB_OUTPUT
        Get-Content module_table.md >> $env:GITHUB_OUTPUT
        Write-Output "EOF" >> $env:GITHUB_OUTPUT

        # --- Emit outputs ---
        "HygieneCheckStatus=$HygieneCheckStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "NextStepsHtml=$NextStepsHtml" | Out-File -FilePath $env:GITHUB_OUTPUT -Append


        ############################################################