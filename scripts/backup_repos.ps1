param(
    [Parameter(Mandatory=$true)]
    [ValidateSet("DryRun", "Execute")]
    [string]$Mode
)

# Set your source and destination paths
$source_dir = "D:\GitHubRepos"
$backup_base_dir = "D:\CodeBackup"

Write-Host "🔍 Starting backup in [$Mode] mode..."
Write-Host "Source Directory     : ${source_dir}"
Write-Host "Backup Base Directory: ${backup_base_dir}"

# Show which repos (subdirectories) will be included
Write-Host "`n📂 Repositories detected under ${source_dir}:"
Get-ChildItem -Path $source_dir -Directory | ForEach-Object {
    Write-Host "   - $($_.Name)"
}

# Create a timestamp for the backup folder name (e.g., 20250903_1048)
$timestamp = Get-Date -Format "yyyyMMdd_HHmm"
$destination_dir = Join-Path -Path $backup_base_dir -ChildPath $timestamp

Write-Host "`nTimestamp            : $timestamp"
Write-Host "Destination Directory : ${destination_dir}"

# Logs
$dryRunLog   = Join-Path $backup_base_dir "dryrun_$timestamp.txt"
$backupLog   = Join-Path $backup_base_dir "backup_$timestamp.txt"

if ($Mode -eq "DryRun") {
    Write-Host "`n🚧 Performing DRY-RUN (no files copied)..."
    # robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 /LOG:$dryRunLog /TEE
	robocopy $source_dir $destination_dir /MIR /E /L /R:1 /W:1 /LOG:$dryRunLog /TEE /NFL /NDL
    Write-Host "📜 Dry-run log saved at: ${dryRunLog}"
    Write-Host "✅ Dry-run completed. No files were copied."
    exit 0
}

if ($Mode -eq "Execute") {
    # Ensure the destination directory is created
    if (!(Test-Path $destination_dir)) {
        New-Item -ItemType Directory -Path $destination_dir | Out-Null
        Write-Host "✅ Created backup folder: ${destination_dir}"
    } else {
        Write-Host "⚠️ Destination already exists, this should not usually happen: ${destination_dir}"
    }

    # Run real backup
    Write-Host "🚀 Running robocopy for REAL backup..."
    robocopy $source_dir $destination_dir /MIR /MT:16 /Z /E /R:1 /W:1 /LOG:$backupLog /TEE /NFL

    $exitCode = $LASTEXITCODE
    Write-Host "Robocopy exit code: $exitCode"
    Write-Host "📜 Robocopy log saved at: ${backupLog}"

    if ($exitCode -le 3) {
        Write-Host "✅ Backup of ${source_dir} complete. Saved to ${destination_dir}"
    } else {
        Write-Host "❌ Backup encountered issues. Check log at: ${backupLog}"
        exit $exitCode
    }
}
