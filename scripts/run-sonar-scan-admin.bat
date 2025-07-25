@echo off
echo ===================================================
echo ☕ SonarCloud Scan Initiator — Stage Branch (Preflight + Preview)
echo ===================================================

:: === Navigate to Project Root ===
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: === Config Toggles ===
set ENABLE_JACOCO=true
set STRICT_REPORT_CHECK=false
REM Future upgrade: set ENABLE_PREVIEW=true

:: === Path Definitions ===
set junitPaths=reports\junit\latest,misc_utils\reports\junit
set jacocoPaths=reports\jacoco\latest.exec,misc_utils\reports\jacoco.exec
set checkstyleReport=reports\checkstyle\checkstyle-*.txt
set pmdReport=reports\pmd\pmd-*.xml
set logFolder=logs\sonar-scan-logs
set logPath=%logFolder%\sonar-scan-%timestamp%.log

:: === Token Injection ===
set SONAR_TOKEN=6a22ba096673bafdca4fd3d92332fdf222cf8cad

:: === Create Log Directory If Needed ===
if not exist "%logFolder%" (
    mkdir "%logFolder%"
)

:: === Preflight Check: Report Paths Validation ===
echo 🔍 Validating report paths before scan...

setlocal enabledelayedexpansion
set failed=false

:: === Check Checkstyle ===
for %%F in (%checkstyleReport%) do (
    if not exist "%%F" (
        echo ❌ Checkstyle report missing: %%F
        set failed=true
    )
)

:: === Check PMD ===
for %%F in (%pmdReport%) do (
    if not exist "%%F" (
        echo ❌ PMD report missing: %%F
        set failed=true
    )
)

:: === Optional: JUnit Reports Check ===
for %%p in (%junitPaths:,= %) do (
    if not exist "%%p" (
        if /I "%STRICT_REPORT_CHECK%"=="true" (
            echo ❌ JUnit report path missing: %%p
            set failed=true
        ) else (
            echo ℹ️ Optional: JUnit report path missing: %%p — skipping test result injection.
        )
    )
)

:: === Optional: JaCoCo Reports Check ===
if /I "%ENABLE_JACOCO%"=="true" (
    for %%p in (%jacocoPaths:,= %) do (
        if not exist "%%p" (
            if /I "%STRICT_REPORT_CHECK%"=="true" (
                echo ❌ JaCoCo report path missing: %%p
                set failed=true
            ) else (
                echo ℹ️ Optional: JaCoCo exec missing: %%p — skipping coverage injection.
            )
        )
    )
) else (
    echo 🚫 JaCoCo coverage DISABLED
)

:: === Abort if core reports failed ===
if "!failed!"=="true" (
    echo 🛑 One or more required reports are missing. Aborting scan.
    pause
    exit /b 1
)

endlocal

:: === Preview Matched Reports ===
echo ------------------------------------------
echo 🔍 Previewing matched report files...

echo 📄 Checkstyle Reports:
dir /b %checkstyleReport%

echo 📄 PMD Reports:
dir /b %pmdReport%

echo 📄 JUnit Report Folders:
for %%p in (%junitPaths:,= %) do (
    echo   ↳ %%p
    if exist "%%p" dir /b "%%p"
)

if /I "%ENABLE_JACOCO%"=="true" (
    echo 📄 JaCoCo Files:
    for %%p in (%jacocoPaths:,= %) do (
        echo   ↳ %%p
        if exist "%%p" dir /b "%%p"
    )
) else (
    echo 🚫 JaCoCo disabled. Skipping preview.
)
echo ------------------------------------------

:: === Launch Sonar Scanner ===
echo 🚀 Launching SonarCloud scan for 'stage'...

call sonar-scanner ^
  "-Dsonar.token=%SONAR_TOKEN%" ^
  "-Dsonar.projectKey=hemantbellanilearns77_udemy_lpa_javamasterclass" ^
  "-Dsonar.organization=hemantbellanilearns77" ^
  "-Dsonar.branch.name=stage" ^
  "-Dsonar.java.checkstyle.reportPaths=%checkstyleReport%" ^
  "-Dsonar.java.pmd.reportPaths=%pmdReport%" ^
  > "%logPath%" 2>&1

echo ✅ Scan completed. Output saved to: %logPath%
pause