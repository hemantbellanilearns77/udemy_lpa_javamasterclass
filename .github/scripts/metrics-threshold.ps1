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
Write-Host "🚀 DEBUG: Script started..."
Write-Host "DEBUG: checkstyle = $checkstyle"
Write-Host "DEBUG: pmd        = $pmd"
Write-Host "DEBUG: sonarBlocker = $sonarBlocker"
Write-Host "DEBUG: sonarHigh    = $sonarHigh"
Write-Host "DEBUG: sonarMedium  = $sonarMedium"
Write-Host "DEBUG: sonarLow     = $sonarLow"
Write-Host "DEBUG: sonarInfo    = $sonarInfo"
Write-Host "DEBUG: sonarCoverage = $sonarCoverage"
Write-Host "DEBUG: jobStatus     = $jobStatus"

$passed = $true

if ($checkstyle -gt [int]$env:CHECKSTYLE_MAX_VIOLATIONS) { $passed = $false }
if ($pmd        -gt [int]$env:PMD_MAX_VIOLATIONS)        { $passed = $false }
if ($sonarBlocker    -gt [int]$env:BLOCKER_MAX)               { $passed = $false }
if ($sonarHigh   -gt [int]$env:HIGH_MAX)              { $passed = $false }
if ($sonarMedium       -gt [int]$env:MEDIUM_MAX)                  { $passed = $false }
if ($sonarLow     -gt [int]$env:LOW_MAX)                { $passed = $false }
if ($sonarInfo       -gt [int]$env:INFO_MAX)                  { $passed = $false }
if ($sonarCoverage   -lt [double]$env:JACOCO_MIN_COVERAGE)    { $passed = $false }
if ($jobStatus  -ne "success")                           { $passed = $false }

$HygieneCheckStatus = if ($passed) { "PASSED ✅" } else { "FAILED ❌" }

Write-Host "✅ HygieneCheckStatus calculated as: $HygieneCheckStatus"

# Emit output
"HygieneCheckStatus=$HygieneCheckStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
