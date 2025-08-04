# parse-jacoco.ps1
[xml]$xml = Get-Content 'reports\jacoco\jacoco-latest.xml'
$c = $xml.report.counter | Where-Object { $_.type -eq 'INSTRUCTION' }

if ($c) {
  $covered = [int]$c.covered
  $missed = [int]$c.missed
  $total = $covered + $missed
  if ($total -ne 0) {
    '{0:N2}%%' -f (($covered * 100.0) / $total)
  } else {
    '0%%'
  }
} else {
  'Unavailable'
}
