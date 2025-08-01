:: ============================================================
:: Script Name : purge-age-analyzer.bat
:: Purpose     : Analyze file ages in archived folders and flag files older than N days
:: Author      : Hemant
:: Version     : 1.0
:: Usage       : purge-age-analyzer.bat [--execute]
:: Notes       : In DRY-RUN mode by default; use --execute to enable deletions
:: ============================================================

@echo off
setlocal EnableDelayedExpansion

:: === MODE: DRY-RUN or EXECUTE ===
set "mode=DRY-RUN"
if /i "%1"=="--execute" set "mode=EXECUTE"
echo MODE: !mode!

:: === CONFIG ===
set "root=D:\GitHubRepos\udemy_lpa_javamasterclass\archived" 
set "logDir=D:\GitHubRepos\udemy_lpa_javamasterclass\purge-logs"

if not exist "%logDir%" mkdir "%logDir%"

:: Create timestamped log file
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "logFile=%logDir%\purge-log-execution-%ts%.txt"

echo === FILE AGE REPORT (%ts%) for: %root% in !mode! mode === > "%logFile%"
echo. >> "%logFile%"
echo MODE: !mode!

set /a grandTotal=0

:: === MAIN LOOP ===
for /r "%root%" %%F in (.) do (
    if exist "%%F\" (
        set "folder=%%~fF"
        set /a total=0
        set /a old=0
		set /a purgeAge=9
        echo [Folder: !folder!]
        echo [Folder: !folder!] >> "%logFile%"

        for %%X in ("%%F\*") do (
            set "literalPath=%%~fX"

            :: Get current date
            for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

            :: Get creation date
            for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '%%~fX').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"

            :: Get age in hours (as per latest logic)
            for /f %%A in ('powershell -NoProfile -Command "(Get-Date).Subtract((Get-Item -LiteralPath '%%~fX').CreationTime).Hours"') do set /a age=%%A/24

            :: Verbose output
            echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours
            echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours >> "%logFile%"
            echo. >> "%logFile%"

            set /a total+=1

             if !age! GEQ !purgeAge! (
			    set /a old+=1 
				 if "!mode!"=="EXECUTE" (
                    echo [EXECUTE] DELETING to Recycle Bin: !literalPath! !age! hours
                    call powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; ^[Microsoft.VisualBasic.FileIO.FileSystem^]::DeleteFile('!literalPath!', 'OnlyErrorDialogs', 'SendToRecycleBin')"
                    echo [EXECUTE] DELETED: !literalPath! !age! hours >> "%logFile%"
                    call :colorEcho "[EXECUTE] DELETED: !literalPath! !age! hours" RED
                )
			    call :colorEcho "[BOTH MODES] Candidate to delete: !age! hours !literalPath! " RED
				echo [DRY-RUN] Candidate to delete: !age! hours !literalPath! >> "%logFile%"
             ) else (
			    REM call :colorEcho "[BOTH MODES] Will retain: !age! hours !literalPath! " GREEN
                echo [BOTH-MODES] Won't delete: !literalPath! !age! hours >> "%logFile%"
            )
        
		)
		set /a grandTotal+=!old!
        echo Total: !total!, Older than !purgeAge! hours: !old!
        echo Total: !total!, Older than !purgeAge! hours: !old! >> "%logFile%"
        echo. >> "%logFile%"
        
    )
	
)

call :colorEcho "[BOTH MODES] Grand Total: !grandTotal!, Older than !purgeAge! hours " RED
echo [BOTH MODES] Grand Total: !grandTotal!, Older than !purgeAge! hours

:: === FINAL RECYCLE BIN COUNT ===
for /f %%R in ('powershell -NoProfile -Command "((New-Object -ComObject Shell.Application).NameSpace(10).Items()).Count"') do set "recycleCount=%%R"

call :colorEcho "Files currently in Recycle Bin: !recycleCount!" CYAN
echo Files currently in Recycle Bin: !recycleCount! >> "%logFile%"

echo === FILE AGE ANALYSIS COMPLETED IN !mode! MODE === >> "%logFile%"
echo === DONE === >> "%logFile%"
goto :eof

:: === Subroutine to Color Echo ===
:colorEcho
:: %1 = message, %2 = RED or GREEN or CYAN
setlocal
if /i "%~2"=="RED" (
    powershell -command "Write-Host '%~1' -ForegroundColor Red"
) else if /i "%~2"=="GREEN" (
    powershell -command "Write-Host '%~1' -ForegroundColor Green"
) else if /i "%~2"=="CYAN" (
    powershell -command "Write-Host '%~1' -ForegroundColor Cyan"
) else (
    powershell -command "Write-Host '%~1'" -ForegroundColor White"
)
endlocal
goto :eof
