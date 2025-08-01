@echo off
setlocal EnableDelayedExpansion

:: === Preserve original directory ===
set "originalDir=%CD%"
REM cd /d D:\GitHubRepos\udemy_lpa_javamasterclass
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT ------------  !REPO_ROOT!
echo originalDir is --------------- !originalDir!
:: === Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do (
    set "timestamp=%%i"
)

:: === PMD setup ===
set "PMD_HOME=!REPO_ROOT!\tools\pmd\pmd-dist-7.15.0-bin\pmd-bin-7.15.0"
set "CLASSPATH="
for %%F in ("%PMD_HOME%\lib\*.jar") do (
    if defined CLASSPATH (
        set "CLASSPATH=!CLASSPATH!;%%~fF"
    ) else (
        set "CLASSPATH=%%~fF"
    )
)

:: === Rule and output paths ===
set "RULESET=!REPO_ROOT!\config\pmd\pmd-ruleset.xml"
set "REPORT_DIR=!REPO_ROOT!\reports\pmd"
set "LOG_DIR=!REPO_ROOT!\logs\pmd-scan-logs"
set "REPORT_TXT=%REPORT_DIR%\pmd-report-%timestamp%.txt"
set "REPORT_XML=%REPORT_DIR%\pmd-report-%timestamp%.xml"
set "LOG_PATH=%LOG_DIR%\pmd-log-%timestamp%.txt"

:: === Resolve absolute report paths ===
for %%F in ("%REPORT_TXT%") do set "REPORT_TXT_FULL=%%~fF"
for %%F in ("%REPORT_XML%") do set "REPORT_XML_FULL=%%~fF"

:: === Define modules ===
set "MODULE_PATHS=misc_utils\src\main\java src\main\java"
set "SOURCE_DIRS="
echo Scanning source modules...
for %%P in (%MODULE_PATHS%) do (
    set "tempPath=!REPO_ROOT!\%%P"
    if exist "!tempPath!" (
        echo   ? Found: !tempPath!
        for /f %%C in ('dir /b /s "!tempPath!\*.java" ^| find /c /v ""') do (
            echo     ? %%C Java files in module
        )
        if defined SOURCE_DIRS (
            set "SOURCE_DIRS=!SOURCE_DIRS!,!tempPath!"
        ) else (
            set "SOURCE_DIRS=!tempPath!"
        )
    ) else (
        echo   ? Skipped: !tempPath!
    )
)

:: === Validations ===
if "!SOURCE_DIRS!"=="" (
    echo ERROR: No valid source directories found.
    cd /d "%originalDir%"
    pause
    exit /b
)

if not exist "%RULESET%" (
    echo ERROR: Ruleset file missing — %RULESET%
    cd /d "%originalDir%"
    pause
    exit /b
)

if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: === Diagnostics ===
echo.
echo ===== DIAGNOSTICS =====
echo CLASSPATH: !CLASSPATH! 
echo===================================================================================================================
echo SOURCE_DIRS: !SOURCE_DIRS!
echo===================================================================================================================
echo TEXT REPORT: !REPORT_TXT_FULL!
echo===================================================================================================================
echo XML REPORT:  !REPORT_XML_FULL!
echo =======================
echo.

:: === Run PMD Text ===
echo Running PMD Text Analysis...
java -cp "!CLASSPATH!" -X net.sourceforge.pmd.cli.PmdCli check ^
  --no-cache ^
  --verbose
  --dir "!SOURCE_DIRS!" ^
  --rulesets "%RULESET%" ^
  --format text ^
  --report-file "!REPORT_TXT_FULL!" ^
  > "%LOG_PATH%" 2>&1

:: === Run PMD XML ===
echo Running PMD XML Analysis...
java -cp "!CLASSPATH!" net.sourceforge.pmd.cli.PmdCli check ^
  --no-cache ^
  --dir "!SOURCE_DIRS!" ^
  --rulesets "%RULESET%" ^
  --format xml ^
  --report-file "!REPORT_XML_FULL!" ^
  >> "%LOG_PATH%" 2>&1

:: === Validate Reports ===
echo Checking for txt Report at: !REPORT_TXT_FULL!
echo Checking for xml Report at: !REPORT_XML_FULL!
echo.
if exist "!REPORT_TXT_FULL!" (
    echo ? Text report generated.
) else (
    echo ? Missing text report!
)

if exist "!REPORT_XML_FULL!" (
    echo ? XML report generated.
) else (
    echo ? Missing XML report!
)

:: === Violation Summary ===
if exist "!REPORT_TXT_FULL!" (
    echo.
    echo ===== VIOLATION SUMMARY =====
    set "violationCount=0"
    for /f "usebackq delims=" %%L in ("!REPORT_TXT_FULL!") do (
        set /a violationCount+=1
    )
    echo Total Violations: !violationCount!
    echo =============================
)

:: === Wrap-up ===
echo.
echo Execution log saved: %LOG_PATH%
cd /d "%originalDir%"
pause