@echo off
setlocal enabledelayedexpansion

set "reportPath=D:\GitHubRepos\udemy_lpa_javamasterclass\reports\jacoco\jacoco-latest.xml"

for /f "usebackq tokens=* delims=" %%i in (`powershell -nologo -noprofile -ExecutionPolicy Bypass -File "D:\GitHubRepos\udemy_lpa_javamasterclass\scripts\calc-jacoco-local.ps1" -reportPath "%reportPath%"`) do (
    set "jacocoSummary=%%i"
    goto :done
)

:done
if defined jacocoSummary (
    echo JaCoCo Coverage: !jacocoSummary!
) else (
    echo Jacoco report missing
)

endlocal
