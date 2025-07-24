@echo off
:: Check if the script is running as administrator
net session >nul 2>&1
if %errorLevel% NEQ 0 (
    echo Requesting administrative privileges...
    powershell -Command "Start-Process cmd -ArgumentList '/c, %~f0' -Verb RunAs"
    exit /b
)

:: Navigate to the specified directory
cd /d D:\GitHubRepos\misc_corejava_practice\src\com\hb\study\common\misc_practice

:: Open jshell
jshell