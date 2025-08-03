@echo off
setlocal EnableDelayedExpansion

echo ===================================================
echo ☕ SonarCloud Scan Initiator — Dynamic Branch (Preflight + Preview)
echo ===================================================
:: Capture Start Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set startTime=%%t
timeout /t 3 >nul
:: Preserve Original Working Directory
set "originalDir=%CD%"
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: Timestamp Setup
for /f %%i in ('powershell -Command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: Extract Branch Name
set BRANCH_NAME=
for /f "tokens=2 delims==" %%B in ('findstr /i "sonar.branch.name" sonar-project.properties') do (
    set "BRANCH_NAME=%%B"
    set "BRANCH_NAME=!BRANCH_NAME: =!"
)

echo 🧪 Branch Name:     !BRANCH_NAME!

:: Config Toggles
set ENABLE_JACOCO=true
set STRICT_REPORT_CHECK=false
set DRY_RUN=false

:: Paths
REM set junitPaths=reports\junit\latest,misc_utils\reports\junit
set junitPaths=reports\junit\latest
set jacocoPaths=reports\jacoco\jacoco-latest.exec
set logFolder=logs\sonar-scan
set logPath=%logFolder%\sonar-%timestamp%.txt

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

:: Inject Sonar Token
REM set SONAR_TOKEN=not-sharing it here... 

:: Create Log Folder
if not exist "%logFolder%" mkdir "%logFolder%"

:: Preflight Report Checks
echo 🔍 Validating report paths...
set failed=false

if not exist "!checkstyleReportPath!" (
    echo ❌ Checkstyle report missing: !checkstyleReportPath!
    set failed=true
)
if not exist "!pmdReportPath!" (
    echo ❌ PMD report missing: !pmdReportPath!
    set failed=true
)

for %%p in (%junitPaths:,= %) do (
    if not exist "%%p" (
        if /I "%STRICT_REPORT_CHECK%"=="true" (
            echo ❌ JUnit missing: %%p
            set failed=true
        ) else (
            echo ℹ️ Optional JUnit missing: %%p
        )
    )
)

if /I "%ENABLE_JACOCO%"=="true" (
    for %%p in (%jacocoPaths:,= %) do (
        if not exist "%%p" (
            if /I "%STRICT_REPORT_CHECK%"=="true" (
                echo ❌ JaCoCo exec missing: %%p
                set failed=true
            ) else (
                echo ℹ️ Optional JaCoCo missing: %%p
            )
        )
    )
) else (
    echo 🚫 JaCoCo DISABLED
)

if "!failed!"=="true" (
    echo 🛑 Aborting scan: Required reports missing.
    cd /d "%originalDir%"
    pause
    exit /b 1
)

:: Preview Reports
echo ------------------------------------------
echo 📄 Checkstyle:   !checkstyleReportPath!
echo 📄 PMD:          !pmdReportPath!
echo 📄 JUnit Paths:
for %%p in (%junitPaths:,= %) do (
    echo   ↳ %%p
    if exist "%%p" dir /b "%%p"
)
if /I "%ENABLE_JACOCO%"=="true" (
    echo 📄 JaCoCo Execs:
    for %%p in (%jacocoPaths:,= %) do (
        echo   ↳ %%p
        if exist "%%p" dir /b "%%p"
    )
)
echo ------------------------------------------

:: Dry Run Check
if /I "%DRY_RUN%"=="true" (
    echo 🚧 Dry-run mode enabled — skipping SonarCloud push
    cd /d "%originalDir%"
    pause
    exit /b 0
)
for /f "tokens=1,2 delims==" %%a in (.env) do (
  if "%%a"=="SONAR_TOKEN" set SONAR_TOKEN=%%b
)
:: Launch Scanner
echo 🚀 Running SonarCloud scan — Branch: !BRANCH_NAME!
call sonar-scanner -X ^
  "-Dsonar.token=%SONAR_TOKEN%" ^
  > "!logPath!" 2>&1

echo ✅ Scan complete. Log saved to: !logPath!

:: Count Violations
set /a CHECKSTYLE_COUNT=0
set /a PMD_COUNT=0

for /f %%X in ('findstr /c:"<error " "!checkstyleReportPath!"') do (
    set /a CHECKSTYLE_COUNT+=1
)
for /f %%X in ('findstr /c:"<violation " "!pmdReportPath!"') do (
    set /a PMD_COUNT+=1
)

:: Warning Thresholds
set warn=false
if !durationMinutes! GEQ 5 (
    set warn=true
)
if !CHECKSTYLE_COUNT! GEQ 1000 (
    set warn=true
)
if !PMD_COUNT! GEQ 100 (
    set warn=true
)
:: Capture End Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set endTime=%%t

:: Compute Duration (in minutes)
for /f %%d in ('powershell -command "[math]::Round((New-TimeSpan -Start '!startTime!' -End '!endTime!').TotalMinutes, 2)"') do set durationMinutes=%%d



:: Final Banner
echo ===================================================
echo 🌀 Scan Summary — Branch: !BRANCH_NAME!
echo 🔍 Log Path: !logPath! -- %timestamp%
echo 🕒 Start:    %startTime%
echo 🕒 End:      %endTime%
echo ⏱️ Duration: %durationMinutes% minutes
echo ✅ Checkstyle Violations: !CHECKSTYLE_COUNT!
echo ✅ PMD Violations:        !PMD_COUNT!
if "!warn!"=="true" (
    echo ⚠️  Warning: High violation count or long scan duration
)
echo ===================================================

:: Mirror to Log File
(
    echo ================== SCAN SUMMARY ==================
    echo 🌀 Branch: !BRANCH_NAME!
    echo 🔍 Log Path :   !logPath! -- %timestamp%
    echo 🕒 Start:    !startTime!
    echo 🕒 End:      !endTime!
    echo ⏱️ Duration: !durationMinutes! minutes
    echo ✅ Checkstyle: !CHECKSTYLE_COUNT!
    echo ✅ PMD:        !PMD_COUNT!
    if "!warn!"=="true" (
        echo ⚠️  Warning: High violation count or long scan duration
    )
    echo ===================================================
) >> "!logPath!"

cd /d "%originalDir%"
pause