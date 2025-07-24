@echo off
echo ---------------------------------------------------
echo Please run this Command Prompt as Administrator.
echo ---------------------------------------------------

pause

:: Navigate to project root
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: Generate timestamp for the log file
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm"') do set timestamp=%%i

:: Run scan and pipe output to timestamped log
echo Running SonarCloud scan...
sonar-scanner > ./logs/sonar_scan_logs/sonar-scan-%timestamp%.log

echo Scan complete. Logged output to sonar-scan-%timestamp%.log