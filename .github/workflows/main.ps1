$startEpoch = [int]$env:START_EPOCH
$endEpoch = [int][double]::Parse((Get-Date -UFormat %s))

$startDT = [System.DateTimeOffset]::FromUnixTimeSeconds($startEpoch).ToLocalTime().ToString("yyyy-MM-dd HH:mm:ss")
$endDT = [System.DateTimeOffset]::FromUnixTimeSeconds($endEpoch).ToLocalTime().ToString("yyyy-MM-dd HH:mm:ss")

$durationSec = $endEpoch - $startEpoch
$mins = [math]::Floor($durationSec / 60)
$secs = $durationSec % 60
$durationFormatted = "{0}m {1}s" -f $mins, $secs

echo "startTime=$startDT" >> $env:GITHUB_OUTPUT
echo "endTime=$endDT" >> $env:GITHUB_OUTPUT
echo "formattedDuration=$durationFormatted" >> $env:GITHUB_OUTPUT
