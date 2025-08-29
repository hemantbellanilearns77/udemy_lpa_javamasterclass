# calculate-hygiene-status.ps1

param(
    [int]$CheckstyleViolations = $env:CHECKSTYLE_VIOLATIONS,
    [int]$PmdViolations       = $env:PMD_VIOLATIONS,
    [int]$Blocker             = $env:BLOCKER,
    [int]$High                = $env:HIGH,
    [int]$Medium              = $env:MEDIUM,
    [int]$Info                = $env:INFO,
    [double]$Coverage         = $env:SONAR_COVERAGE,
    [string]$JobStatus        = $env:JOB_STATUS
)

# Thresholds from environment variables
$CheckstyleMax = [int]$env:CHECKSTYLE_MAX_VIOLATIONS
$PmdMax        = [int]$env:PMD_MAX_VIOLATIONS
$BlockerMax    = [int]$env:BLOCKER_MAX
$HighMax       = [int]$env:HIGH_MAX
$MediumMax     = [int]$env:MEDIUM_MAX
$InfoMax       = [int]$env:INFO_MAX
$CoverageMin   = [double]$env:JACOCO_MIN_COVERAGE

# Function to calculate HygieneCheckStatus
function Get-HygieneCheckStatus {
    param (
        [int]$checkstyle,
        [int]$pmd,
        [int]$blocker,
        [int]$high,
        [int]$medium,
        [int]$info,
        [double]$coverage,
        [string]$jobStatus
    )

    if ($jobStatus -eq 'success' `
        -and $checkstyle -lt $CheckstyleMax `
        -and $pmd -lt $PmdMax `
        -and $blocker -le $BlockerMax `
        -and $high -le $HighMax `
        -and $medium -le $MediumMax `
        -and $info -le $InfoMax `
        -and $coverage -ge $CoverageMin) {
        return "PASSED ✅"
    } else {
        return "FAILED ❌"
    }
}

# Compute status
$HygieneCheckStatus = Get-HygieneCheckStatus `
    -checkstyle $CheckstyleViolations `
    -pmd $PmdViolations `
    -blocker $Blocker `
    -high $High `
    -medium $Medium `
    -info $Info `
    -coverage $Coverage `
    -jobStatus $JobStatus

Write-Host "✅ HygieneCheckStatus calculated as: $HygieneCheckStatus"

# Output to GitHub Actions
" HygieneCheckStatus=$HygieneCheckStatus" | Out-File -FilePath $env:GITHUB_OUTPUT -Append