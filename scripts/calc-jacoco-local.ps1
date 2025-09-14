param(
    [string]$reportPath = "D:\GitHubRepos\udemy_lpa_javamasterclass\reports\jacoco\jacoco-latest.xml"
)

if (-not (Test-Path $reportPath)) {
    Write-Output "Jacoco report missing"
    exit 1
}

[xml]$xml = Get-Content $reportPath
$c = $xml.report.counter | Where-Object { $_.type -eq 'LINE' -or $_.type -eq 'BRANCH' }

if ($c) {
    $cov  = ($c | Measure-Object -Property covered -Sum).Sum
    $miss = ($c | Measure-Object -Property missed -Sum).Sum
    $t = $cov + $miss
    if ($t -ne 0) {
        $pct = '{0:N1}%%' -f (($cov * 100.0) / $t)
        Write-Host $pct -NoNewline   # 👈 ensures *just* the number+% on one line
    } else {
        Write-Host "0%%" -NoNewline
    }
} else {
    Write-Host "Jacoco report missing" -NoNewline
}
