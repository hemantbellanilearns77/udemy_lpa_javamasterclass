        ############################################################
                    # === Write Overall Table ===
        ############################################################
        echo "### 📊 Hygiene Summary (Checkstyle + PMD + JaCoCo + Sonar)" >> $env:GITHUB_STEP_SUMMARY
        echo "Repository: $repository " >> $env:GITHUB_STEP_SUMMARY
        echo "Branch: $branch" >> $env:GITHUB_STEP_SUMMARY
        echo "Stage ↔ Main state: $env:STAGE_VS_MAIN_STATE" >> $env:GITHUB_STEP_SUMMARY
        echo "| **Metric**               | **Value** |" >> $env:GITHUB_STEP_SUMMARY
        echo "|------------------------- |-----------|" >> $env:GITHUB_STEP_SUMMARY
        echo "| 📈 Code Coverage (Sonar)    | $sonarCoverage % $coverageStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🎯 Coverage Visual          | <code>$coverageBar</code> |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 📝 Checkstyle Violations    | $checkstyleViolations |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🔍 PMD Violations           | $pmdViolations |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🗂 SonarCloud            | Execution: <code>$sonarExecutionNote</code><br/>Issues: <code>$sonarIssuesNote</code><br/>Last Analysis: <code>$lastSonarAnalysis</code> |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟥 BLOCKER               | [$blocker]($($severityLinks.BLOCKER)) $sonarBlockerStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟧 HIGH                  | [$high]($($severityLinks.HIGH)) $sonarHighStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟨 MEDIUM                | [$medium]($($severityLinks.MEDIUM)) $sonarMediumStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| 🟦 LOW                   | [$low]($($severityLinks.LOW)) $sonarLowStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| ℹ INFO                  | [$info]($($severityLinks.INFO)) $sonarInfoStatus |" >> $env:GITHUB_STEP_SUMMARY
        echo "| Legend                  | $sonarIssuesLegend |" >> $env:GITHUB_STEP_SUMMARY
        echo "🌐 [View SonarCloud Overall Code Dashboard]($sonarOverallCodeDashBoardUrl)" >> $env:GITHUB_STEP_SUMMARY
        echo "🌐 [View SonarCloud Issues Breakdown Dashboard]($sonarOpenIssuesDashboardUrl)" >> $env:GITHUB_STEP_SUMMARY
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