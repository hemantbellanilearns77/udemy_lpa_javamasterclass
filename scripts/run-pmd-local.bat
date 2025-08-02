@echo off
setlocal enabledelayedexpansion

:: === CONFIGURATION ===
cd /d %~dp0..
set "REPO_ROOT=%CD%"
set "PMD_HOME=%REPO_ROOT%\tools\pmd\pmd-dist-7.15.0-bin\pmd-bin-7.15.0"
set "SRC_DIRS=%REPO_ROOT%\misc_utils\src\main\java,%REPO_ROOT%\src\main\java"
set "RULESET=%REPO_ROOT%\config\pmd\pmd-ruleset.xml"

:: === TIMESTAMP ===
for /f "tokens=1-2 delims= " %%a in ('echo %DATE% %TIME%') do set TS=%%a--%%b
set "TS=%TS::=-%"
set "TS=%TS:/=-%"
set "TS=%TS: =0%"
set "TS=%TS:.=-%"

:: === OUTPUT PATHS ===
set "REPORTS_DIR=%REPO_ROOT%\reports\pmd"
set "LOGS_DIR=%REPO_ROOT%\logs\pmd-analysis-logs"
set "TEXT_REPORT=%REPORTS_DIR%\pmd-report-%TS%.txt"
set "XML_REPORT=%REPORTS_DIR%\pmd-report-%TS%-report.xml"
set "LOG_FILE=%LOGS_DIR%\pmd-log-%TS%.txt"

if not exist "%REPORTS_DIR%" mkdir "%REPORTS_DIR%"
if not exist "%LOGS_DIR%" mkdir "%LOGS_DIR%"

:: === CLASSPATH (Wildcard) ===
set "CLASSPATH=%PMD_HOME%\lib\*"

:: === DIAGNOSTICS ===
echo.
echo ===== PMD LOCAL ANALYSIS =====
echo REPO_ROOT:   %REPO_ROOT%
echo PMD_HOME:    %PMD_HOME%
echo CLASSPATH:   %CLASSPATH%
echo SOURCE DIRS: %SRC_DIRS%
echo RULESET:     %RULESET%
echo TEXT REPORT: %TEXT_REPORT%
echo XML REPORT:  %XML_REPORT%
echo ===========================================
echo.

:: === RUN PMD ANALYSIS (TEXT) ===
echo Running PMD Text Analysis...
java -cp "%CLASSPATH%" net.sourceforge.pmd.cli.PmdCli check ^
  --no-progress ^
  --rulesets "%RULESET%" ^
  --dir "%SRC_DIRS%" ^
  --format text ^
  --report-file "%TEXT_REPORT%" ^
  > "%LOG_FILE%" 2>&1
:: === RUN PMD ANALYSIS (XML) ===
echo Running PMD XML Analysis...
java -cp "%CLASSPATH%" net.sourceforge.pmd.cli.PmdCli check ^
  --no-progress ^
  --rulesets "%RULESET%" ^
  --dir "%SRC_DIRS%" ^
  --format xml ^
  --report-file "%XML_REPORT%" ^
  >> "%LOG_FILE%" 2>&1
:: === FINAL CHECKS ===
echo.
if exist "%TEXT_REPORT%" (
    echo ? Text report generated at: %TEXT_REPORT%
) else (
    echo ? Text report missing
)

if exist "%XML_REPORT%" (
    echo ? XML report generated at: %XML_REPORT%
) else (
    echo ? XML report missing
)

:: === Violation Summary ===
if exist "!TEXT_REPORT!" (
    echo.
    echo ===== VIOLATION SUMMARY =====
    set "violationCount=0"
    for /f "usebackq delims=" %%L in ("!TEXT_REPORT!") do (
        set /a violationCount+=1
    )
    echo Total Violations: !violationCount!
    echo =============================
)
echo.
echo Log file (if redirected): %LOG_FILE%
echo Done.
endlocal
