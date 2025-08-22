@echo off
setlocal EnableDelayedExpansion

echo ===================================================
echo 🧹 All Hygiene Workflow — Checkstyle + PMD + JaCoCo + SonarCloud
echo ===================================================

:: === Preserve Original Directory ===
set "originalDir=%CD%"

:: === Navigate to Project Root ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT is !REPO_ROOT!

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

:: === Begin Composite Logging ===
echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 1: Checkstyle ===
if "%skip_checkstyle%"=="false" (
    echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
    call scripts\run-checkstyle.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
if "%skip_pmd%"=="false" (
    echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
    call scripts\run-pmd.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ PMD scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 3: JaCoCo ===
if "%skip_jacoco%"=="false" (
    echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
    call scripts\run-coverage-analysis.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping JaCoCo... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 4: SonarCloud ===
if "%skip_sonar%"=="false" (
    echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
    call scripts\run-sonar-scan-admin.bat >> "%hygieneLogPath%" 2>&1
    echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping SonarCloud scan... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"
:: === Wrap-Up ===
echo 🎯 All hygiene steps complete. | tee -a "%hygieneLogPath%"
echo 📄 Composite log available at: %hygieneLogPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"
pause