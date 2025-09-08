@echo off
REM Wrapper to launch PowerShell backup script

REM Change this path to where your PS1 lives
set SCRIPT_PATH=D:\GitHubRepos\udemy_lpa_javamasterclass\scripts\Backup-GitHubRepos.ps1

REM Call PowerShell with ExecutionPolicy bypass
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%SCRIPT_PATH%" Execute