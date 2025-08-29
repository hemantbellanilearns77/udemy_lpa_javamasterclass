param(
    [int]$checkstyle,
    [int]$pmd,
    [int]$sonarBlocker,
    [int]$sonarHigh,
    [int]$sonarMedium,
    [int]$sonarLow,
    [int]$sonarInfo,
    [double]$sonarCoverage,
    [string]$jobStatus
)

Write-Host "🧮 Evaluating metrics against thresholds..."

$passed = $true

if ($checkstyle -gt [int]$env:CHECKSTYLE_MAX_VIOLATIONS) { $passed = $false }
if ($pmd        -gt [int]$env:PMD_MAX_VIOLATIONS)        { $passed = $false }
if ($blocker    -gt [int]$env:BLOCKER_MAX)               { $passed = $false }
if ($critical   -gt [int]$env:CRITICAL_MAX)              { $passed = $false }
if ($high       -gt [int]$env:HIGH_MAX)                  { $passed = $false }
if ($medium     -gt [int]$env:MEDIUM_MAX)                { $passed = $false }
if ($info       -gt [int]$env:INFO_MAX)                  { $passed = $false }
if ($coverage   -lt [double]$env:JACOCO_MIN_COVERAGE)    { $passed = $false }
if ($jobStatus  -ne "success")                           { $passed = $false }

$HygieneCheckStatus = if ($passed) { "PASSED ✅" } else { "FAILED ❌" }

Write-Host "✅ HygieneCheckStatus calculated as: $HygieneCheckStatus"

# Emit output
"HygieneCheckStatus=$HygieneCheckStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
