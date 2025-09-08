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

$timestamp       = Get-Date -Format "ddMMyy_HH-mm"
$destination_dir = Join-Path $backup_base_dir $timestamp


Write-Host "Backup Mode: $Mode | Timestamp: $timestamp"
Write-Host "Source Directory: $source_dir"
Write-Host "Destination Directory: $destination_dir"
# Folders and file patterns to exclude (from gitignore)
<# was 
$excludeDirs = @(
    ".idea", "target", "reports", "out", ".scannerwork", "logs", "purged", "purge-logs",
    "archived", "archival-logs", "tools", ".mtj.tmp"
) #>
$excludeDirs = @(
    ".idea", "target", "out", ".scannerwork", ".mtj.tmp", "jacoco", "tools"
)
# Convert to array for robocopy
# $XDparams = $excludeDirs | ForEach-Object { "/XD"; $_ }
$XDparams = $excludeDirs | ForEach-Object { "/XD"; ("`"" + $_ + "`"") }

if ($Mode -eq "DryRun") {
	$destination_dir = Join-Path $backup_base_dir ("DRYRUN_" + $timestamp)
    # Make sure folder exists
    New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null
	# Define log file **after** destination_dir is correct
    $logFile = Join-Path $destination_dir "backup_${Mode}_$timestamp.txt"

    # Run robocopy in dry-run mode
    # robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 $XDparams /LOG:$logFile /NFL /NDL
	robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 $XDparams /LOG:$logFile /NFL

    Write-Host "Dry-run complete. Log saved at: $logFile"
    exit 0
}

if ($Mode -eq "Execute") {
	$destination_dir = Join-Path $backup_base_dir ("GitHubRepos_Backup_" + $timestamp)
    # Ensure destination exists
    if (!(Test-Path $destination_dir)) {
        New-Item -ItemType Directory -Force -Path $destination_dir | Out-Null
    }
	# Define log file after destination_dir is finalized
    $logFile = Join-Path $destination_dir "backup_${Mode}_$timestamp.txt"

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
		# Safety check before deleting original folder
		if ((Test-Path $zipPath -PathType Leaf) -and ((Get-Item $zipPath).Length -gt 0)) {
			# Remove-Item -Recurse -Force $destination_dir
			# Use cmd.exe to safely remove folder with long paths
			cmd.exe /c "rd /s /q `"$destination_dir`""
			Write-Host "Original backup folder deleted after verifying zip."
		} else {
			Write-Host "Zip creation failed or file is empty. Original folder kept."
		}
    }
    else {
        Write-Host "Backup encountered issues. Check log at: $logFile"
        exit $exitCode
    }
}
