REM @echo off
REM setlocal enabledelayedexpansion

REM Set the root directory here
REM set "ROOT="

REM Traverse all subdirectories
REM for /d /r "%ROOT%" %%F in (*) do (
REM     set "FOLDER=%%~nxF"
REM     if /i "!FOLDER!"=="misc_practice" (
REM         ren "%%F" "misc_codedemo"
REM         echo Renamed: %%F → misc_codedemo
REM     )
)

REM echo.
REM echo ✅ All matching folders have been renamed.
REM pause