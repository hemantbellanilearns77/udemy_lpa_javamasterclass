@echo off
setlocal EnableDelayedExpansion

echo ===================================================
echo ?? Checkstyle Scanner — XML Output for SonarCloud
echo ===================================================

:: === Preserve original directory ===
set "originalDir=%CD%"
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do (
    set "timestamp=%%i"
)

:: === Paths ===
set "CHECKSTYLE_JAR=D:\Tools\checkstyle-10.26.1-all\checkstyle-10.26.1-all.jar"
set "RULESET=config\checkstyle\checkstyle.xml"
set "REPORT_DIR=reports\checkstyle"
set "LOG_DIR=logs\checkstyle-logs"
set "REPORT_PATH=%REPORT_DIR%\checkstyle-%timestamp%.xml"
set "LOG_PATH=%LOG_DIR%\checkstyle-log-%timestamp%.txt"

:: === Create folders if missing ===
if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: === Validate ruleset and jar ===
if not exist "%RULESET%" (
    echo ? Ruleset not found: %RULESET%
    cd /d "%originalDir%"
    pause
    exit /b 1
)
if not exist "%CHECKSTYLE_JAR%" (
    echo ? Checkstyle JAR missing: %CHECKSTYLE_JAR%
    cd /d "%originalDir%"
    pause
    exit /b 1
)

:: === Define source modules ===
set "MODULE_PATHS=misc_utils\src\main\java src\main\java"
set "SOURCE_DIRS="
echo.
echo ?? Scanning source modules...
for %%P in (%MODULE_PATHS%) do (
    set "tempPath=D:\GitHubRepos\udemy_lpa_javamasterclass\%%P"
    if exist "!tempPath!" (
        echo   ? Found: !tempPath!
        for /f %%C in ('dir /b /s "!tempPath!\*.java" ^| find /c /v ""') do (
            echo     ? %%C Java files in module
        )
        if defined SOURCE_DIRS (
            set "SOURCE_DIRS=!SOURCE_DIRS! !tempPath!"
        ) else (
            set "SOURCE_DIRS=!tempPath!"
        )
    ) else (
        echo   ? Skipped: !tempPath!
    )
)

:: === Validation ===
if "!SOURCE_DIRS!"=="" (
    echo ? No valid Java source directories found.
    cd /d "%originalDir%"
    pause
    exit /b 1
)

:: === Run Checkstyle ===
echo.
echo ?? Running Checkstyle...
java -jar "%CHECKSTYLE_JAR%" ^
  -c "%RULESET%" ^
  -f xml ^
  -o "%REPORT_PATH%" ^
  !SOURCE_DIRS! ^
  > "%LOG_PATH%" 2>&1

:: === Confirm report ===
echo.
if exist "%REPORT_PATH%" (
    echo ? XML report generated: %REPORT_PATH%
) else (
    echo ? No report generated!
)

:: === Append log summary ===
>> "%LOG_PATH%" echo Checkstyle finished at: %timestamp%
>> "%LOG_PATH%" echo Report path: %REPORT_PATH%

:: === Violation Summary ===
set "violationCount=0"
if exist "%REPORT_PATH%" (
    for /f "usebackq tokens=*" %%L in (`findstr /R "<error " "%REPORT_PATH%"`) do (
        set /a violationCount+=1
    )
    echo.
    echo ===== VIOLATION SUMMARY =====
    echo Total Violations: !violationCount!
    echo =============================
    >> "%LOG_PATH%" echo Total Violations: !violationCount!
)

:: === Optional Threshold Exit ===
:: Uncomment to activate exit-on-violation threshold
:: set "maxViolations=10"
:: if !violationCount! GEQ !maxViolations! (
::     echo ? Violation threshold exceeded: !violationCount! = !maxViolations!
::     cd /d "%originalDir%"
::     exit /b 1
:: )

:: === Wrap-up ===
echo.
echo ?? Execution log saved: %LOG_PATH%
cd /d "%originalDir%"
pause