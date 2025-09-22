@echo off
setlocal

:: =========================================================
:: Usage:
::   open_terminals.bat              → Opens Git Bash + CMD
::   open_terminals.bat withjshell   → Opens Git Bash + CMD + JShell terminal
:: =========================================================

if "%1"=="withjshell" goto :withjshell

:: =========================================================
:: Default mode → Open Git Bash and CMD in Admin mode
:: =========================================================
echo Starting Git Bash as Administrator...
powershell -Command "Start-Process 'C:\Program Files\Git\git-bash.exe' -ArgumentList '--cd=d:/GitHubRepos' -Verb RunAs"

echo Starting CMD as Administrator...
powershell -Command "Start-Process cmd.exe -ArgumentList '/k cd /d D:\GitHubRepos' -Verb RunAs"

goto :eof


:withjshell
:: =========================================================
:: JShell mode → Open 3 admin terminals
:: =========================================================

echo Starting Git Bash as Administrator...
powershell -Command "Start-Process 'C:\Program Files\Git\git-bash.exe' -ArgumentList '--cd=d:/GitHubRepos' -Verb RunAs"

echo Starting CMD as Administrator...
powershell -Command "Start-Process cmd.exe -ArgumentList '/k cd /d D:\GitHubRepos' -Verb RunAs"

echo Starting CMD with JShell as Administrator...
powershell -Command "Start-Process cmd.exe -ArgumentList '/k cd /d D:\GitHubRepos\udemy_lpa_javamasterclass\misc_utils\src\main\java\com\hb\study\misc_utils\demo_stubs && echo Current folder: D:\GitHubRepos\udemy_lpa_javamasterclass\misc_utils\src\main\java\com\hb\study\misc_utils\demo_stubs && jshell' -Verb RunAs"

goto :eof
