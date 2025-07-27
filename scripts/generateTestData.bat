@echo off
setlocal enabledelayedexpansion

:: Base folder
set "root=D:\Temp\dummyJavaProject"
set "roots=logs reports"
set "fileCount=9"

echo === Starting test data generation with aging gaps ===

for %%R in (%roots%) do (
    echo [ROOT] Inspecting %%R...

    for /f "delims=" %%D in ('dir /ad /b /s "%root%\%%R"') do (
        set "subfolder=%%~nxD"
        set "targetPath=%%D"
        echo [FOLDER] Targeting: !targetPath!

        for /L %%I in (1,1,%fileCount%) do (
            :: Safe timestamp: no colon
            for /f %%T in ('powershell -nologo -command ^
                "Get-Date -Format 'dd-MM-yy-HH-mm-ss'"') do (
                set "ts=%%T"
            )

            set "filename=!subfolder!-!ts!.txt"
            set "fullpath=!targetPath!\!filename!"

            echo [CREATE] File %%I ? !fullpath!
            echo Test file %%I in !subfolder! > "!fullpath!"

            :: Random age: 0–730 days
            for /f %%A in ('powershell -nologo -command ^
                "[int](Get-Random -Minimum 0 -Maximum 730)"') do (
                set "ageDays=%%A"
            )

            :: Apply age
            powershell -nologo -command ^
                "(Get-Item '!fullpath!').LastWriteTime = (Get-Date).AddDays(-!ageDays!)"
            echo [AGE] Backdated !filename! by !ageDays! day(s)
        )
        echo.
    )
)

echo === Artificial