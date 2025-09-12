@echo off
setlocal EnableDelayedExpansion
:: --- Capture start epoch time (seconds since 1970-01-01 UTC) ---
for /f %%T in ('powershell -NoProfile -Command "[int]((Get-Date).ToUniversalTime() - [datetime]\'1970-01-01\').TotalSeconds"') do set "startEpoch=%%T"
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
::    archival.bat EXECUTE
:: or archival.bat DRYRUN
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
REM echo RootPath = %rootPath%
REM echo RunMode  = %runMode%

:: ==========================================================
:: SAFETY WARNING if EXECUTE mode is selected
:: ==========================================================
:: This is a loud warning so you never forget that files WILL be moved.
:: It is echoed before validation & guards.
if /i "%runMode%"=="EXECUTE" (
    echo.
    echo ==========================================================
    echo   ALERT: EXECUTE MODE ENABLED
    echo   Files WILL be archived moved permanently!
    echo   RootPath = %rootPath%
    echo ==========================================================
    echo.
)
REM echo RootPath = %rootPath%
REM echo RunMode  = %runMode%

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
REM echo RootPath = %rootPath%
REM echo RunMode  = %runMode%

:: ===== LAST 9 to be retained =====
set "retention=9"
set "archiveRoot=%rootPath%\archived"

:: ===== LOG SETUP =====
for /f %%t in ('powershell -NoProfile -Command "Get-Date -Format yyyyMMdd-HHmmss"') do set "ts=%%t"
REM Prepare logDir
set "logDir=%rootPath%\archival-logs"
if not exist "%logDir%" mkdir "%logDir%"
REM Ensure timestamp exists
if not defined ts (
    echo [ERROR] Timestamp generation failed. Exiting.
    exit /b 1
)
set "logPath=%logDir%\archival-log-%ts%.txt"
REM Final sanity check: does the directory exist?
if not exist "%logDir%" (
    echo [ERROR] Log directory not found: %logDir%
    exit /b 1
)

REM Test write permissions
echo [INFO] Logging initialized at "%logPath%" > "%logPath%" || (
    echo [ERROR] Unable to create log file. Exiting.
    exit /b 1
)
echo=========================================================================================================
echo========================================================================================================= >> "%logPath%"
echo ARCHIVAL SCRIPT STARTED (%runMode%) >> "%logPath%"
echo ARCHIVAL SCRIPT STARTED (%runMode%)
echo RUNMODE     : %runMode%
echo RUNMODE     : %runMode% >> "%logPath%"
echo ROOTPATH    : %rootPath%
echo ROOTPATH    : %rootPath% >> "%logPath%"
echo FOLDERS AND FILES WILL BE ARCHIVED AT : %archiveRoot%
echo FOLDERS AND FILES WILL BE ARCHIVED AT : %archiveRoot% >> "%logPath%"
echo NAME OF LOGFILE     : %logPath% 
echo NAME OF LOGFILE     : %logPath% >> "%logPath%"
echo=========================================================================================================
echo========================================================================================================= >> "%logPath%"

:: ===== PROCESS TARGET FOLDERS =====
for %%R in (logs reports) do (
    set "targetFolder=%rootPath%\%%R"

	echo [DEBUG] PROCESSING CONFIGURED TARGET FOLDER: "!targetFolder!" 
	echo [DEBUG] PROCESSING CONFIGURED TARGET FOLDER: "!targetFolder!" >> "%logPath%"
	echo=========================================================================================================
	echo========================================================================================================= >> "%logPath%"
    if not exist "!targetFolder!" (
        echo [SKIP] Missing: !targetFolder! >> "%logPath%"
        echo. >> "%logPath%"
    ) else (
        echo [PROCESSING ROOT] %%R >> "%logPath%"
        echo. >> "%logPath%"

        for /d %%F in ("!targetFolder!\*") do (
			
			set "folderPath=%%~fF"
			set "folderName=%%~nxF"
			set "comparisonString=%rootPath%\reports\jacoco"
			if /i "!folderPath!"=="!comparisonString!"  (
			
			:: --- Handle jacoco-html-report-* directories ---
			set /a dirCount=0
			set /a dirKeep=0
			set /a dirMove=0
			set "dirArchivedList="
			echo [DEBUG] PROCESSING "!folderPath!"
			if exist "!folderPath!\jacoco-html-report-*" (
				for /f "delims=" %%D in ('dir /b /ad /o:-d "!folderPath!\jacoco-html-report-*"') do (
					set /a dirCount+=1
				)
				echo [SCAN] !folderPath! - !dirCount! JACOCO-HTML-REPORTS 
				echo [SCAN] !folderPath! - !dirCount! JACOCO-HTML-REPORTS >> "%logPath%"
				REM echo [DEBUG] Retention is !retention!  and directory count is !dirCount!
				if !dirCount! LEQ %retention% (
					echo [SKIP] Less than %retention% files, so skipping archival of JACOCO HTML Reports from !folderPath!
			echo [SKIP] Less than %retention% files, so skipping archival of JACOCO HTML Reports from !folderPath! >> "%logPath%"
				) else (
					echo Hello 3
					for /f "delims=" %%D in ('dir /b /ad /o:-d "!folderPath!\jacoco-html-report-*"') do (
						set /a dirCount+=1
						if !dirCount! GTR %retention% (
							set "srcPath=!folderPath!\%%D"
							set "destDir=%archiveRoot%\reports\jacoco"
							echo [MOVE] old report folder !srcPath! >> "%logPath%"
							if /i "%runMode%"=="EXECUTE" (
								if not exist "!destDir!" md "!destDir!"
								move /Y "!srcPath!" "!destDir!" >nul
							)
							set /a dirMove+=1
							set "dirArchivedList=!dirArchivedList!%%D, "
						) else (
							echo [KEEP] recent report folder: %%D
							echo [KEEP] recent report folder: %%D >> "%logPath%"
							set /a dirKeep+=1
						)
					)
					
					if /i "!runMode!"=="EXECUTE" (
						:: --- Combined Summary for jacoco ---
						echo. >> "%logPath%"
						echo === SUMMARY: "!folderName!" === >> "%logPath%"
						echo [DEBUG] [EXECUTE] Total dirs   : !dirCount! >> "%logPath%"
						echo [DEBUG] [EXECUTE] Retained dirs: !dirKeep! >> "%logPath%"
						echo [DEBUG] [EXECUTE] Archived dirs: !dirMove! >> "%logPath%"
						if "!dirArchivedList!"=="" (
							echo Archived Dirs: None >> "%logPath%"
						) else (
							echo Archived Dirs: !dirArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					) else (
						:: --- Combined Summary for jacoco ---
						echo. >> "%logPath%"
						echo === SUMMARY: for folder: "!folderName!" in "!runMode!" mode === >> "%logPath%"
						echo [DEBUG] [DRYRUN] Total dirs in "!runMode!" mode: !dirCount! >> "%logPath%"
						echo [DEBUG] [DRYRUN] Retained dirs in "!runMode!" mode: !dirKeep! >> "%logPath%"
						echo [DEBUG] [DRYRUN] Archived dirs in "!runMode!" mode: !dirMove! >> "%logPath%"
						if "!dirArchivedList!"=="" (
							echo Archived Dirs in "!runMode!" mode: None >> "%logPath%"
						) else (
							echo Archived Dirs in "!runMode!" mode: !dirArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					)				
				)
			) else (
				echo [SKIP] No jacoco-html-report-* folders in !folderPath! >> "%logPath%"
			)
			if exist "!folderPath!\*.*" (
			:: --- Handle non-latest files in jacoco folder ---
			set /a fileCount=0
			set /a fileKeep=0
			set /a fileMove=0
			set "fileArchivedList="
				for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!\*.xml" ^| findstr /v /i "latest"') do (
					set /a fileCount+=1
				)
				echo [SCAN] !folderPath! - !fileCount! JACOCO-XML-REPORTS 
				echo [SCAN] !folderPath! - !fileCount! JACOCO-XML-REPORTS >> "%logPath%"
				REM echo [DEBUG] Retention is !retention!  and directory count is !fileCount!
				if !fileCount! LEQ %retention% (
					echo [SKIP] Less than %retention% files, so skipping archival of XML Reports from !folderPath!
					echo [SKIP] Less than %retention% files, so skipping archival of XML Reports from !folderPath! >> "%logPath%"
				) else (
					set /a fileCount=0
					set /a fileKeep=0
					set /a fileMove=0
					set "fileArchivedList="
					for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!\*.xml" ^| findstr /v /i "latest"') do (
						set /a fileCount+=1
						if !fileCount! GTR %retention% (
							set "srcPath=!folderPath!\%%X"
							set "destDir=%archiveRoot%\reports\jacoco"
							echo [MOVE] old file !srcPath! >> "%logPath%"
							if /i "%runMode%"=="EXECUTE" (
								if not exist "!destDir!" md "!destDir!"
								move /Y "!srcPath!" "!destDir!" >nul
							)
							set /a fileMove+=1
							set "fileArchivedList=!fileArchivedList!%%X, "
						) else (
							echo [KEEP] recent file: %%X >> "%logPath%"
							set /a fileKeep+=1
						)
					)
					
					if /i "!runMode!"=="EXECUTE" (
						:: ---  Summary for jacoco xml report files ---
						echo. >> "%logPath%"
						echo Total files   : !fileCount! >> "%logPath%"
						echo Retained files: !fileKeep! >> "%logPath%"
						echo Archived files: !fileMove! >> "%logPath%"
						if "!fileArchivedList!"=="" (
							echo Archived Files: None >> "%logPath%"
						) else (
							echo Archived Files: !fileArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					) else (
						:: --- Summary for jacoco xml report files ---
						echo Total files in "!runMode!" mode: !fileCount! >> "%logPath%"
						echo Retained files in "!runMode!" mode: !fileKeep! >> "%logPath%"
						echo Archived files in "!runMode!" mode: !fileMove! >> "%logPath%"
						if "!fileArchivedList!"=="" (
							echo Archived Files in "!runMode!" mode: None >> "%logPath%"
						) else (
							echo Archived Files in "!runMode!" mode: !fileArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					)
				)
				set /a fileCount=0
				for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!\*.exec" ^| findstr /v /i "latest"') do (
						set /a fileCount+=1
				)
				echo [SCAN] !folderPath! - !fileCount! JACOCO-EXEC-REPORTS 
				echo [SCAN] !folderPath! - !fileCount! JACOCO-EXEC-REPORTS >> "%logPath%"
				REM echo [DEBUG] Retention is !retention!  and directory count is !fileCount!
				if !fileCount! LEQ %retention% (
					echo [SKIP] Less than %retention% files, so skipping archival of EXEC Reports from !folderPath!
					echo [SKIP] Less than %retention% files, so skipping archival of EXEC Reports from !folderPath! >> "%logPath%"
				) else (
					set /a fileCount=0
					set /a fileKeep=0
					set /a fileMove=0
					set "fileArchivedList="
					for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!\*.exec" ^| findstr /v /i "latest"') do (
						set /a fileCount+=1
						if !fileCount! GTR %retention% (
							set "srcPath=!folderPath!\%%X"
							set "destDir=%archiveRoot%\reports\jacoco"
							echo [MOVE] old file !srcPath! >> "%logPath%"
							if /i "%runMode%"=="EXECUTE" (
								if not exist "!destDir!" md "!destDir!"
								move /Y "!srcPath!" "!destDir!" >nul
							)
							set /a fileMove+=1
							set "fileArchivedList=!fileArchivedList!%%X, "
						) else (
							echo [KEEP] recent file: %%X >> "%logPath%"
							set /a fileKeep+=1
						)
					)
					
					if /i "!runMode!"=="EXECUTE" (
						:: --- Combined Summary for jacoco exec report files---
						echo. >> "%logPath%"
						echo Total files   : !fileCount! >> "%logPath%"
						echo Retained files: !fileKeep! >> "%logPath%"
						echo Archived files: !fileMove! >> "%logPath%"
						if "!fileArchivedList!"=="" (
							echo Archived Files: None >> "%logPath%"
						) else (
							echo Archived Files: !fileArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					) else (
						:: --- Combined Summary for jacoco exec report files ---
						echo. >> "%logPath%"
						echo Total files in "!runMode!" mode: !fileCount! >> "%logPath%"
						echo Retained files in "!runMode!" mode: !fileKeep! >> "%logPath%"
						echo Archived files in "!runMode!" mode: !fileMove! >> "%logPath%"
						if "!fileArchivedList!"=="" (
							echo Archived Files in "!runMode!" mode: None >> "%logPath%"
						) else (
							echo Archived Files in "!runMode!" mode: !fileArchivedList:~0,-2! >> "%logPath%"
						)
						echo. >> "%logPath%"
					)
				)				
			) else (
				echo [SKIP] No XML or EXEC files found in !folderPath!
				echo [SKIP] No XML or EXEC files found in !folderPath! >> "%logPath%"
			)
				
			) else (
				rem === Normal processing ===

				set /a fileCount=0
				set /a moveCount=0
				set /a keepCount=0
				set "archivedList="
				echo [DEBUG] PROCESSING "!folderPath!"

				for %%A in ("!folderPath!\*") do set /a fileCount+=1

				echo [SCAN] !folderName! - !fileCount! files >> "%logPath%"

				if !fileCount! LEQ %retention% (
					echo [SKIP] Less than %retention% files, so skipping !folderName!
					echo [SKIP] Less than %retention% files, so skipping !folderName! >> "%logPath%"
					echo. >> "%logPath%"
				) else (
					set /a index=0
					for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!"') do (
						set /a index+=1
						set "fileName=%%X"
						set "srcPath=!folderPath!\!fileName!"
						echo [DEBUG:  srcPath] !srcPath! >> "%logPath%"
						set "relativePath=!srcPath:%rootPath%=!"
						echo [DEBUG:  relativePath] !relativePath! >> "%logPath%"
						set "destPath=%archiveRoot%!relativePath!"
						echo [DEBUG:  destPath] !destPath! >> "%logPath%"
						set "destDir=!destPath:\!fileName!=!"
						set "destDir=%archiveRoot%\%%R\!folderName!"
						echo [DEBUG:  destDir] !destDir! >> "%logPath%"
						echo [DEBUG: Path desired: %archiveRoot%\%%R\!folderName! >> "%logPath%" 

						if !index! LEQ %retention% (
							set /a keepCount+=1
							echo [KEEP] !srcPath! >> "%logPath%"
						) else (
							set /a moveCount+=1
							echo [MOVE] !srcPath! will move to !destPath!  >> "%logPath%"
							if /i "!runMode!"=="EXECUTE" (
								if not exist "!destDir!" md "!destDir!"
								move /Y "!srcPath!" "!destPath!" >nul
							)
							set "archivedList=!archivedList!!fileName!, "
						)
					)

					echo. >> "%logPath%"
					
					if /i "!runMode!"=="EXECUTE" (
						echo === SUMMARY: !folderName! === >> "%logPath%"
						echo Total files : !fileCount! >> "%logPath%"
						echo Retained    : !keepCount! >> "%logPath%"
						echo Archived    : !moveCount! >> "%logPath%"
						if "!archivedList!"=="" (
							echo Archived Files: None >> "%logPath%"
						) else (
							echo Archived Files: !archivedList:~0,-2! >> "%logPath%"
						)
					) else (
						echo === SUMMARY in "!runMode!" mode: !folderName! === 
						echo Total files in "!runMode!" mode : !fileCount! 
						echo Retained in "!runMode!" mode: !keepCount! 
						echo Archived in "!runMode!" mode: !moveCount! 
						echo === SUMMARY in "!runMode!" mode: !folderName! === >> "%logPath%"
						echo Total files in "!runMode!" mode : !fileCount! >> "%logPath%"
						echo Retained in "!runMode!" mode: !keepCount! >> "%logPath%"
						echo Archived in "!runMode!" mode: !moveCount! >> "%logPath%"
						if "!archivedList!"=="" (
							echo Archived Files in "!runMode!" mode : None 
							echo Archived Files in "!runMode!" mode : None >> "%logPath%"
						) else (
							echo Archived Files in "!runMode!" mode  : !archivedList:~0,-2!
							echo Archived Files in "!runMode!" mode  : !archivedList:~0,-2! >> "%logPath%"
						)
					)
					echo. >> "%logPath%"
				)
			)
        )
    )
	echo=========================================================================================================
	echo========================================================================================================= >> "%logPath%"
)


:: --- Capture end epoch time (seconds since 1970-01-01 UTC) ---
for /f %%T in ('powershell -NoProfile -Command "[int]((Get-Date).ToUniversalTime() - [datetime]\'1970-01-01\').TotalSeconds"') do set "endEpoch=%%T"

:: Compute duration
set /a duration=endEpoch-startEpoch

:: Break duration into H:M:S
set /a hh=durationSec/3600
set /a mm=(durationSec%%3600)/60
set /a ss=durationSec%%60

:: Zero-padding (PowerShell handles it cleanly)
for /f %%X in ('powershell -NoProfile -Command "('{0:D2}:{1:D2}:{2:D2}' -f %hh%, %mm%, %ss%)"') do set "durationFmt=%%X"

echo === ARCHIVAL SCRIPT COMPLETED === in %durationFmt%  ^(%durationSec% seconds^)
echo === ARCHIVAL SCRIPT COMPLETED === in %durationFmt%  ^(%durationSec% seconds^) >> "%logPath%"
echo=========================================================================================================
echo========================================================================================================= >> "%logPath%"
echo. >> "%logPath%"
endlocal