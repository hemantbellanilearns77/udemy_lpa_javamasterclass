@echo off
echo ===================================================
echo 🧹 All Hygiene Workflow — Checkstyle + PMD + SonarCloud
echo ===================================================

:: === Preserve Original Directory ===
set "originalDir=%CD%"

:: === Navigate to Project Root ===
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

:: === Log Directory Setup ===
set "hygieneLogFolder=logs\all-hygiene-logs"
set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.log"

if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"

:: === Begin Composite Logging ===
echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 1: Checkstyle ===
echo 🚀 Step 1: Running Checkstyle... | tee -a "%hygieneLogPath%"
call scripts\run-checkstyle.bat >> "%hygieneLogPath%" 2>&1
echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
echo 🚀 Step 2: Running PMD... | tee -a "%hygieneLogPath%"
call scripts\run-pmd.bat >> "%hygieneLogPath%" 2>&1
echo ✅ PMD scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 3: SonarCloud Scan ===
echo 🚀 Step 3: Running SonarCloud scan... | tee -a "%hygieneLogPath%"
call scripts\run-sonar-scan-admin.bat >> "%hygieneLogPath%" 2>&1
echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Wrap-Up ===
echo 🎯 All hygiene steps complete. | tee -a "%hygieneLogPath%"
echo 📄 Composite log available at: %hygieneLogPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"
pause