param(
    [int]$checkstyleCount,
    [int]$pmdCount,
    [int]$sonarBlocker,
    [int]$sonarHigh,
    [int]$sonarMedium,
    [int]$sonarLow,
    [int]$sonarInfo,
    [string]$sonarCoverage,
    [string]$outcome
)

Write-Host "🧮 Evaluating metrics against strict thresholds..."
$passed = $true
$NextStepsHtml = ""
$sonarHasNextSteps=$false

# --- Convert coverage safely ---
$coverageValue = [double]($sonarCoverage -replace '[^0-9\.]', '')

 # --- Aggregate violations ---
$totalCodeViolations = $checkstyleCount + $pmdCount
if ($totalCodeViolations -gt [int]$env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Total code violations exceed allowed maximum ($totalCodeViolations > $($env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS)).</li>"
}

if ($checkstyleCount -gt [int]$env:CHECKSTYLE_MAX_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Fix Checkstyle violations ($checkstyleCount > $($env:CHECKSTYLE_MAX_VIOLATIONS)).</li>"
}

if ($pmdCount -gt [int]$env:PMD_MAX_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Fix pmdCount violations ($pmdCount > $($env:PMD_MAX_VIOLATIONS)).</li>"
}
# --- Sonar Severity Checks with detailed reporting ---
$SonarNextStepsHtml += "<li>Resolve Issues that exceeded threshold per severity:</li>"
$SonarNextStepsHtml += "<ul>"
# Blocker
if ($sonarBlocker -gt [int]$env:BLOCKER_MAX) {
    $sonarHasNextSteps=$true
    $SonarNextStepsHtml += "<li>🟥 BLOCKER Issues: $sonarBlocker / $($env:BLOCKER_MAX) 🔴 (Exceeded)</li>"
}

# High
if ($sonarHigh -gt [int]$env:HIGH_MAX) {
    $sonarHasNextSteps=$true
    $SonarNextStepsHtml += "<li>🟧 HIGH Issues: $sonarHigh / $($env:HIGH_MAX) 🔴 (Exceeded)</li>"
}

# Medium
if ($sonarMedium -gt [int]$env:MEDIUM_MAX) {
    $sonarHasNextSteps=$true
    $SonarNextStepsHtml += "<li>🟨 MEDIUM Issues: $sonarMedium / $($env:MEDIUM_MAX) 🔴 (Exceeded)</li>"
}

# Low
if ($sonarLow -gt [int]$env:LOW_MAX) {
    $sonarHasNextSteps=$true
    $SonarNextStepsHtml += "<li>🟦 LOW Issues: $sonarLow / $($env:LOW_MAX) 🔴 (Exceeded)</li>"
}

# Info
if ($sonarInfo -gt [int]$env:INFO_MAX) {
    $sonarHasNextSteps=$true
    $SonarNextStepsHtml += "<li>ℹ️ INFO Issues: $sonarInfo / $($env:INFO_MAX) 🔴 (Exceeded)</li>"
}

$SonarNextStepsHtml += "</ul>"
if($sonarHasNextSteps) {$NextStepsHtml += $SonarNextStepsHtml }

# --- Coverage ---
if ($coverageValue -lt [double]$env:JACOCO_MIN_COVERAGE) {
    $passed = $false
    $NextStepsHtml += "<li>Increase test coverage (currently $coverageValue%, minimum required $($env:JACOCO_MIN_COVERAGE)%).</li>"
}

# --- Job Status ---
if ($outcome -ne "success") {
    $passed = $false
    $NextStepsHtml += "<li>Job did not succeed (status: $jobStatus).</li>"
}
# --- Laud Hygiene if no issues ---
if ([string]::IsNullOrWhiteSpace($NextStepsHtml)) {
    $NextStepsHtml = "<li>Great job! Hygiene is excellent ✅</li>"
}

# --- Final Status ---
$HygieneCheckStatus = if ($passed) { "PASSED ✅" } else { "FAILED ❌" }
Write-Host "✅ HygieneCheckStatus: $HygieneCheckStatus"

# --- Emit outputs ---
"HygieneCheckStatus=$HygieneCheckStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
"NextStepsHtml=$NextStepsHtml" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
