@echo off
echo ===================================================
echo ☕ SonarCloud Scan Initiator — Stage Branch (Preflight + Preview)
echo ===================================================

:: === Preserve Original Working Directory ===
set "originalDir=%CD%"

:: === Navigate to Project Root ===
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: === Config Toggles ===
set ENABLE_JACOCO=true
set STRICT_REPORT_CHECK=false

:: === Path Definitions ===
set junitPaths=reports\junit\latest,misc_utils\reports\junit
set jacocoPaths=reports\jacoco\latest.exec,misc_utils\reports\jacoco.exec
set logFolder=logs\sonar-scan-logs
set logPath=%logFolder%\sonar-scan-%timestamp%.log

:: === Locate and Normalize Checkstyle + PMD Reports ===
for %%F in (reports\checkstyle\checkstyle-*.xml) do (
    set "checkstyleReportPath=%%F"
)
for %%F in (reports\pmd\pmd-*.xml) do (
    set "pmdReportPath=%%F"
)

set "checkstyleReportPath=%checkstyleReportPath:\=/%"
set "pmdReportPath=%pmdReportPath:\=/%"

:: === Inject Token ===
set SONAR_TOKEN=6a22ba096673bafdca4fd3d92332fdf222cf8cad

:: === Create Log Directory If Missing ===
if not exist "%logFolder%" (
    mkdir "%logFolder%"
)

:: === Preflight Report Checks ===
echo 🔍 Validating report paths...

setlocal enabledelayedexpansion
set failed=false

if not exist "%checkstyleReportPath%" (
    echo ❌ Checkstyle XML missing: %checkstyleReportPath%
    set failed=true
)

if not exist "%pmdReportPath%" (
    echo ❌ PMD report missing: %pmdReportPath%
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
    echo 🛑 Abort: Required reports missing.
    pause
    exit /b 1
)

endlocal

:: === Preview Report Files ===
echo ------------------------------------------
echo 📄 Checkstyle:
echo   ↳ %checkstyleReportPath%
echo 📄 PMD:
echo   ↳ %pmdReportPath%
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

:: === Launch Scanner ===
echo 🚀 Running SonarCloud scan (stage)...

call sonar-scanner ^
  "-Dsonar.token=%SONAR_TOKEN%" ^
  "-Dsonar.projectKey=hemantbellanilearns77_udemy_lpa_javamasterclass" ^
  "-Dsonar.organization=hemantbellanilearns77" ^
  "-Dsonar.branch.name=stage" ^
  "-Dsonar.java.checkstyle.reportPaths=%checkstyleReportPath%" ^
  "-Dsonar.java.pmd.reportPaths=%pmdReportPath%" ^
  > "%logPath%" 2>&1

echo ✅ Scan complete. Log saved to: %logPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"
pause