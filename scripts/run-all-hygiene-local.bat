@echo off
setlocal EnableDelayedExpansion

echo ===================================================
echo 🧹 All Hygiene Workflow — Checkstyle + PMD + JaCoCo + SonarCloud
echo ===================================================

:: === Preserve Original Directory ===
set "originalDir=%CD%"
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
REM echo REPO_ROOT ------------  !REPO_ROOT!

:: === Parse Skip Flags ===
set skip_checkstyle=false
set skip_pmd=false
set skip_jacoco=false
set skip_sonar=false

for %%A in (%*) do (
    if /I "%%~A"=="--skip-checkstyle" set skip_checkstyle=true
    if /I "%%~A"=="--skip-pmd" set skip_pmd=true
    if /I "%%~A"=="--skip-jacoco" set skip_jacoco=true
    if /I "%%~A"=="--skip-sonar" set skip_sonar=true
)

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

:: === Log Directory Setup ===
set "hygieneLogFolder=logs\all-hygiene-logs"
set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.txt"
if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"

echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 1: Checkstyle ===
if "%skip_checkstyle%"=="false" (
    echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
    call scripts\run-checkstyle-local.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
if "%skip_pmd%"=="false" (
    echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
    call scripts\run-pmd-local.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ PMD scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 3: JaCoCo ===
if "%skip_jacoco%"=="false" (
    echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
    call scripts\run-coverage-analysis-local.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping JaCoCo... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 4: SonarCloud ===
if "%skip_sonar%"=="false" (
    echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
    call scripts\run-sonar-scan-admin-local.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping SonarCloud scan... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === FINAL SUMMARY (based on previous reports) ===
echo 📊 Generating Hygiene Summary... >> "%hygieneLogPath%"

setlocal EnableDelayedExpansion



:: Locate Checkstyle Report
set checkstyleReportPath=
for /f "delims=" %%F in ('dir /b /a:-d /o-d reports\checkstyle\checkstyle-*.xml') do (
    set "checkstyleReportPath=reports\checkstyle\%%F"
    goto :foundCheckstyle
)
:foundCheckstyle


:: Locate PMD Report
set pmdReportPath=
for /f "delims=" %%F in ('dir /b /a:-d /o-d reports\pmd\pmd-*.xml') do (
    set "pmdReportPath=reports\pmd\%%F"
    goto :foundPMD
)
:foundPMD

:: Validating Report findings
echo ?? Validating report paths...
set failed=false

if not exist "!checkstyleReportPath!" (
    echo ? Checkstyle report missing: !checkstyleReportPath!
    set failed=true
)
if not exist "!pmdReportPath!" (
    echo ? PMD report missing: !pmdReportPath!
    set failed=true
)
:: --- Checkstyle Violation Count ---
set /a checkstyleCount=0
for /f %%X in ('findstr /c:"<error " "!checkstyleReportPath!"') do (
    set /a checkstyleCount+=1
)
:: --- PMD Violation Count ---
set /a pmdCount=0
for /f %%X in ('findstr /c:"<violation " "!pmdReportPath!"') do (
    set /a pmdCount+=1
)

:: --- JaCoCo Coverage via PowerShell ---
if exist "reports\jacoco\jacoco-latest.xml" ( 
    for /f %%i in ('powershell -nologo -noprofile -Command "[xml]$xml = Get-Content 'reports\\jacoco\\jacoco-latest.xml'; $c = $xml.report.counter | Where-Object { $_.type -eq 'INSTRUCTION' }; if ($c) { $cov = [int]$c.covered; $miss = [int]$c.missed; $t = $cov + $miss; if ($t -ne 0) { '{0:N2}%%' -f (($cov * 100.0) / $t) } else { '0%%'} } else { '	 Jacoco report missing' }" ') do (
        set "jacocoTemp=%%i"
    )
)
if defined jacocoTemp (
    set "jacocoSummary=%jacocoTemp%"
)
REM echo ?? OutsideDo Code Coverage (JaCoCo): %jacocoSummary%
REM echo ?? OutsideDo Code Coverage (JaCoCo): !jacocoSummary!

echo ?? Final Summary
echo Checkstyle Violations: !checkstyleCount!
echo PMD Violations:        !pmdCount!
echo Code Coverage - JaCoCo: !jacocoSummary!

:: --- Summary Output ---
echo --------------------------------------------------- >> "%hygieneLogPath%"
echo 🧪 Hygiene Summary — %timestamp% >> "%hygieneLogPath%"
echo Checkstyle Violations: !checkstyleCount! >> "%hygieneLogPath%"
echo PMD Violations:        !pmdCount! >> "%hygieneLogPath%"
echo Code Coverage - JaCoCo: %jacocoSummary%  >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"
endlocal
echo 🎯 All hygiene steps complete. Composite log:
echo %hygieneLogPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"

