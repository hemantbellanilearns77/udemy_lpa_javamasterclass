# parse-jacoco-report.ps1
$path = "..\reports\jacoco\jacoco-latest.xml"
if (Test-Path $path) {
    [xml]$xml = Get-Content $path
    $counter = $xml.report.counter | Where-Object { $_.type -eq "INSTRUCTION" }
    if ($counter) {
        $covered = [int]$counter.covered
        $missed  = [int]$counter.missed
        $total = $covered + $missed
        if ($total -ne 0) {
            '{0:N2}%%' -f (($covered * 100.0) / $total)
        } else {
            '0%%'
        }
    } else {
        'Unavailable'
    }
} else {
    'Unavailable'
}
