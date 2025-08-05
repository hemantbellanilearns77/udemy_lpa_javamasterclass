@echo off
setlocal EnableDelayedExpansion

cd /d "%~dp0.."
:: ===== CONFIG =====
set "rootPath=%~1"
if "%rootPath%"=="" set "rootPath=%CD%"

set "runMode=DRY-RUN"
set "runMode=%~2"
if "%runMode%"=="" set "runMode=DRY-RUN"

:: ===== LAST 9 to be retained =====
set "retention=9"
set "archiveRoot=%rootPath%\archived"

:: ===== TIMESTAMP + LOG SETUP =====
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
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

    if not exist "!targetFolder!" (
        echo [SKIP] Missing: !targetFolder! >> "%logPath%"
        echo. >> "%logPath%"
    ) else (
        echo [PROCESSING ROOT] %%R >> "%logPath%"
        echo. >> "%logPath%"

        for /d %%F in ("!targetFolder!\*") do (
            setlocal EnableDelayedExpansion
            set "folderPath=%%~fF"
            set "folderName=%%~nxF"
            set /a fileCount=0
            set /a moveCount=0
            set /a keepCount=0
            set "archivedList="

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
                echo === SUMMARY: !folderName! === >> "%logPath%"
                echo Total files : !fileCount! >> "%logPath%"
                echo Retained    : !keepCount! >> "%logPath%"
                echo Archived    : !moveCount! >> "%logPath%"
                if "!archivedList!"=="" (
                    echo Archived Files: None >> "%logPath%"
                ) else (
                    echo Archived Files: !archivedList:~0,-2! >> "%logPath%"
                )
                echo. >> "%logPath%"
            )
            endlocal
        )
    )
)

echo === ARCHIVAL SCRIPT COMPLETED === >> "%logPath%"
echo. >> "%logPath%"
endlocal
