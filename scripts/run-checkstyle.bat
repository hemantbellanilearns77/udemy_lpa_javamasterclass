@echo off
echo ===================================================
echo 🧼 Checkstyle Scanner — XML Output for SonarCloud
echo ===================================================

:: === Preserve Original Directory ===
set "originalDir=%CD%"

:: === Navigate to Project Root ===
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: === Paths & Config ===
set rulesetPath=config\checkstyle.xml
set outputFolder=reports\checkstyle
set reportPath=%outputFolder%\checkstyle-%timestamp%.xml
set logFolder=logs\checkstyle-logs
set logPath=%logFolder%\checkstyle-log-%timestamp%.txt

:: === Create Folders if Missing ===
if not exist "%outputFolder%" mkdir "%outputFolder%"
if not exist "%logFolder%" mkdir "%logFolder%"

:: === Validate Ruleset ===
if not exist "%rulesetPath%" (
    echo ❌ Ruleset not found: %rulesetPath%
    cd /d "%originalDir%"
    pause
    exit /b 1
)

:: === Launch Checkstyle ===
echo 🚀 Running Checkstyle...
java -jar tools\checkstyle\checkstyle.jar ^
  -c "%rulesetPath%" ^
  -f xml ^
  -o "%reportPath%" ^
  src\main\java ^
  > "%logPath%" 2>&1

echo ✅ Report generated at: %reportPath%
echo 📄 Log saved to: %logPath%

:: === Restore Directory ===
cd /d "%originalDir%"
pause