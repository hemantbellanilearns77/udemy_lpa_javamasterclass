@echo off
setlocal EnableDelayedExpansion

REM echo ===================================================
REM echo ☕ SonarCloud Scan Initiator — Dynamic Branch (Preflight and Preview)
REM echo ===================================================

set "executionEnv=%~1"
if /i "%executionEnv%"=="githubactions" goto :github
if /i "%executionEnv%"=="local" goto :local
goto :unsupported

:github
REM echo === Running in GitHub Actions ===
:: Capture Start Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set startTime=%%t
REM timeout /t 3 >nul
:: Preserve Original Working Directory
set "originalDir=%CD%"
:: === Set working directory ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
REM echo REPO_ROOT %REPO_ROOT%
:: Timestamp Setup
for /f %%i in ('powershell -Command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: Extract Branch Name
set BRANCH_NAME=
for /f "tokens=2 delims==" %%B in ('findstr /i "sonar.branch.name" sonar-project.properties') do (
    set "BRANCH_NAME=%%B"
    set "BRANCH_NAME=!BRANCH_NAME: =!"
)

REM echo 🧪 Branch Name:     !BRANCH_NAME!

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
REM echo 🔍 Validating report paths...
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
REM echo ------------------------------------------
REM echo 📄 Checkstyle:   !checkstyleReportPath!
REM echo 📄 PMD:          !pmdReportPath!
REM echo 📄 JUnit Paths:
for %%p in (%junitPaths:,= %) do (
    REM echo   ↳ %%p
    if exist "%%p" dir /b "%%p"
)
if /I "%ENABLE_JACOCO%"=="true" (
    REM echo 📄 JaCoCo Execs:
    for %%p in (%jacocoPaths:,= %) do (
        REM echo   ↳ %%p
        if exist "%%p" dir /b "%%p"
    )
)
REM echo ------------------------------------------
echo After checking report paths >> "!logPath!"
REM :: Dry Run Check
REM if /I "%DRY_RUN%"=="true" (
    REM echo 🚧 Dry-run mode enabled — skipping SonarCloud push
    REM cd /d "%originalDir%"
    REM pause
    REM exit /b 0
REM )
for /f "tokens=1,2 delims==" %%a in (.env) do (
  if "%%a"=="SONAR_TOKEN" set SONAR_TOKEN=%%b
)

set "SCANNER=%SONAR_SCANNER_BIN%\sonar-scanner.bat"
if exist "%SCANNER%" (
  call "%SCANNER%" "-Dsonar.token=%SONAR_TOKEN%" > "!logPath!" 2>&1
  echo ✅ SonarCloud scan completed successfully. >> "!logPath!"
  REM echo ✅ SonarCloud scan completed successfully.
) else (
  echo ❌ sonar-scanner.bat not found at %SCANNER%
  echo SONAR_SCANNER_BIN is %SONAR_SCANNER_BIN%
  echo SCANNER is %SCANNER%
  exit /b 1
)
REM if ERRORLEVEL 1 (
  REM echo ❌ SonarCloud scan failed with error code %ERRORLEVEL%.
  REM exit /b %ERRORLEVEL%
REM ) else (
  REM REM echo ✅ SonarCloud scan completed successfully.
  REM echo ✅ Scan complete. Log saved to: !logPath!
REM )


REM :: Count Violations
REM set /a CHECKSTYLE_COUNT=0
REM set /a PMD_COUNT=0

REM for /f %%X in ('findstr /c:"<error " "!checkstyleReportPath!"') do (
    REM set /a CHECKSTYLE_COUNT+=1
REM )
REM for /f %%X in ('findstr /c:"<violation " "!pmdReportPath!"') do (
    REM set /a PMD_COUNT+=1
REM )


:: Capture End Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set endTime=%%t

:: Compute Duration (in minutes)
for /f %%d in ('powershell -command "[math]::Round((New-TimeSpan -Start '!startTime!' -End '!endTime!').TotalMinutes, 2)"') do set durationMinutes=%%d



REM :: Final Banner
REM echo ===================================================
REM echo 🌀 Scan Summary — Branch: !BRANCH_NAME!
REM echo 🔍 Log Path: !logPath! -- %timestamp%
REM echo 🕒 Start:    %startTime%
REM echo 🕒 End:      %endTime%
REM echo ⏱️ Duration: %durationMinutes% minutes
REM echo ✅ Checkstyle Violations: !CHECKSTYLE_COUNT!
REM echo ✅ PMD Violations:        !PMD_COUNT!
REM echo ===================================================

:: Mirror to Log File
REM (
    REM echo ================== SCAN SUMMARY ==================
    REM echo 🌀 Branch: !BRANCH_NAME!
    REM echo 🔍 Log Path :   !logPath! -- %timestamp%
    REM echo 🕒 Start:    !startTime!
    REM echo 🕒 End:      !endTime!
    REM echo ⏱️ Duration: !durationMinutes! minutes
    REM echo ✅ Checkstyle: !CHECKSTYLE_COUNT!
    REM echo ✅ PMD:        !PMD_COUNT!
    REM if "!warn!"=="true" (
        REM echo ⚠️  Warning: High violation count or long scan duration
    REM )
    REM echo ===================================================
REM ) >> "!logPath!"
goto :end

:local
chcp 65001 >nul
echo === Running Locally ===
:: Capture Start Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set startTime=%%t
timeout /t 3 >nul
:: Preserve Original Working Directory
set "originalDir=%CD%"
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT ------------  !REPO_ROOT!

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
    REM echo   ↳ %%p
    if exist "%%p" dir /b "%%p"
)
if /I "%ENABLE_JACOCO%"=="true" (
    REM echo 📄 JaCoCo Execs:
    for %%p in (%jacocoPaths:,= %) do (
        REM echo   ↳ %%p
        if exist "%%p" dir /b "%%p"
    )
)
REM echo ------------------------------------------

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
REM set "SCANNER=%REPO_ROOT%\tools\sonar-scanner-cli\bin\sonar-scanner.bat"
set "SCANNER=%REPO_ROOT%\tools\sonar-scanner-cli-7.2.0.5079-windows-x64\sonar-scanner-7.2.0.5079-windows-x64\bin\sonar-scanner.bat"

if exist "%SCANNER%" (
  REM call "%SCANNER%" -X "-Dsonar.token=%SONAR_TOKEN%"
  REM call "%SCANNER%" "-Dsonar.token=%SONAR_TOKEN%" > "!logPath!" 2>&1
  call "%SCANNER%" "-Dsonar.token=%SONAR_TOKEN%" > "!logPath!" 2>&1
) else (
  echo ❌ sonar-scanner.bat not found at %SCANNER%
  exit /b 1
)
  REM call sonar-scanner -X ^
  REM "-Dsonar.token=%SONAR_TOKEN%" ^
  REM > "!logPath!" 2>&1

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

:: Capture End Time
for /f %%t in ('powershell -command "Get-Date -Format 'HH:mm:ss'"') do set endTime=%%t

:: Compute Duration (in minutes)
for /f %%d in ('powershell -command "[math]::Round((New-TimeSpan -Start '!startTime!' -End '!endTime!').TotalMinutes, 2)"') do set durationMinutes=%%d

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
goto :end

:unsupported
echo Unsupported environment: %executionEnv%
exit /b 1

:end
REM echo SonarCloud Sonar-Scan Analysis complete.
cd /d "%originalDir%"
endlocal
exit /b 0
