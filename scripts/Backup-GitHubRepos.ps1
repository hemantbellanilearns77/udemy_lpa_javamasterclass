# Usage:
#   powershell.exe -ExecutionPolicy Bypass -File "D:\path\to\Backup-GitHubRepos.ps1" Execute
#   powershell.exe -ExecutionPolicy Bypass -File "D:\path\to\Backup-GitHubRepos.ps1" DryRun
param(
    [Parameter(Mandatory = $true)]
    [ValidateSet("DryRun", "Execute")]
    [string]$Mode
)

$source_dir      = "D:\GitHubRepos"
$backup_base_dir = "D:\CodeBackup"

$timestamp       = Get-Date -Format "yyyyMMdd_HHmm"
$destination_dir = Join-Path $backup_base_dir $timestamp

# Log will sit inside the destination (even for DryRun)
$logFile = Join-Path $destination_dir "backup_${Mode}_$timestamp.log"

Write-Host "🔍 Backup [$Mode] | $timestamp"
Write-Host "Source      : $source_dir"
Write-Host "Destination : $destination_dir"

if ($Mode -eq "DryRun") {
    New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null
    robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 /LOG:$logFile /NFL /NDL
    Write-Host "📜 Dry-run log: $logFile"
    exit 0
}

if ($Mode -eq "Execute") {
    if (!(Test-Path $destination_dir)) {
        New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null
    }

    robocopy $source_dir $destination_dir /MIR /MT:16 /Z /E /R:1 /W:1 /LOG:$logFile /NFL
    $exitCode = $LASTEXITCODE
    Write-Host "📜 Backup log: $logFile"

    if ($exitCode -le 3) {
        Write-Host "✅ Backup complete: $destination_dir"

        # Optional zip (comment this out if you don’t want zips)
        $zipPath = "${destination_dir}.zip"
        Add-Type -A System.IO.Compression.FileSystem
        [System.IO.Compression.ZipFile]::CreateFromDirectory($destination_dir, $zipPath)
        Write-Host "🗜️ Zipped backup at: $zipPath"
    }
    else {
        Write-Host "❌ Issues detected, see log."
        exit $exitCode
    }
}
