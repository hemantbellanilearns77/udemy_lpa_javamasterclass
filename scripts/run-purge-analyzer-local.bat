:: ========================================================================================================================
:: Script Name : purge-age-analyzer.bat
:: Purpose     : Analyze file ages in archived folders and flag files older than N days
:: Author      : Hemant
:: Version     : 1.0
:: Usage       : run-archive-age-analyzer-and-purge-local.bat <<FOLDER PATH>> <<DRYRUN/EXECUTE>>
:: Notes       : In DRYRUN runMode by default; use EXECUTE to enable deletions
:: ========================================================================================================================

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


:: === CONFIG ===
set "archivalDir=%rootPath%\archived"
set "logDir=%rootPath%\purge-logs"

if not exist "%logDir%" mkdir "%logDir%"


:: Create timestamped log file
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "logFile=%logDir%\purge-log-execution-%ts%.txt"


echo === FILE AGE REPORT (%ts%) for: "!archivalDir!" in !runMode! mode  > "%logFile%"
echo === FILE AGE REPORT (%ts%) for: "!archivalDir!" in !runMode! mode  
echo. >> "%logFile%"
REM echo [DEBUG] RootPath = %rootPath%
REM echo [DEBUG] RootPath = %rootPath% >> "%logFile%"
REM echo [DEBUG] RunMode  = %runMode%
REM echo [DEBUG] RunMode  = %runMode% >> "%logFile%"
REM echo [DEBUG] startTime is: !startTime!
REM echo [DEBUG] startTime is: "!startTime!" >> "%logFile%"
set /a grandTotal=0
rem # in hours (divide by 24 for days)
set /a purgeAgeinHours=63
set /a purgeAgeinDays=!purgeAgeinHours!/24 
echo [DEBUG] purgeAgeinHours is !purgeAgeinHours!
echo [DEBUG] purgeAgeinDays is !purgeAgeinDays!
:: ===== PROCESS TARGET FOLDERS =====
for %%R in (logs reports) do (
set "targetFolder=%archivalDir%\%%R"
echo [DEBUG] Now traversing targetfolder "!targetFolder!"
echo [DEBUG] Now traversing targetfolder "!targetFolder!" >> "%logFile%"
    if not exist "!targetFolder!" (
		echo [SKIP] Missing: "!targetFolder!"
        echo [SKIP] Missing: "!targetFolder!" >> "%logFile%"
        echo. >> "%logFile%"
    ) else (
		echo [PROCESSING ROOT] "%%R"
        echo [PROCESSING ROOT] "%%R" >> "%logFile%"
        echo. >> "%logFile%"

        for /d %%F in ("!targetFolder!\*") do (
			
			set "folderPath=%%~fF"
			set "folderName=%%~nxF"
			set "jacocoReportsArchivalDir=%archivalDir%\reports\jacoco"
			echo [DEBUG] folderPath is "!folderPath!"
			echo [DEBUG] folderPath is "!folderPath!" >> "%logFile%"
			echo [DEBUG] folderName is "!folderName!"
			echo [DEBUG] folderName is "!folderName!" >> "%logFile%"
			if /i "!folderPath!"=="!jacocoReportsArchivalDir!"  (
			
				echo [DEBUG]  [Jacoco Special Handling] for "!folderPath!" and "!folderName!"			
				echo [DEBUG]  [Jacoco Special Handling] for "!folderPath!" and "!folderName!" >> "%logFile%"
				set /a total=0
				set /a old=0
				echo [DEBUG]Initialized variables
				echo [DEBUG] Initialized variables >> "%logFile%"
				
				rem Handle jacoco files individually
				for %%X in ("!folderPath!\*.xml") do (
					 echo [DEBUG]Found XML files at "!folderPath!"
					 if exist "%%~fX" (
						set "literalPath=%%~fX"
						:: Get current date
						for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

						:: Get creation date
						for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '!literalPath!').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"
						
						:: Get age in hours (as per latest logic)
						for /f %%A in ('powershell -NoProfile -Command "(Get-Date).Subtract((Get-Item -LiteralPath '!literalPath!').CreationTime).Hours"') do (
							set /a age=%%A
							echo [DEBUG] : Age calculated for !literalPath! is !age!
						)

						:: Check if age is a valid number
						if "!age!"=="" (
							echo [ERROR] Age for file "!literalPath!" could not be determined.
							set "age=0"  :: Default to 0 if age is not set
						)

						:: Convert age to a floating-point number for comparison
						rem set "ageFloat=!age!"
						
						:: Verbose output
						echo [DEBUG] File : !literalPath! ; Created on : !creationDate! ; Age : !age! hrs
						echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! hrs >> "%logFile%"
						echo. >> "%logFile%"

						set /a total+=1
						if !age! GEQ !purgeAgeinHours! (
							set /a old+=1
							if "!runMode!"=="EXECUTE" (
								echo [DEBUG] [EXECUTE] DELETE FILE: !literalPath! !age! hrs
								call powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; ^[Microsoft.VisualBasic.FileIO.FileSystem^]::DeleteFile('!literalPath!', 'OnlyErrorDialogs', 'SendToRecycleBin')"
								echo [EXECUTE] DELETED FILE: !literalPath! !age! hrs >> "%logFile%"
								call :colorEcho "[DEBUG][EXECUTE][DELETE] DELETED FILE: !literalPath! hrs !age!" RED
							) else (
								call :colorEcho "[DEBUG][DRYRUN][DELETE] Candidate FILE: !literalPath! hrs !age!" RED
								echo [DRYRUN] Candidate FILE: !literalPath! !age! hrs >> "%logFile%"
							)
						) else (
							call :colorEcho "[DEBUG][BOTH MODES][KEEP] Will Retain: !literalPath! hrs !age!" RED
							echo [BOTH MODES][KEEP] WIll Retain: %%~nxX !age! hrs >> "%logFile%"
						)
					 ) else (
						echo [ERROR] "%%~fX" does not exist
						echo [ERROR] "%%~fX" does not exist >> "%logFile%"
					 )
				)
				
				for %%X in ("!folderPath!\*.exec") do (
					 echo [DEBUG]Found EXEC files at "!folderPath!"
					 if exist "%%~fX" (
						set "literalPath=%%~fX"
						:: Get current date
						for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

						:: Get creation date
						for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '!literalPath!').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"
						
						:: Get age in hours (as per latest logic)
						for /f %%A in ('powershell -NoProfile -Command "(Get-Date).Subtract((Get-Item -LiteralPath '!literalPath!').CreationTime).Hours"') do (
							set /a age=%%A
							echo [DEBUG] : Age calculated for !literalPath! is !age!
						)

						:: Check if age is a valid number
						if "!age!"=="" (
							echo [ERROR] Age for file "!literalPath!" could not be determined.
							set "age=0"  :: Default to 0 if age is not set
						)

						:: Convert age to a floating-point number for comparison
						rem set "ageFloat=!age!"
						
						:: Verbose output
						echo [DEBUG] File : !literalPath! ; Created on : !creationDate! ; Age : !age! hrs
						echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! hrs >> "%logFile%"
						echo. >> "%logFile%"

						set /a total+=1
						if !age! GEQ !purgeAgeinHours! (
							set /a old+=1
							if "!runMode!"=="EXECUTE" (
								echo [DEBUG] [EXECUTE] DELETE FILE: !literalPath! !age! hrs
								call powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; ^[Microsoft.VisualBasic.FileIO.FileSystem^]::DeleteFile('!literalPath!', 'OnlyErrorDialogs', 'SendToRecycleBin')"
								echo [EXECUTE] DELETED FILE: !literalPath! !age! hrs >> "%logFile%"
								call :colorEcho "[DEBUG] [EXECUTE] DELETED FILE:: !literalPath! !age! hrs" RED
							) else (
								echo [DEBUG] [DRYRUN] Candidate FILE: !literalPath! !age! hrs
								call :colorEcho "[DEBUG][BOTH MODES][DELETE] Candidate FILE: !literalPath! hrs !age!" RED
								echo [DRYRUN] Candidate FILE: !literalPath! !age! hrs >> "%logFile%"
							)
						) else (
						    call :colorEcho "[DEBUG][BOTH MODES][KEEP] Candidate FILE: !literalPath! hrs !age!" GREEN
							echo [KEEP] FILE: %%~nxX !age! hrs >> "%logFile%"
						)
					 ) else (
						echo [ERROR] "%%~fX" does not exist
						echo [ERROR] "%%~fX" does not exist >> "%logFile%"
					 )
				)
				
				if exist "!folderPath!\jacoco-html-report-*" (
					echo [DEBUG] FOUND HTML REPORTS
					rem Handle HTML report directories as units
					for /d %%D in ("!folderPath!\jacoco-html-report-*") do (
						set "dirPath=%%~fD"
						echo [DEBUG] dirPath is !dirPath!
						for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

						:: Get creation date
						for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '!dirPath!').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"
						
						for /f %%H in ('powershell -NoProfile -Command "[int]((Get-Date)-(Get-Item -LiteralPath '!dirPath!').CreationTime).Hours"') do set /a dirAgeH=%%H
						
						:: Check if dirAgeH is a valid number
						if "!dirAgeH!"=="" (
							echo [ERROR] Age for Directory "!dirPath!" could not be determined.
							set "dirAgeH=0"  :: Default to 0 if age is not set
						)
						:: Convert age to a floating-point number for comparison
						rem set "ageFloat=!age!"
						
						:: Verbose output
						echo [DEBUG] Directory : !dirPath! ; Created on : !creationDate! ; Age : !dirAgeH! Hours
						echo Directory : !dirPath! ; Created on : !creationDate! ; Age : !dirAgeH! Hours >> "%logFile%"
						echo. >> "%logFile%"
						
						if !dirAgeH! GEQ !purgeAgeinHours! (
							set /a old+=1
							echo [DEBUG] !old!
							if "!runMode!"=="EXECUTE" (
								echo [DEBUG] [EXECUTE] DELETE DIR: !dirPath! !dirAgeH! hrs
								powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; ^[Microsoft.VisualBasic.FileIO.FileSystem]::DeleteDirectory('!dirPath!', 'OnlyErrorDialogs', 'SendToRecycleBin')"
								REM : Try below to attempt sending them to bin first
								REM powershell -NoProfile -Command "$Shell = New-Object -ComObject Shell.Application; 
								REM ^$Shell.NameSpace(0).ParseName('!literalPath!').InvokeVerb('delete')"
								call :colorEcho "[DEBUG] [EXECUTE] DELETED DIRECTORY: !dirPath! !dirAgeH! hrs" RED
								echo [EXECUTE] DELETED DIRECTORY: !dirPath! !dirAgeH! hrs >> "%logFile%"
							) else (
							    call :colorEcho "[DEBUG] [BOTH MODES] Candidate to delete: !dirPath! !dirAgeH! hrs" RED
								echo [DRYRUN] Candidate DIR: !dirPath! !dirAgeH! hrs >> "%logFile%"
							)
						) else (
						    call :colorEcho "[DEBUG][BOTH MODES][KEEP] Will retain: !dirPath! !dirAgeH! hrs GREEN
							echo [BOTH MODES][KEEP] DIR: %%~nxD !dirAgeH! hrs >> "%logFile%"
						)

					)
				) else (
					echo NOT FOUND
				)			
				set /a grandTotal+=!old!
				echo [DEBUG] grandTotal is !grandTotal!
				echo [DEBUG] Total Files processed in folder: !folderName! : !total! ; Files that are Older than !purgeAgeinHours! hours: !old!
				echo Total Files processed in folder: !folderName! : !total! ; Files that are Older than !purgeAgeinHours! hours: !old! >> "%logFile%"
				echo. >> "%logFile%" 

				
			) else (
				echo [DEBUG] Will process a non-jacoco-report path
				echo [DEBUG] Will process a non-jacoco-report path >> "%logFile%"
				set /a total=0
				set /a old=0
				echo [DEBUG]Initialized variables
				echo [DEBUG] Initialized variables >> "%logFile%"
				:: ===== PROCESS EACH FILE NORMALLY =====
				for %%X in ("%%F\*") do (
					set "literalPath=%%~fX"
					rem echo [DEBUG] literalPath is "!literalPath!"
					rem echo [DEBUG] literalPath is "!literalPath!" >> "%logFile%"
					:: Get current date
					for /f %%C in ('powershell -NoProfile -Command "Get-Date -Format 'yyyy-MM-dd HH:mm:ss'"') do set "currentDate=%%C"

					:: Get creation date
					for /f "delims=" %%D in ('powershell -NoProfile -Command "(Get-Item -LiteralPath '!literalPath!').CreationTime.ToString('yyyy-MM-dd HH:mm:ss')"') do set "creationDate=%%D"
					
					:: Get age in hours (as per latest logic)
					for /f %%A in ('powershell -NoProfile -Command "(Get-Date).Subtract((Get-Item -LiteralPath '!literalPath!').CreationTime).Hours"') do (
						set /a age=%%A
						echo [DEBUG] : Age calculated for !literalPath! is !age!
					)

					:: Check if age is a valid number
					if "!age!"=="" (
						echo [ERROR] Age for file "!literalPath!" could not be determined.
						set "age=0"  :: Default to 0 if age is not set
					)

					:: Convert age to a floating-point number for comparison
					rem set "ageFloat=!age!"
					
					:: Verbose output
					echo [DEBUG] File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours
					echo File : !literalPath! ; Created on : !creationDate! ; Age : !age! Hours >> "%logFile%"
					echo. >> "%logFile%"

					set /a total+=1

					 if !age! GEQ !purgeAgeinHours! (
						set /a old+=1 
						 if "!runMode!"=="EXECUTE" (
							echo [DEBUG] [EXECUTE] DELETING to Recycle Bin: !literalPath! !age! hours
							call powershell -NoProfile -Command "Add-Type -AssemblyName Microsoft.VisualBasic; ^[Microsoft.VisualBasic.FileIO.FileSystem^]::DeleteFile('!literalPath!', 'OnlyErrorDialogs', 'SendToRecycleBin')"
							echo [DEBUG] [EXECUTE] DELETED: !literalPath! !age! hours >> "%logFile%"
							call :colorEcho "[DEBUG] [EXECUTE] DELETED: !literalPath! !age! hours" RED
						)
						call :colorEcho "[DEBUG] [BOTH MODES] Candidate to delete: !age! hours !literalPath! " RED
						echo [DEBUG] [DRY-RUN] Candidate to delete: !age! hours !literalPath! >> "%logFile%"
					 ) else (
						call :colorEcho "[DEBUG][BOTH MODES][KEEP] Will retain: !age! hours !literalPath!" GREEN
						echo [DEBUG][BOTH-MODES][KEEP] Will retain: "!literalPath!" "!age!" hrs >> "%logFile%"
					)
				)
				set /a grandTotal+=!old!
				echo [DEBUG] grandTotal is !grandTotal!
				echo [DEBUG] Total Files processed in folder: !folderName! : !total! ; Files that are Older than !purgeAgeinHours! hours: !old!
				echo Total Files processed in folder: !folderName! : !total! ; Files that are Older than !purgeAgeinHours! hours: !old! >> "%logFile%"
				echo. >> "%logFile%" 
			)  
		)
	)
)

call :colorEcho "[DEBUG] [BOTH MODES] Grand Total of all files processe and that are Older than !purgeAgeinHours! hours is: !grandTotal! " RED
echo [DEBUG] [BOTH MODES] Grand Total of all files processe and that are Older than !purgeAgeinHours! hours is: !grandTotal! >> %logFile%

:: === FINAL RECYCLE BIN COUNT ===
for /f %%R in ('powershell -NoProfile -Command "((New-Object -ComObject Shell.Application).NameSpace(10).Items()).Count"') do set "recycleCount=%%R"

call :colorEcho "[DEBUG] Files currently in Recycle Bin: !recycleCount!" CYAN
echo Files currently in Recycle Bin: !recycleCount! >> "%logFile%"
set "endTime=%TIME%"
echo [DEBUG] startTime is: %startTime%
echo [DEBUG] endTime is: %endTime%
echo "endTime is: %endTime%" >> "%logFile%"
:: Function to convert HH:MM:SS.cc into seconds
for /f "tokens=1-4 delims=:.," %%a in ("%startTime%") do (
    set /a "startSecs=%%a*3600 + %%b*60 + %%c"
)

for /f "tokens=1-4 delims=:.," %%a in ("%endTime%") do (
    set /a "endSecs=%%a*3600 + %%b*60 + %%c"
)

echo [DEBUG] startSecs is: %startSecs%
echo startSecs is: %startSecs% >> "%logFile%"
echo [DEBUG] endSecs is: %endSecs%
echo endSecs is: %endSecs% >> "%logFile%"
set /a duration=%endSecs%-%startSecs%
echo [DEBUG] duration is: %duration%
echo duration is: %duration% >> "%logFile%"
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