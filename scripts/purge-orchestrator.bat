@echo off
setlocal enabledelayedexpansion

:: === SAFETY: Run from project root ===
cd /d "%~dp0\.."

:: === CONFIGURATION ===
set "maxFiles=9"
set "retentionDays=365"
set "DRY_RUN=0"

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

:: === Create age-check script ===
set "ageScript=%temp%\get-age.ps1"
echo param([string]$filePath) > "%ageScript%"
echo Write-Output ([int](([DateTime]::Now - (Get-Item $filePath).LastWriteTime).TotalDays)) >> "%ageScript%"

:: === Summary Bucket ===
set "summary="

:: === Tool Configurations ===
call :purgeModule "PMD Logs"           "logs\pmd-scan-logs"     "purged\logs\pmd-scan-logs"
call :purgeModule "PMD Reports"        "reports\pmd"            "purged\reports\pmd"
call :purgeModule "Checkstyle Reports" "reports\checkstyle"     "purged\reports\checkstyle"
call :purgeModule "Sonar Logs"         "logs\sonar-scan"        "purged\logs\sonar-scan"
call :purgeModule "Sonar Reports"      "reports\sonar-scan"     "purged\reports\sonar-scan"
call :purgeModule "Purge Logs"         "logs\purge-logs"        "purged\logs\purge-logs"

:: === Clean up ===
del "%ageScript%" >nul 2>&1

:: === Summary Panel ===
echo.
echo %CYAN%=== PURGE SUMMARY ===%RESET%
echo %summary%
echo.
echo %MAGENTA%Dry-Run Mode: %DRY_RUN% ^| Log: %logFile%%RESET%
echo %GREEN%? All tools scanned with duration tracking%RESET%
goto :eof

:: ===============================
:: === MODULE: purgeModule     ===
:: ===============================
:purgeModule
set "name=%~1"
set "srcDir=%~2"
set "archDir=%~3"

echo.
echo %CYAN%=== [%name%] ===%RESET%

:: === Start time ===
for /f %%t in ('powershell -command "[System.Diagnostics.Stopwatch]::StartNew().Elapsed.TotalSeconds"') do set "startSec=%%t"

echo %YELLOW%--- Archival Phase ---%RESET%

if not exist "%archDir%" mkdir "%archDir%"
set /a count=0
set /a archived=0

for /f "delims=" %%F in ('dir /b /a:-d /o-n "%srcDir%\*" 2^>nul') do (
    set /a count+=1
    if !count! GTR %maxFiles% (
        echo [ARCHIVE] %%F ? %archDir%
        echo [%name%][ARCHIVE] %%F ? %archDir% >> "%logFile%"
        if %DRY_RUN%==0 move "%srcDir%\%%F" "%archDir%\%%F"
        set /a archived+=1
    ) else (
        echo [KEEP] %%F
        echo [%name%][KEEP] %%F >> "%logFile%"
    )
)

echo %YELLOW%--- Cleanup Phase (Older than %retentionDays%d) ---%RESET%
set /a deleted=0

for /f "delims=" %%F in ('dir /b /a:-d "%archDir%\*" 2^>nul') do (
    set "ageDays="
    for /f %%A in ('powershell -ExecutionPolicy Bypass -File "%ageScript%" "%archDir%\%%F"') do (
        set "ageDays=%%A"
    )
    call :handleCleanup "%%F" "!ageDays!" "%name%"
)

if %deleted%==0 (
    echo [INFO] No files older than %retentionDays%d were found in %archDir%
    echo [%name%][INFO] Cleanup skipped: no eligible files >> "%logFile%"
)

:: === Duration tracking ===
for /f %%t in ('powershell -command "[Math]::Round(([System.Diagnostics.Stopwatch]::StartNew().Elapsed.TotalSeconds - %startSec%),2)"') do set "duration=%%t"
echo [DURATION] %name% scanned in %duration%s >> "%logFile%"
echo %MAGENTA%[DURATION] %name% scanned in %duration%s%RESET%

:: === Append summary line ===
set "summary=%summary%%name%: Archived=%archived%, Deleted=%deleted%%RESET%"
set "summary=%summary%"
echo. >> "%logFile%"
echo. >> "%logFile%"
goto :eof

:: ===============================
:: === SUBROUTINE: handleCleanup ===
:: ===============================
:handleCleanup
echo [DEBUG] file='%file%' age='%age%' label='%label%' >> "%logFile%"
setlocal enabledelayedexpansion
set "file=%~1"
set "age=%~2"
set "label=%~3"

if defined age (
    if !age! GEQ %retentionDays% (
        echo [DELETE] !file! (Age: !age!d)
        echo [%label%][DELETE] !file! (Age: !age!d) >> "%logFile%"
        if %DRY_RUN%==0 del "%archDir%\!file!"
        endlocal & set /a deleted+=1
    ) else (
        echo [RETAIN] !file! (Age: !age!d)
        echo [%label%][RETAIN] !file! (Age: !age!d) >> "%logFile%"
        endlocal
    )
) else (
    echo [SKIP] !file! (Could not evaluate age)
    echo [%label%][SKIP] !file! (Unknown age) >> "%logFile%"
    endlocal
)
goto :eof