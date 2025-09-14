@echo off
setlocal enabledelayedexpansion

echo ===================================================
echo PMD Scanner — XML Output for SonarCloud
echo ===================================================
set "executionEnv=%~1
if /i "%executionEnv%"=="githubactions" goto :github
if /i "%executionEnv%"=="local" goto :local
goto :unsupported

:github
echo === Running in GitHub Actions ===

:: === SETUP ===
cd /d %~dp0..
set "REPO_ROOT=%CD%"
set "PMD_HOME=%REPO_ROOT%\tools\pmd\pmd-bin-7.15.0"
set "SRC_DIRS=%REPO_ROOT%\misc_utils\src\main\java,%REPO_ROOT%\src\main\java"
set "RULESET=%REPO_ROOT%\config\pmd\pmd-ruleset.xml"

:: === TIMESTAMP ===
for /f "tokens=1-2 delims= " %%a in ('echo %DATE% %TIME%') do set TS=%%a--%%b
set "TS=%TS::=-%"
set "TS=%TS:/=-%"
set "TS=%TS: =0%"
set "TS=%TS:.=-%"

:: === OUTPUTS ===
set "REPORTS_DIR=%REPO_ROOT%\reports\pmd"
set "LOGS_DIR=%REPO_ROOT%\logs\pmd-analysis-logs"
set "TEXT_REPORT=%REPORTS_DIR%\pmd-%TS%.txt"
set "XML_REPORT=%REPORTS_DIR%\pmd-%TS%.xml"
set "LOG_FILE=%LOGS_DIR%\pmd-%TS%.log"

mkdir "%REPORTS_DIR%" 2>nul
mkdir "%LOGS_DIR%" 2>nul

:: === CLASSPATH BUILD ===
REM set CLASSPATH=
REM for %%J in ("%PMD_HOME%\lib\*.jar") do (
    REM if defined CLASSPATH (
        REM set CLASSPATH=!CLASSPATH!;%%~fJ
    REM ) else (
        REM set CLASSPATH=%%~fJ
    REM )
REM )

:: === DIAGNOSTICS ===
echo ===== PMD ANALYSIS START =====
echo REPO_ROOT:   %REPO_ROOT%
echo PMD_HOME:    %PMD_HOME%
REM echo CLASSPATH:   %CLASSPATH%
echo CLASSPATH:   using PMD wrapper script – no longer needed
echo SOURCE DIRS: %SRC_DIRS%
echo RULESET:     %RULESET%
echo TEXT REPORT: %TEXT_REPORT%
echo XML REPORT:  %XML_REPORT%
echo ===========================================

REM :: === PMD TEXT REPORT ===
REM echo Running PMD Text Analysis...
REM java -cp "%CLASSPATH%" net.sourceforge.pmd.cli.PmdCli check ^
  REM --no-progress ^
  REM --rulesets "%RULESET%" ^
  REM --dir "%SRC_DIRS%" ^
  REM --format text ^
  REM --report-file "%TEXT_REPORT%" ^
  REM > "%LOG_FILE%" 2>&1

REM :: === PMD XML REPORT ===
REM echo Running PMD XML Analysis...
REM java -cp "%CLASSPATH%" net.sourceforge.pmd.cli.PmdCli check ^
  REM --no-progress ^
  REM --rulesets "%RULESET%" ^
  REM --dir "%SRC_DIRS%" ^
  REM --format xml ^
  REM --report-file "%XML_REPORT%" ^
  REM >> "%LOG_FILE%" 2>&1
  
:: === RUN PMD ANALYSIS (TEXT) ===
echo Running PMD Text Analysis...
call "%PMD_HOME%\bin\pmd.bat" check ^
  --no-progress ^
  --rulesets "%RULESET%" ^
  --dir "%SRC_DIRS%" ^
  --format text ^
  --report-file "%TEXT_REPORT%" ^

:: === RUN PMD ANALYSIS (XML) ===
echo Running PMD XML Analysis...
call "%PMD_HOME%\bin\pmd.bat" check ^
  --no-progress ^
  --rulesets "%RULESET%" ^
  --dir "%SRC_DIRS%" ^
  --format xml ^
  --report-file "%XML_REPORT%" ^
  >> "%LOG_FILE%" 2>&1


:: === CHECK OUTPUT ===
echo.
if exist "%TEXT_REPORT%" (
    echo ✅ Text report generated: %TEXT_REPORT%
) else (
    echo ❌ Text report missing
)

if exist "%XML_REPORT%" (
    echo ✅ XML report generated: %XML_REPORT%
) else (
    echo ❌ XML report missing
)

:: === SUMMARY ===
REM if exist "%XML_REPORT%" (
    REM echo.
    REM echo ===== VIOLATION SUMMARY =====
    REM set /a violationCount=0
    REM for /f "usebackq delims=" %%L in ("%XML_REPORT%") do (
        REM set /a violationCount+=1
    REM )
    REM echo Total Violations: !violationCount!
    REM echo =============================
REM )
REM echo.
echo ======= Log file is at: %LOG_FILE% =======
echo.
goto :end

:local
echo === Running Locally ===
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
if exist "!XML_REPORT!" (
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
echo ======= Log file is at: %LOG_FILE% =======
echo.
goto :end

:unsupported
echo Unsupported environment: %executionEnv%
exit /b 1

:end
echo PMD Analysis complete.
endlocal
exit /b 0