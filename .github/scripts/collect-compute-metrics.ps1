        $skipSonarPattern = "(?i)skip.*sonar|sonar.*skip"
        $skipFlagVal="$env:SKIP_FLAG"
        Write-Host "✅ SKIP_FLAG as received in publish summary composite is: $skipFlagVal"
        ############################################################
        # === Parse JaCoCo XML (Overall) ===
        ############################################################
        $xml = Select-Xml -Path reports\jacoco\jacoco-latest.xml -XPath "//report/counter[@type='INSTRUCTION']"
        $missed = [int]$xml.Node.missed
        $covered = [int]$xml.Node.covered
        $total = $missed + $covered
        if ($total -gt 0) {
          $jacocoCoverage = [math]::Round(100 * $covered / $total, 2)
        } else {
          $jacocoCoverage = 0
        }
        
        function Get-AsciiBar($percent) {
        
          $blocks = 25
          $filled = [math]::Round($blocks * $percent / 100)
          $empty = $blocks - $filled
          return ('█' * $filled) + ('░' * $empty)
        }
        
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
        # === Fetch SonarCloud Issue Count (OPEN) ===
        ############################################################
        Start-Sleep -Seconds $env:SONAR_FETCH_SLEEP_TIME
        
        $projectKey = $env:SONAR_PROJECT_KEY
        $projectOrg = $env:SONAR_ORG
        $branch = $env:BRANCH_EXECUTED
        $repository = $env:REPOSITORY
        # Confirm if token is passed
        if (-not $env:SONAR_TOKEN) {
         Write-Error "⚠ SONAR_TOKEN is empty!"
         exit 1
        }
        # $url = "https://sonarcloud.io/api/issues/search?issueStatuses=OPEN,CONFIRMED&id=$projectKey&organization=$projectOrg"
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
        # Write-Host "✅ SKIP_FLAG as received in publish summary composite is: $env:SKIP_FLAG"
        # Write-Host "✅ SKIP_FLAG as received in publish summary composite is: $skipFlagVal"
        
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
        
        # expose for later consumers (email etc.)
        "sonarExecutionNote=$sonarExecutionNote" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarIssuesNote=$sonarIssuesNote" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "lastSonarAnalysis=$lastSonarAnalysis" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        
        ############################################################
        # === Fetch SonarCloud Coverage Metrics ===
        ############################################################
        $encodedAuth = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes("$($env:SONAR_TOKEN):"))
        $headers = @{ Authorization = "Basic $encodedAuth" }
        
        function Get-SonarMetric($metricKey) {
          $url = "https://sonarcloud.io/api/measures/component?component=$projectKey&metricKeys=coverage"
          # Write-Host "Coverage Fetch URL is $url"
          try {
            $resp = Invoke-WebRequest -Uri $url -Method Get
            $json = $resp.Content | ConvertFrom-Json
            return $json.component.measures[0].value
          } catch {
            Write-Error "⚠ API call failed: $_"
            exit 1
          }
        } 
        
        $sonarCoverage = Get-SonarMetric "coverage"
        # Write-Output "Writing Output Coverage as fetched from Sonar is $sonarCoverage"
        if ($sonarCoverage -ge 50) {
          $coverageEmoji = "🟢"
        } elseif ($sonarCoverage -ge 20) {
          $coverageEmoji = "🟡"
        } else {
          $coverageEmoji = "🔴"
        }
        $coverageBar = Get-AsciiBar $sonarCoverage
        
        # $sonarCoverage = Get-SonarMetric "coverage"
        # Ensure only the first numeric value is used
        if ($sonarCoverage -is [array]) {
          $sonarCoverage = $sonarCoverage[0]
        }
        # Try to cast to a number safely
        $sonarCoverage = [double]($sonarCoverage -replace '[^0-9\.]', '')
        if ($sonarCoverage -ge 77) {
          $coverageEmoji = "🟢"
        } elseif ($sonarCoverage -ge 49) {
          $coverageEmoji = "🟡"
        } else {
          $coverageEmoji = "🔴"
        }
        $coverageBar = Get-AsciiBar $sonarCoverage
        
<#         ###########################################################
        # === Fetch Overall Impact Severity Breakdown (UI-Aligned) ===
        ###########################################################
         function Fetch-SonarSeverity($impactSeverities) {
          $url = "https://sonarcloud.io/api/issues/search?impactSeverities=$impactSeverities&issueStatuses=OPEN,CONFIRMED&organization=$projectOrg&id=$projectKey"

          try {
            $resp = Invoke-WebRequest -Uri $url -Headers $headers -Method Get
            $json = $resp.Content | ConvertFrom-Json
            return $json.total
          } catch {
            Write-Error "⚠ API call failed: $_"
            exit 1
          }
        }
        $blocker = Fetch-SonarSeverity "BLOCKER"
        $high = Fetch-SonarSeverity "HIGH"
        $medium = Fetch-SonarSeverity "MEDIUM"
        $low = Fetch-SonarSeverity "LOW"
        $info = Fetch-SonarSeverity "INFO"
        #>
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
<#         $blocker = Fetch-SonarSeverity "BLOCKER"
        $high = Fetch-SonarSeverity "CRITICAL"
        $medium = Fetch-SonarSeverity "MAJOR"
        $low = Fetch-SonarSeverity "MINOR"
        $info = Fetch-SonarSeverity "INFO"
        ############################################################
        # === Generate Severity URLs (global and per module) ===
        ############################################################
        $severityLinks = @{
          BLOCKER = "https://sonarcloud.io/project/issues?severities=BLOCKER&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          HIGH    = "https://sonarcloud.io/project/issues?severities=CRITICAL&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          MEDIUM  = "https://sonarcloud.io/project/issues?severities=MAJOR&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          LOW     = "https://sonarcloud.io/project/issues?severities=MINOR&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
          INFO    = "https://sonarcloud.io/project/issues?severities=INFO&issueStatuses=OPEN,CONFIRMED&id=$projectKey"
        } #>
        Write-Host "✅ Counts as extracted from API Call response after fetching total impact severities is: : $impactSeveritiesCounts"
        ############################################################
              # === Generate URLS ===
        ############################################################
         $sonarOverallCodeDashBoardUrl = "https://sonarcloud.io/summary/overall?id=$projectKey&branch=$branch"
         $sonarOpenIssuesDashboardUrl= "https://sonarcloud.io/project/issues?issueStatuses=OPEN%2CCONFIRMED&id=$projectKey"
        
         function MarkEmoji($count) {
            if ($count -eq 0) { return "✅" }
            elseif ($count -le 27) { return "🟡" }
            else { return "🔴" }
          } # end of function Mark
        
        $sonarBlockerEmojiMark = $(MarkEmoji $blocker)
        $sonarHighEmojiMark = $(MarkEmoji $high)
        $sonarMediumEmojiMark = $(MarkEmoji $medium)
        $sonarLowEmojiMark = $(MarkEmoji $low)
        $sonarInfoEmojiMark = $(MarkEmoji $info)

        function FormatSonarStatus($count, $maxAllowed, $severity) {
            if ($count -eq 0) {
                $emoji = "✅"
                $note  = "(GREAT)"
            } elseif ($count -le $maxAllowed) {
                $emoji = "🟡"
                $note  = "(WATCH-OUT)"
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

         ############################################################
                # === Write Overall Table ===
        ############################################################
        echo "### 📊 Hygiene Summary (Checkstyle + PMD + JaCoCo + Sonar)" >> $env:GITHUB_STEP_SUMMARY
        echo "Repository: $repository " >> $env:GITHUB_STEP_SUMMARY
        echo "Branch: $branch" >> $env:GITHUB_STEP_SUMMARY
        echo "Stage ↔ Main state: $env:STAGE_VS_MAIN_STATE" >> $env:GITHUB_STEP_SUMMARY
        echo "| **Metric**               | **Value** |" >> $env:GITHUB_STEP_SUMMARY
        echo "|------------------------- |-----------|" >> $env:GITHUB_STEP_SUMMARY
        echo "| Checkstyle Violations    | $checkstyleViolations |" >> $env:GITHUB_STEP_SUMMARY
        echo "| PMD Violations           | $pmdViolations |" >> $env:GITHUB_STEP_SUMMARY
        echo "| Code Coverage (Sonar)    | $sonarCoverage % $coverageEmoji |" >> $env:GITHUB_STEP_SUMMARY
        echo "| Coverage Visual          | <code>$coverageBar</code> |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🗂 SonarCloud            | Execution: <code>$sonarExecutionNote</code><br/>Issues: <code>$sonarIssuesNote</code><br/>Last Analysis: <code>$lastSonarAnalysis</code> |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟥 BLOCKER               | [$blocker]($($severityLinks.BLOCKER)) $sonarBlockerStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟧 HIGH                  | [$high]($($severityLinks.HIGH)) $sonarHighStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟨 MEDIUM                | [$medium]($($severityLinks.MEDIUM)) $sonarMediumStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟦 LOW                   | [$low]($($severityLinks.LOW)) $sonarLowStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| ℹ INFO                  | [$info]($($severityLinks.INFO)) $sonarInfoStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| Legend                  | ✅ is GREAT-GOING 🟡 is WATCH-OUT  🔴 is GONE-OVERBOARD |" >> $env:GITHUB_STEP_SUMMARY
        echo "" >> $env:GITHUB_STEP_SUMMARY
        echo "🌐 [View SonarCloud Overall Code Dashboard]($sonarOverallCodeDashBoardUrl)" >> $env:GITHUB_STEP_SUMMARY
        echo "🌐 [View SonarCloud Issues Breakdown Dashboard]($sonarOpenIssuesDashboardUrl)" >> $env:GITHUB_STEP_SUMMARY
        
        ############################################################
        # === Outputs for Email ===
        ############################################################
        "checkstyleCount=$checkstyleViolations" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "pmdCount=$pmdViolations" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "totalSonarFetchedIssues=$totalSonarFetchedIssues" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "coverageBar=$coverageBar" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "sonarCoverage=$sonarCoverage %" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        
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
        
        $emailModuleSevAggTable=""
        # $skipSonarPattern = "(?i)skip.*sonar|sonar.*skip"
        # if ($env:SKIP_FLAG -imatch $skipSonarPattern) {
        if ($skipFlagVal -imatch $skipSonarPattern) {
          $emailModuleSevAggTable="<code>⚡ Unavailable — Sonar was SKIPPED (manual override)</code>"
          # echo "EMAIL_MODULE_SEV_AGG_TABLE=$emailModuleSevAggTable" >> $env:GITHUB_ENV
          "EMAIL_MODULE_SEV_AGG_TABLE=$emailModuleSevAggTable" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
           Write-Host "Skipping rest of this step"
           exit 0   # Ends this step cleanly
        }
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
                  # $sevList = "BLOCKER,CRITICAL,MAJOR,MINOR,INFO"
                  # $sevList = "BLOCKER,HIGH,MEDIUM,LOW,INFO"
                  # $sevUrl = "https://sonarcloud.io/api/issues/search?organization=$projectOrg&componentKeys=$projectKey&directories=$dir&severities=$sevList&issueStatuses=OPEN,CONFIRMED&resolved=false&ps=500"
                  # $impactSevUrl = "https://sonarcloud.io/api/issues/search?organization=$projectOrg&componentKeys=$projectKey&directories=$dir&impactSeverities=$sevList&issueStatuses=OPEN,CONFIRMED&resolved=false&ps=500"
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
        
<#                  foreach ($issue in $response.issues) {
                  switch ($issue.severity) {
                      "BLOCKER"  { $counts.BLOCKER++ }
                      "CRITICAL" { $counts.HIGH++ }
                      "MAJOR"    { $counts.MEDIUM++ }
                      "MINOR"    { $counts.LOW++ }
                      "INFO"     { $counts.INFO++ }
                    }
                } #>
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
<#                 foreach ($issue in $response.issues) {
                  switch ($issue.severity) {
                      "BLOCKER"  { $counts.BLOCKER++ }
                      "HIGH" { $counts.HIGH++ }
                      "MEDIUM"    { $counts.MEDIUM++ }
                      "LOW"    { $counts.LOW++ }
                      "INFO"     { $counts.INFO++ }
                    }
                } #>
        
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
        
          # Step 3: Pretty-print module severity breakdown with conditional icons
          if ($moduleAgg.Count -gt 0) {
          echo "### 📦 SonarCloud Module Impact-Severity" >> $env:GITHUB_STEP_SUMMARY
          echo "| Module | 🟥 BLOCKER | 🟧 HIGH | 🟨 MEDIUM | 🟦 LOW  | ℹ INFO |" >> $env:GITHUB_STEP_SUMMARY
          echo "|--------|------------|---------|----------|--------|--------|" >> $env:GITHUB_STEP_SUMMARY
          foreach ($mod in $moduleAgg.Keys) {
          $b = $moduleAgg[$mod]
        
          function Mark($count) {
            if ($count -eq 0) { return "✅ $count" }
            elseif ($count -le 5) { return "🟡 $count" }
            else { return "🔴 $count" }
          } # end of function Mark
        
          echo "| **$mod** | $(Mark $b.BLOCKER) | $(Mark $b.HIGH) | $(Mark $b.MEDIUM) | $(Mark $b.LOW) | $(Mark $b.INFO) |" >> $env:GITHUB_STEP_SUMMARY
          }
        }
        
        # Step 4: Export results as an output variable for email step
        # Example: "udemy_lpa_javamasterclass:0,2,15,5,0;misc_utils:0,1,8,4,0"
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
        # Export both plain breakdown and HTML table
        "EMAIL_BREAKDOWN=$emailModuleSevAggBreakdown" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
        "EMAIL_MODULE_SEV_AGG_TABLE=$emailModuleSevAggTable" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
