REM @echo off
REM setlocal enabledelayedexpansion

REM :: Move to repo root
REM cd /d "D:\GitHubRepos\udemy_lpa_javamasterclass"

REM :: Purge base destination
REM set "purgeBase=D:\GitHubRepos\udemy_lpa_javamasterclass\purged"

REM :: Roots to scan
REM set "roots=logs reports"
REM set "maxFiles=9"
REM set "DRY_RUN=0"   :: Change to 0 to allow actual moves

REM echo === Starting guarded purge move ===
REM for %%R in (%roots%) do (
    REM echo [ROOT] Scanning %%R\...

    REM for /f "delims=" %%D in ('dir /ad /b /s "%%R"') do (
        REM set "folder=%%D"
        REM set /a fileCount=0

        REM :: Count files first
        REM for /f "delims=" %%F in ('powershell -command "Get-ChildItem -Path '!folder!' -File | Sort-Object LastWriteTime -Descending | Select-Object -ExpandProperty FullName"') do (
            REM set /a fileCount+=1
        REM )

        REM if !fileCount! GTR %maxFiles% (
            REM echo [PURGE] !folder! has !fileCount! files — processing...

            REM set /a counter=0
            REM for /f "delims=" %%F in ('powershell -command "Get-ChildItem -Path '!folder!' -File | Sort-Object LastWriteTime -Descending | Select-Object -ExpandProperty FullName"') do (
                REM set /a counter+=1
                REM if !counter! GTR %maxFiles% (
                    REM set "file=%%F"
                    REM set "relPath=!file:D:\GitHubRepos\udemy_lpa_javamasterclass\=!"
                    REM if "!relPath!"=="" (
                        REM echo [SKIP] Empty relPath for: !file!
                        REM goto :continueLoop
                    REM )

                    REM set "targetPath=%purgeBase%!relPath!"
                    REM for %%X in ("!targetPath!") do (
                        REM if not exist "%%~dpX" (
                            REM echo [DEBUG] Creating folder: %%~dpX
                            REM mkdir "%%~dpX"
                        REM )
                    REM )

                    REM echo [MOVE] !file! ? !targetPath!
                    REM if !DRY_RUN! == 0 (
                        REM move "!file!" "!targetPath!" >nul
                        REM if exist "!targetPath!" (
                            REM echo [CONFIRMED] Moved: !file!
                        REM ) else (
                            REM echo [ERROR] Move failed for: !file!
                        REM )
                    REM ) else (
                        REM echo [DRY_RUN] Move skipped: !file!
                    REM )
                REM )
                REM :continueLoop
            REM )
            REM echo.
        REM )
    REM )
REM )
REM echo === Purge move complete ===
REM endlocal

REM :: Another script

REM @echo off
REM setlocal EnableDelayedExpansion

REM :: --- JaCoCo Coverage via PowerShell ---


REM if exist "..\reports\jacoco\jacoco-latest.xml" ( 
    REM for /f %%i in ('powershell -nologo -noprofile -Command "[xml]$xml = Get-Content '..\reports\\jacoco\\jacoco-latest.xml'; $c = $xml.report.counter | Where-Object { $_.type -eq 'INSTRUCTION' }; if ($c) { $cov = [int]$c.covered; $miss = [int]$c.missed; $t = $cov + $miss; if ($t -ne 0) { '{0:N2}%%' -f (($cov * 100.0) / $t) } else { '0%%'} } else { 'Accha' }" ') do (
        REM set jacocoSummary=%%i
		REM echo ?? InsideDo Code Coverage JaCoCo : %jacocoSummary%
		REM echo ?? InsideDoCode Coverage JaCoCo: !jacocoSummary!
    REM )
REM )
REM echo ?? OutsideDo Code Coverage (JaCoCo): %jacocoSummary%
REM echo ?? OutsideDo Code Coverage (JaCoCo): !jacocoSummary!
