@echo off
setlocal EnableDelayedExpansion
REM set "startTime=%TIME%"
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

:: ===== LAST 9 to be retained =====
set "retention=9"
set "archiveRoot=%rootPath%\archived"

:: ===== TIMESTAMP + LOG SETUP =====
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "startTime=%TIME%"
set "logDir=%rootPath%\archival-logs"
if not exist "%logDir%" mkdir "%logDir%"
set "logPath=%logDir%\archival-log-%ts%.txt"

echo === ARCHIVAL SCRIPT STARTED (%runMode%) === >> "%logPath%"
echo === ARCHIVAL SCRIPT STARTED (%runMode%) and logging to: %logPath%
echo runMode     : %runMode%
echo runMode     : %runMode% >> "%logPath%"
echo RootPath    : %rootPath% >> "%logPath%"
echo ArchivePath : %archiveRoot% >> "%logPath%"
echo LogFile     : %logPath% >> "%logPath%"
echo. >> "%logPath%"

:: ===== PROCESS TARGET FOLDERS =====
for %%R in (logs reports) do (
    set "targetFolder=%rootPath%\%%R"
	echo [DEBUG] Now traversing targetfolder "!targetFolder!"
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

			if exist "!folderPath!\jacoco-html-report-*" (
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
			) else (
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

				if !fileCount! LSS %retention% (
					echo [SKIP] Less than %retention% files — skipping !folderName! >> "%logPath%"
					echo. >> "%logPath%"
				) else (
					set /a index=0
					for /f "delims=" %%X in ('dir /b /a:-d /o:-d "!folderPath!"') do (
						set /a index+=1
						set "fileName=%%X"
						set "srcPath=!folderPath!\!fileName!"
						echo [HB : srcPath] !srcPath! >> "%logPath%"
						set "relativePath=!srcPath:%rootPath%=!"
						echo [HB : relativePath] !relativePath! >> "%logPath%"
						set "destPath=%archiveRoot%!relativePath!"
						echo [HB : destPath] !destPath! >> "%logPath%"
						set "destDir=!destPath:\!fileName!=!"
						set "destDir=%archiveRoot%\%%R\!folderName!"
						echo [HB : destDir] !destDir! >> "%logPath%"
						echo [Path desired: %archiveRoot%\%%R\!folderName! >> "%logPath%" 

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
						echo === SUMMARY in "!runMode!" mode: !folderName! === >> "%logPath%"
						echo Total files in "!runMode!" mode : !fileCount! >> "%logPath%"
						echo Retained in "!runMode!" mode: !keepCount! >> "%logPath%"
						echo Archived in "!runMode!" mode: !moveCount! >> "%logPath%"
						if "!archivedList!"=="" (
							echo Archived Files in "!runMode!" mode : None >> "%logPath%"
						) else (
							echo Archived Files in "!runMode!" mode  : !archivedList:~0,-2! >> "%logPath%"
						)
					)
					echo. >> "%logPath%"
				)
			)
        )
    )
)

set "endTime=%TIME%"
:: Function to convert HH:MM:SS.cc into seconds
for /f "tokens=1-4 delims=:.," %%a in ("%startTime%") do (
    set /a "startSecs=%%a*3600 + %%b*60 + %%c"
)

for /f "tokens=1-4 delims=:.," %%a in ("%endTime%") do (
    set /a "endSecs=%%a*3600 + %%b*60 + %%c"
)

set /a duration=%endSecs%-%startSecs%
echo === ARCHIVAL SCRIPT COMPLETED === in %duration% seconds >> "%logPath%"
echo. >> "%logPath%"
endlocal

