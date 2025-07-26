@echo off
setlocal enabledelayedexpansion

:: Move to parent directory of script for context alignment
cd /d "%~dp0\.."
for /f %%P in ('powershell -command "Get-Location | Select-Object -ExpandProperty Path"') do echo [DEBUG] Current working directory after cd: %%P
echo === Starting purge orchestrator in debug mode ===

:: CONFIGURATION — define max files to retain, retention threshold, and dry-run toggle
set "maxFiles=9"
set "retentionDays=365"
set "DRY_RUN=0"
echo [CONFIG] maxFiles=%maxFiles%, retentionDays=%retentionDays%, DRY_RUN=%DRY_RUN%

:: TIMESTAMP & LOGGING — generate unique timestamp, ensure log directory exists
for /f %%a in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%a"
echo [DEBUG] Timestamp generated: %ts%
set "logDir=logs\purge-logs"
if not exist "%logDir%" (
    echo [DEBUG] Creating log directory: %logDir%
    mkdir "%logDir%"
) else (
    echo [DEBUG] Log directory already exists: %logDir%
)
set "logFile=%logDir%\purge-%ts%.txt"
echo [DEBUG] Log file path set: %logFile%

:: GLOBAL COUNTERS — used to aggregate final reporting
set "summary="
set "deleted=0"
set "archived=0"

:: TARGET MODULE INVOCATIONS — triggers scans for each logical artifact type
call :purgeModule "PMD Logs"           "logs\pmd-scan-logs"     "purged\logs\pmd-scan-logs"
call :purgeModule "PMD Reports"        "reports\pmd"            "purged\reports\pmd"
call :purgeModule "Checkstyle Reports" "reports\checkstyle"     "purged\reports\checkstyle"
call :purgeModule "Sonar Logs"         "logs\sonar-scan"        "purged\logs\sonar-scan"
call :purgeModule "Sonar Reports"      "reports\sonar-scan"     "purged\reports\sonar-scan"
call :purgeModule "Purge Logs"         "logs\purge-logs"        "purged\logs\purge-logs"

:: FINAL SUMMARY — emit aggregate counters and dry-run hint
echo.
echo === PURGE SUMMARY ===
echo [DEBUG] Final summary: %summary%
echo.
echo Dry-Run Mode: %DRY_RUN% | Log: %logFile%
echo Debug mode complete. Review echoes for ghost traces.
endlocal
goto :eof

:: === MODULE IMPLEMENTATION ===
:purgeModule
set "name=%~1"
set "srcDir=%~2"
set "archDir=%~3"
echo.
echo === [%name%] ===
echo [DEBUG] Module=%name%, Source=%srcDir%, Archive=%archDir%

:: Start timestamp (seconds)
for /f %%s in ('powershell -command "Get-Date -UFormat %%s"') do set "startSec=%%s"
echo [DEBUG] Start timestamp (sec): %startSec%

:: Archival phase — retain newest files
echo --- Archival Phase ---
if not exist "%archDir%" (
    echo [DEBUG] Creating archive folder: %archDir%
    mkdir "%archDir%"
) else (
    echo [DEBUG] Archive folder already exists: %archDir%
)
set /a count=0
echo [DEBUG] Initialized count=0
echo [DEBUG] Capturing stable file list for %srcDir%
powershell -command "Get-ChildItem -Path '%srcDir%' -File | Sort-Object LastWriteTime -Descending | Select-Object -ExpandProperty Name" >> "%logFile%"
for /f "delims=" %%F in ('dir /b /a:-d /o-n "%srcDir%\*" 2^>nul') do (
    set /a count+=1
    set "file=%%F"
    echo [DEBUG][ARCHIVAL LOOP] count=!count!, file=!file!

    if !count! LEQ %maxFiles% (
        echo [KEEP] !file!
        echo [DEBUG] Verdict=KEEP
        echo [%name%][KEEP-Hemant] !file! >> "%logFile%"
    ) else (
        echo [ARCHIVE] !file! ? %archDir%
        echo [DEBUG] Verdict=ARCHIVE
        echo [%name%][ARCHIVE] !file! ? %archDir% >> "%logFile%"
        if %DRY_RUN%==0 (
            echo [DEBUG] Moving: "%srcDir%\!file!" ? "%archDir%\!file!"
            move "%srcDir%\!file!" "%archDir%\!file!" >nul
            if exist "%archDir%\!file!" (
                echo [DEBUG] Move confirmed for: !file!
                set /a archived+=1
                echo [DEBUG] archived+=1 ? !archived!
            ) else (
                echo [ERROR] Move failed: !file! missing
                echo [%name%][ERROR] Move failed: !file! >> "%logFile%"
            )
        ) else (
            echo [DEBUG] DRY_RUN=1 — skipping archive move
        )
    )
)

:: Cleanup phase — delete aged files
echo --- Cleanup Phase (Older than %retentionDays%d) ---
for /f "delims=" %%F in ('dir /b /a:-d "%archDir%\*" 2^>nul') do (
    set "file=%%F"
    echo [DEBUG][CLEANUP] Inspecting: !file!
    set "ageDays="

    for /f "usebackq tokens=* delims=" %%A in (`powershell -nologo -command "try {[int](([datetime]::Now - (Get-Item '%archDir%\%%F').LastWriteTime).TotalDays)} catch {-1}"`) do (
        set "ageDays=%%A"
        echo [DEBUG] ageDays raw=%%A
    )

    set "ageValid=0"
    if defined ageDays (
        echo [DEBUG] ageDays defined: !ageDays!
        for /f "tokens=1 delims=0123456789" %%Z in ("!ageDays!") do (
            if "%%Z"=="" set "ageValid=1"
        )
        echo [DEBUG] ageValid=!ageValid!
    )

    if not defined ageDays (
        echo [SKIP] !file! (Age unknown)
        echo [%name%][SKIP] !file! (Age unknown) >> "%logFile%"
    ) else if "!ageDays!"=="-1" (
        echo [SKIP] !file! (PowerShell error)
        echo [%name%][SKIP] !file! (PowerShell error) >> "%logFile%"
    ) else if "!ageValid!"=="1" (
        echo [DEBUG] Valid age format: !ageDays!d
        if !ageDays! GEQ %retentionDays% (
            echo [DELETE] !file! (Age: !ageDays!d)
            echo [%name%][DELETE] !file! (Age: !ageDays!d) >> "%logFile%"
            if %DRY_RUN%==0 (
                if exist "%archDir%\!file!" (
                    del "%archDir%\!file!" >nul
                    echo [DEBUG] Deleted file: !file!
                    set /a deleted+=1
                    echo [DEBUG] deleted+=1 ? !deleted!
                ) else (
                    echo [SKIP] !file! (Missing before deletion)
                    echo [%name%][SKIP] !file! (Missing before deletion) >> "%logFile%"
                )
            ) else (
                echo [DEBUG] DRY_RUN=1 — deletion skipped
            )
        ) else (
            echo [RETAIN] !file! (Age: !ageDays!d)
            echo [%name%][RETAIN] !file! (Age: !ageDays!d) >> "%logFile%"
        )
    ) else (
        echo [SKIP] !file! (Invalid age format: "!ageDays!")
        echo [%name%][SKIP] !file! (Invalid age format: "!ageDays!") >> "%logFile%"
    )
)

:: Report scan duration
for /f %%e in ('powershell -command "Get-Date -UFormat %%s"') do set "endSec=%%e"
set /a durationSec=%endSec% - %startSec%
echo [DEBUG] Scan duration: %durationSec%s
echo [%name%][DURATION] %durationSec%s >> "%logFile%"
echo [DURATION] %name% scanned in %durationSec%s

:: Append summary
set "summary=%summary%%name%: Archived=%archived%, Deleted