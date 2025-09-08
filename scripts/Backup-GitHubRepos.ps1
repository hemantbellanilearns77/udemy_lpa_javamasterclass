# Backup-GitHubRepos.ps1
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

$timestamp       = Get-Date -Format "ddMMyyyy_HH-mm"
$destination_dir = Join-Path $backup_base_dir $timestamp

# Logs will sit inside the backup folder
$logFile = Join-Path $destination_dir "backup_${Mode}_$timestamp.txt"

Write-Host "Backup Mode: $Mode | Timestamp: $timestamp"
Write-Host "Source Directory: $source_dir"
Write-Host "Destination Directory: $destination_dir"
# Folders and file patterns to exclude (from gitignore)
$excludeDirs = @(
    ".idea", "target", "reports", "out", ".scannerwork", "logs", "purged", "purge-logs",
    "archived", "archival-logs", "tools", ".mtj.tmp"
)
# $XDparams = $excludeDirs | ForEach-Object { "/XD `"$($_)`"" }
$XDparams = $excludeDirs | ForEach-Object { "/XD", $_ }

if ($Mode -eq "DryRun") {
    # Make sure folder exists
    New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null

    # Run robocopy in dry-run mode
    # robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 $XDparams /LOG:$logFile /NFL /NDL
	robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 $XDparams /LOG:$logFile /NFL /NDL

    Write-Host "Dry-run complete. Log saved at: $logFile"
    exit 0
}

if ($Mode -eq "Execute") {
    # Ensure destination exists
    if (!(Test-Path $destination_dir)) {
        New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null
    }

    # Run real backup
    robocopy $source_dir $destination_dir /MIR /MT:16 /Z /E /R:1 /W:1 $XDparams /LOG:$logFile /NFL
    $exitCode = $LASTEXITCODE

    Write-Host "Backup complete. Log saved at: $logFile"

    if ($exitCode -le 3) {
        Write-Host "Backup of $source_dir finished successfully to $destination_dir"

        # Optional zip
        $zipPath = "${destination_dir}.zip"
        Add-Type -AssemblyName System.IO.Compression.FileSystem
        [System.IO.Compression.ZipFile]::CreateFromDirectory($destination_dir, $zipPath)
        Write-Host "Zipped backup at: $zipPath"
    }
    else {
        Write-Host "Backup encountered issues. Check log at: $logFile"
        exit $exitCode
    }
}
