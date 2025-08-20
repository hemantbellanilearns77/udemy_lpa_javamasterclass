:: ============================================================
:: Script Name : purge-age-analyzer.bat
:: Purpose     : Analyze file ages in archived folders and flag files older than N days
:: Author      : Hemant
:: Version     : 1.0
:: Usage       : purge-age-analyzer.bat [--execute]
:: Notes       : In DRYRUN runMode by default; use --execute to enable deletions
:: ============================================================

@echo off
setlocal EnableDelayedExpansion
set "startTime=%TIME%"
cd /d "%~dp0.."

:: ==========================================================
:: CONFIGURATION SETUP
:: ==========================================================
:: Default rootPath = first argument, else current directory
set "rootPath=%~1"
if "%rootPath%"=="" set "rootPath=%CD%"

:: Default runMode = DRYRUN
:: (so you can test safely unless EXECUTE is explicitly passed)
set "runMode=DRYRUN" 
set "runMode=%~2"
if "%runMode%"=="" set "runMode=DRYRUN"


:: ==========================================================
:: SPECIAL CASE: Only runMode passed (no rootPath)
:: ==========================================================
:: If the script is called like:
::    run-purge-age-analyzer-local.bat EXECUTE
:: or run-purge-age-analyzer-local.bat DRYRUN
:: ? then infer rootPath as the parent of the scripts folder
if /i "%~1"=="EXECUTE" (
    set "runMode=EXECUTE"
    set "rootPath=%CD%"
    goto :initDone
)

if /i "%~1"=="DRYRUN" (
    set "runMode=DRYRUN"
    set "rootPath=%CD%"
    goto :initDone
)


:: ==========================================================
:: SAFETY WARNING if EXECUTE mode is selected
:: ==========================================================
:: This is a loud warning so you never forget that files WILL be moved.
:: It is echoed before validation & guards.
if /i "%runMode%"=="EXECUTE" (
    echo.
    echo ==========================================================
    echo   WARNING: EXECUTE MODE ENABLED
    echo   Files WILL be archived moved permanently!
    echo   RootPath = %rootPath%
    echo ==========================================================
    echo.
)

echo(runMode=_%runMode%_
:: ==========================================================
:: EXTRA GUARD (Validate inputs)
:: ==========================================================
:: At this point, we assume both rootPath and runMode were passed.
:: 1. Validate that runMode is one of the allowed values.
:: 2. Ensure rootPath is never empty.
if /i "%runMode%"=="EXECUTE" goto :valid
if /i "%runMode%"=="DRYRUN" goto :valid

echo [ERROR] Invalid runMode: %runMode%
echo Allowed values: DRYRUN (default) or EXECUTE
exit /b 1

:valid

:initDone

if "%rootPath%"=="" (
    echo [WARN] rootPath was empty, defaulting to current directory...
    set "rootPath=%CD%"
)
echo RootPath = %rootPath%
echo RunMode  = %runMode%

:: === CONFIG ===
set "archivalDir=%rootPath%\archived"
set "logDir=%rootPath%\purge-logs"

if not exist "%logDir%" mkdir "%logDir%"

:: Create timestamped log file
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "logFile=%logDir%\purge-log-execution-%ts%.txt"
echo === FILE AGE REPORT (%ts%) for: "!archivalDir!" in !runMode! mode === > "%logFile%"
echo === FILE AGE REPORT (%ts%) for: "!archivalDir!" in !runMode! mode === 
echo. >> "%logFile%"
echo runMode: !runMode!

set /a grandTotal=0

:: === MAIN LOOP ===
for /r "%archivalDir%" %%F in (.) do (
    if exist "%%F\" (
        set "folder=%%~fF"
        set /a total=0
        set /a old=0
		rem # in hours (divide by 24 for days)
		set /a purgeAge=216 
        echo [Folder: !folder!]
        echo [Folder: !folder!] >> "%logFile%"
		set "comparisonString=%archivalDir%\reports\jacoco"
		rem --- SPECIAL: jacoco folder gets custom handling ---
		
		
		if /i "!folder!"=="!comparisonString!"  (
			rem --- SPECIAL: jacoco folder gets custom handling ---
			
				echo [Jacoco Special Handling] !folder!
				if exist "!comparisonString!\jacoco-html-report-*" (
					echo FOUND HTML REPORTS
					rem Handle HTML report directories as units
					for /d %%D in ("!folder!\jacoco-html-report-*") do (
						set "dirPath=%%~fD"
						for /f %%H in ('powershell -NoProfile -Command "[int]((Get-Date)-(Get-Item -LiteralPath ''%%~fD'').CreationTime).TotalHours"') do set /a dirAgeH=%%H

						if !dirAgeH! GEQ !purgeAge! (
							set /a old+=1
							if "!runMode!"=="EXECUTE" (
								echo [EXECUTE] DELETE DIR: !dirPath! !dirAgeH! hrs
								powershell -NoProfile -Command "Remove-Item -LiteralPath '%%~fD' -Recurse -Force"
								echo [EXECUTE] DELETE DIR: !dirPath! !dirAgeH! hrs >> "%logFile%"
							) else (
								echo [DRYRUN] Candidate DIR: !dirPath! !dirAgeH! hrs >> "%logFile%"
							)
						) else (
							echo [KEEP] DIR: %%~nxD (!dirAgeH!h) >> "%logFile%"
						)
					)
				) else (
					echo NOT FOUND
				)
		     		
			rem Handle jacoco files individually
			for %%X in ("!folder!\*.exec" "!folder!\*.xml") do (
				 if exist "%%~fX" (
					set "literalPath=%%~fX"
					for /f %%H in ('powershell -NoProfile -Command "[int]((Get-Date)-(Get-Item -LiteralPath ''%%~fX'').CreationTime).TotalHours"') do set /a ageH=%%H

					set /a total+=1
					if !ageH! GEQ !purgeAge! (
						set /a old+=1
						if "!runMode!"=="EXECUTE" (
							echo [EXECUTE] DELETE FILE: !literalPath! !ageH! hrs
							powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; [Microsoft.VisualBasic.FileIO.FileSystem]::DeleteFile(''!literalPath!'', 'OnlyErrorDialogs', 'SendToRecycleBin')"
							echo [EXECUTE] DELETE FILE: !literalPath! !ageH! hrs >> "%logFile%"
						) else (
							echo [DRYRUN] Candidate FILE: !literalPath! !ageH! hrs >> "%logFile%"
						)
					) else (
						echo [KEEP] FILE: %%~nxX !ageH! hrs >> "%logFile%"
					)
				 ) else (
					echo "%%~fX" does not exist
				 )
			)
		) else (
			for %%X in ("%%F\*") do (
				
				set "literalPath=%%~fX"

				:: Get current date
				for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

				:: Get creation date
				for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '%%~fX').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"

				:: Get age in hours (as per latest logic)
				for /f %%A in ('powershell -NoProfile -Command "(Get-Date).Subtract((Get-Item -LiteralPath '%%~fX').CreationTime).Hours"') do set /a age=%%A

				:: Verbose output
				echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours
				echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours >> "%logFile%"
				echo. >> "%logFile%"

				set /a total+=1

				 if !age! GEQ !purgeAge! (
					set /a old+=1 
					 if "!runMode!"=="EXECUTE" (
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
set "endTime=%TIME%"
:: Function to convert HH:MM:SS.cc into seconds
for /f "tokens=1-4 delims=:.," %%a in ("%startTime%") do (
    set /a "startSecs=%%a*3600 + %%b*60 + %%c"
)

for /f "tokens=1-4 delims=:.," %%a in ("%endTime%") do (
    set /a "endSecs=%%a*3600 + %%b*60 + %%c"
)

set /a duration=%endSecs%-%startSecs%
echo === FILE AGE ANALYSIS COMPLETED IN === in !runMode! and IN %duration% seconds
echo === FILE AGE ANALYSIS COMPLETED IN === in !runMode! and IN %duration% seconds >> "%logFile%"
echo. >> "%logFile%"
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
