@echo off
setlocal enabledelayedexpansion

:: === SAFETY: Run from project root ===
cd /d "%~dp0\.."

:: === CONFIGURATION ===
set "maxFiles=9"
set "retentionDays=365"
set "DRY_RUN=1"

:: === ANSI Coloring ===
for /f %%i in ('powershell -command "$Host.UI.SupportsVirtualTerminal"') do set "ansi=%%i"
if "%ansi%"=="True" (
    set "YELLOW=[93m"
    set "CYAN=[96m"
    set "GREEN=[92m"
    set "MAGENTA=[95m"
    set "RESET=[0m"
) else (
    set "YELLOW="
    set "CYAN="
    set "GREEN="
    set "MAGENTA="
    set "RESET="
)

:: === Timestamp & Log Setup ===
for /f %%a in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%a"
set "logDir=logs\purge-logs"
if not exist "%logDir%" mkdir "%logDir%"
set "logFile=%logDir%\purge-%ts%.txt"

:: === Summary Bucket ===
set "summary="

:: === Tool Configurations ===
call :purgeModule "PMD Logs"           "logs\pmd-scan-logs"     "purged\logs\pmd-scan-logs"
call :purgeModule "PMD Reports"        "reports\pmd"            "purged\reports\pmd"
call :purgeModule "Checkstyle Reports" "reports\checkstyle"     "purged\reports\checkstyle"
call :purgeModule "Sonar Logs"         "logs\sonar-scan"        "purged\logs\sonar-scan"
call :purgeModule "Sonar Reports"      "reports\sonar-scan"     "purged\reports\sonar-scan"
call :purgeModule "Purge Logs"         "logs\purge-logs"        "purged\logs\purge-logs"

:: === Summary Panel ===
echo.
echo %CYAN%=== PURGE SUMMARY ===%RESET%
echo %summary%
echo.
echo %MAGENTA%Dry-Run Mode: %DRY_RUN%   |   Log: %logFile%%RESET%
echo %GREEN%? All tools scanned successfully%RESET%
goto :eof

:: ===============================
:: === MODULE: purgeModule     ===
:: ===============================
:purgeModule
set "name=%~1"
set "srcDir=%~2"
set "archDir=%~3"

echo.
echo %YELLOW%--- [%name%] Archival Phase ---%RESET%

:: Create archive path if not exists
if not exist "%archDir%" mkdir "%archDir%"
set /a count=0
set /a archived=0

:: Archive excess files, protect directories
for /f "delims=" %%F in ('dir /b /a:-d /o-n "%srcDir%\*"') do (
    set /a count+=1
    if !count! GTR %maxFiles% (
        if exist "%srcDir%\%%F" (
            echo [ARCHIVE] %%F ¡÷ %archDir%
            echo [%name%][ARCHIVE] %%F ¡÷ %archDir% >> "%logFile%"
            if %DRY_RUN%==0 move "%srcDir%\%%F" "%archDir%\%%F"
            set /a archived+=1
        )
    ) else (
        echo [KEEP] %%F
        echo [%name%][KEEP] %%F >> "%logFile%"
    )
)

echo %YELLOW%--- [%name%] Cleanup Phase (> %retentionDays%d) ---%RESET%
set /a deleted=0

:: Safely delete aged files only
for /f "delims=" %%F in ('dir /b /a:-d "%archDir%\*"') do (
    if exist "%archDir%\%%F" (
        for /f %%A in ('powershell -command "(Get-Date) - (Get-Item \"%archDir%\%%F\").LastWriteTime"') do (
            set "age=%%A"
            for /f %%B in ('powershell -command "([timespan]::Parse(\"!age!\")).TotalDays"') do set "ageDays=%%B"
            if !ageDays! GEQ %retentionDays% (
                echo [DELETE] %%F (Age: !ageDays!d)
                echo [%name%][DELETE] %%F (Age: !ageDays!d) >> "%logFile%"
                if %DRY_RUN%==0 del "%archDir%\%%F"
                set /a deleted+=1
            ) else (
                echo [RETAIN] %%F (Age: !ageDays!d)
                echo [%name%][RETAIN] %%F (Age: !ageDays!d) >> "%logFile%"
            )
        )
    )
)

:: Update summary
set "summary=%summary%%name%: Archived=!archived!, Deleted=!deleted!%~n%~n"
goto :eof