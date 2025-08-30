param(
    [int]$checkstyle,
    [int]$pmd,
    [int]$sonarBlocker,
    [int]$sonarHigh,
    [int]$sonarMedium,
    [int]$sonarLow,
    [int]$sonarInfo,
    [string]$sonarCoverage,
    [string]$jobStatus
)

Write-Host "🧮 Evaluating metrics against strict thresholds..."
$passed = $true
$NextStepsHtml = ""

# --- Convert coverage safely ---
$coverageValue = [double]($sonarCoverage -replace '[^0-9\.]', '')

# --- Aggregate violations ---
$totalCodeViolations = $checkstyle + $pmd
if ($totalCodeViolations -gt [int]$env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Total code violations exceed allowed maximum ($totalCodeViolations > $($env:CHECKSTYLE_PMD_MAX_TOTAL_VIOLATIONS)).</li>"
}

if ($checkstyle -gt [int]$env:CHECKSTYLE_MAX_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Fix Checkstyle violations ($checkstyle > $($env:CHECKSTYLE_MAX_VIOLATIONS)).</li>"
}

if ($pmd -gt [int]$env:PMD_MAX_VIOLATIONS) {
    $passed = $false
    $NextStepsHtml += "<li>Fix PMD violations ($pmd > $($env:PMD_MAX_VIOLATIONS)).</li>"
}

# --- Sonar Severity Checks ---
if ($sonarBlocker -gt [int]$env:BLOCKER_MAX) {
    $passed = $false
    $NextStepsHtml += "<li>Resolve all Blocker issues ($sonarBlocker > 0).</li>"
}
if ($sonarHigh -gt [int]$env:HIGH_MAX) {
    $passed = $false
    $NextStepsHtml += "<li>High severity issues exceeded threshold ($sonarHigh > $($env:HIGH_MAX)).</li>"
}
if ($sonarMedium -gt [int]$env:MEDIUM_MAX) {
    $passed = $false
    $NextStepsHtml += "<li>Medium severity issues exceeded threshold ($sonarMedium > $($env:MEDIUM_MAX)).</li>"
}
if ($sonarLow -gt [int]$env:LOW_MAX) {
    $passed = $false
    $NextStepsHtml += "<li>Low severity issues exceeded threshold ($sonarLow > $($env:LOW_MAX)).</li>"
}
if ($sonarInfo -gt [int]$env:INFO_MAX) {
    $passed = $false
    $NextStepsHtml += "<li>Info severity issues exceeded threshold ($sonarInfo > $($env:INFO_MAX)).</li>"
}

# --- Coverage ---
if ($coverageValue -lt [double]$env:JACOCO_MIN_COVERAGE) {
    $passed = $false
    $NextStepsHtml += "<li>Increase test coverage (currently $coverageValue%, minimum required $($env:JACOCO_MIN_COVERAGE)%).</li>"
}

# --- Job Status ---
if ($jobStatus -ne "success") {
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
