@echo off
echo ===================================================
echo 🧹 All Hygiene Workflow — Checkstyle + PMD + SonarCloud
echo ===================================================



:: === Preserve Original Directory ===
set "originalDir=%CD%"
:: === Navigate to Project Root ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT ------------  !REPO_ROOT!

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
echo 🚀 Step 1: Running Checkstyle... | tee -a "%hygieneLogPath%"
call scripts\run-checkstyle-local.bat >> "%hygieneLogPath%" 2>&1
echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
echo 🚀 Step 2: Running PMD... | tee -a "%hygieneLogPath%"
call scripts\run-pmd-local.bat >> "%hygieneLogPath%" 2>&1
echo ✅ PMD scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: JACOCO ===
echo 🚀 Step 3: Running JACOCO... | tee -a "%hygieneLogPath%"
call scripts\run-coverage-analysis-local.bat >> "%hygieneLogPath%" 2>&1
echo ✅ JACOCO Analysis completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"
:: === Step 4: SonarCloud Scan ===
echo 🚀 Step 4: Running SonarCloud scan... | tee -a "%hygieneLogPath%"
call scripts\run-sonar-scan-admin.bat >> "%hygieneLogPath%" 2>&1
echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Wrap-Up ===
echo 🎯 All hygiene steps complete. | tee -a "%hygieneLogPath%"
echo 📄 Composite log available at: %hygieneLogPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"
pause