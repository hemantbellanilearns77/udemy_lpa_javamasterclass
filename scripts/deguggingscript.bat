@echo off
setlocal enabledelayedexpansion

:: Move to repo root
cd /d "D:\GitHubRepos\udemy_lpa_javamasterclass"

:: Purge base destination
set "purgeBase=D:\GitHubRepos\udemy_lpa_javamasterclass\purged"

:: Roots to scan
set "roots=logs reports"
set "maxFiles=9"
set "DRY_RUN=0"   :: Change to 0 to allow actual moves

echo === Starting guarded purge move ===
for %%R in (%roots%) do (
    echo [ROOT] Scanning %%R\...

    for /f "delims=" %%D in ('dir /ad /b /s "%%R"') do (
        set "folder=%%D"
        set /a fileCount=0

        :: Count files first
        for /f "delims=" %%F in ('powershell -command "Get-ChildItem -Path '!folder!' -File | Sort-Object LastWriteTime -Descending | Select-Object -ExpandProperty FullName"') do (
            set /a fileCount+=1
        )

        if !fileCount! GTR %maxFiles% (
            echo [PURGE] !folder! has !fileCount! files — processing...

            set /a counter=0
            for /f "delims=" %%F in ('powershell -command "Get-ChildItem -Path '!folder!' -File | Sort-Object LastWriteTime -Descending | Select-Object -ExpandProperty FullName"') do (
                set /a counter+=1
                if !counter! GTR %maxFiles% (
                    set "file=%%F"
                    set "relPath=!file:D:\GitHubRepos\udemy_lpa_javamasterclass\=!"
                    if "!relPath!"=="" (
                        echo [SKIP] Empty relPath for: !file!
                        goto :continueLoop
                    )

                    set "targetPath=%purgeBase%!relPath!"
                    for %%X in ("!targetPath!") do (
                        if not exist "%%~dpX" (
                            echo [DEBUG] Creating folder: %%~dpX
                            mkdir "%%~dpX"
                        )
                    )

                    echo [MOVE] !file! ? !targetPath!
                    if !DRY_RUN! == 0 (
                        move "!file!" "!targetPath!" >nul
                        if exist "!targetPath!" (
                            echo [CONFIRMED] Moved: !file!
                        ) else (
                            echo [ERROR] Move failed for: !file!
                        )
                    ) else (
                        echo [DRY_RUN] Move skipped: !file!
                    )
                )
                :continueLoop
            )
            echo.
        )
    )
)
echo === Purge move complete ===
endlocal