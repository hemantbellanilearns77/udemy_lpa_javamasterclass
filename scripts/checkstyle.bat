@echo off
setlocal EnableDelayedExpansion
echo ===================================================
echo Checkstyle Scanner — XML Output for SonarCloud
echo ===================================================
set "executionEnv=%~1
if /i "%executionEnv%"=="githubactions" goto :github
if /i "%executionEnv%"=="local" goto :local
goto :unsupported

:github
echo === Running in GitHub Actions ===
:: === Set working directory ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"

:: === Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do (
    set "timestamp=%%i"
)

:: === Paths ===
set "CHECKSTYLE_JAR=tools\checkstyle\checkstyle-10.26.1-all.jar"
set "RULESET=config\checkstyle\checkstyle.xml"
set "REPORT_DIR=reports\checkstyle"
set "LOG_DIR=logs\checkstyle-logs"
set "TEXT_REPORT_PATH=%REPORT_DIR%\checkstyle-report-%timestamp%.txt"
set "XML_REPORT_PATH=%REPORT_DIR%\checkstyle-report-%timestamp%.xml"
set "LOG_PATH=%LOG_DIR%\checkstyle-log-%timestamp%.txt"

:: === Create folders if missing ===
if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: === Validate ruleset and jar ===
if not exist "%RULESET%" (
    echo ? Ruleset not found: %RULESET%
    exit /b 1
)
if not exist "%CHECKSTYLE_JAR%" (
    echo ? Checkstyle JAR missing: %CHECKSTYLE_JAR%
    exit /b 1
)

:: === Define source modules ===
set "MODULE_PATHS=misc_utils\src\main\java src\main\java"
set "SOURCE_DIRS="
echo.
echo ?? Scanning source modules...
for %%P in (%MODULE_PATHS%) do (
    set "tempPath=!REPO_ROOT!\%%P"
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
    exit /b 1
)

:: === Run Checkstyle - Text ===
echo.
echo ?? Running Checkstyle - text ...
java -jar "%CHECKSTYLE_JAR%" ^
  -c "%RULESET%" ^
  -f plain ^
  -o "%TEXT_REPORT_PATH%" ^
  !SOURCE_DIRS! ^
  > "%LOG_PATH%" 2>&1
  
:: === Run Checkstyle - XML ===
echo.
echo ?? Running Checkstyle - xml ...
java -jar "%CHECKSTYLE_JAR%" ^
  -c "%RULESET%" ^
  -f xml ^
  -o "%XML_REPORT_PATH%" ^
  !SOURCE_DIRS! ^
  > "%LOG_PATH%" 2>&1

:: === Confirm text report ===
echo.
if exist "%XML_REPORT_PATH%" (
    echo ? XML report generated: %XML_REPORT_PATH%
) else (
    echo ? No XML report generated!
)

:: === Confirm xml report ===
echo.
if exist "%TEXT_REPORT_PATH%" (
    echo ? TEXT  report generated: %TEXT_REPORT_PATH%
) else (
    echo ? No TEXT report generated!
)

:: === Append log summary ===
>> "%LOG_PATH%" echo Checkstyle finished at: %timestamp%
>> "%LOG_PATH%" echo TEXT Report path: %TEXT_REPORT_PATH%
>> "%LOG_PATH%" echo XML Report path: %XML_REPORT_PATH%

:: === Violation Summary ===
set "violationCount=0"
if exist "%XML_REPORT_PATH%" (
    for /f "usebackq tokens=*" %%L in (`findstr /R "<error " "%XML_REPORT_PATH%"`) do (
        set /a violationCount+=1
    )
    echo.
    echo ===== VIOLATION SUMMARY =====
    echo Total Violations: !violationCount!
    echo =============================
    >> "%LOG_PATH%" echo Total Violations: !violationCount!
)

:: === Optional Threshold Exit ===
:: set "maxViolations=10"
:: if !violationCount! GEQ !maxViolations! (
::     echo ? Violation threshold exceeded: !violationCount! = !maxViolations!
::     exit /b 1
:: )

:: === Wrap-up ===
echo.
echo ====== Execution log saved: %LOG_PATH%
goto :end

:local
echo === Running Locally ===
:: === Set working directory ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT ------------  !REPO_ROOT!
:: === Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do (
    set "timestamp=%%i"
)

:: === Paths ===
set "CHECKSTYLE_JAR=%REPO_ROOT%\tools\checkstyle\checkstyle-10.26.1-all.jar"
set "RULESET=%REPO_ROOT%\config\checkstyle\checkstyle.xml"
set "REPORT_DIR=%REPO_ROOT%\reports\checkstyle"
set "LOG_DIR=%REPO_ROOT%\logs\checkstyle-logs"
REM set "REPORT_PATH=%REPORT_DIR%\checkstyle-%timestamp%.xml"
set "TEXT_REPORT_PATH=%REPORT_DIR%\checkstyle-report-%timestamp%.txt"
set "XML_REPORT_PATH=%REPORT_DIR%\checkstyle-report-%timestamp%.xml"
set "LOG_PATH=%LOG_DIR%\checkstyle-log-%timestamp%.txt"
echo CHECKSTYLE_JAR ------------  !CHECKSTYLE_JAR! 
:: === Create folders if missing ===
if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: === Validate ruleset and jar ===
if not exist "%RULESET%" (
    echo ? Ruleset not found: %RULESET%
    exit /b 1
)
if not exist "%CHECKSTYLE_JAR%" (
    echo ? Checkstyle JAR missing: %CHECKSTYLE_JAR%
    exit /b 1
)

:: === Define source modules ===
set "MODULE_PATHS=misc_utils\src\main\java src\main\java"
set "SOURCE_DIRS="
echo.
echo ?? Scanning source modules...
for %%P in (%MODULE_PATHS%) do (
    set "tempPath=!REPO_ROOT!\%%P"
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
    exit /b 1
)

REM :: === Run Checkstyle ===
REM echo.
REM echo ?? Running Checkstyle...
REM java -jar "%CHECKSTYLE_JAR%" ^
  REM -c "%RULESET%" ^
  REM -f xml ^
  REM -o "%REPORT_PATH%" ^
  REM !SOURCE_DIRS! ^
  REM > "%LOG_PATH%" 2>&1

REM :: === Confirm report ===
REM echo.
REM if exist "%REPORT_PATH%" (
    REM echo ? XML report generated: %REPORT_PATH%
REM ) else (
    REM echo ? No report generated!
REM )

:: === Run Checkstyle - Text ===
echo.
echo ?? Running Checkstyle - text ...
java -jar "%CHECKSTYLE_JAR%" ^
  -c "%RULESET%" ^
  -f plain ^
  -o "%TEXT_REPORT_PATH%" ^
  !SOURCE_DIRS! ^
  > "%LOG_PATH%" 2>&1
  
:: === Run Checkstyle - XML ===
echo.
echo ?? Running Checkstyle - xml ...
java -jar "%CHECKSTYLE_JAR%" ^
  -c "%RULESET%" ^
  -f xml ^
  -o "%XML_REPORT_PATH%" ^
  !SOURCE_DIRS! ^
  > "%LOG_PATH%" 2>&1

:: === Confirm text report ===
echo.
if exist "%XML_REPORT_PATH%" (
    echo ? XML report generated: %XML_REPORT_PATH%
) else (
    echo ? No XML report generated!
)

:: === Confirm xml report ===
echo.
if exist "%TEXT_REPORT_PATH%" (
    echo ? TEXT  report generated: %TEXT_REPORT_PATH%
) else (
    echo ? No TEXT report generated!
)

:: === Append log summary ===
>> "%LOG_PATH%" echo Checkstyle finished at: %timestamp%
>> "%LOG_PATH%" echo Report path: %REPORT_PATH%

:: === Violation Summary ===
set "violationCount=0"
if exist "%XML_REPORT_PATH%" (
    for /f "usebackq tokens=*" %%L in (`findstr /R "<error " "%XML_REPORT_PATH%"`) do (
        set /a violationCount+=1
    )
    echo.
    echo ===== VIOLATION SUMMARY =====
    echo Total Violations: !violationCount!
    echo =============================
    >> "%LOG_PATH%" echo Total Violations: !violationCount!
)

:: === Optional Threshold Exit ===
:: set "maxViolations=10"
:: if !violationCount! GEQ !maxViolations! (
::     echo ? Violation threshold exceeded: !violationCount! = !maxViolations!
::     exit /b 1
:: )

:: === Wrap-up ===
echo.
echo  ====== Execution log saved: %LOG_PATH%
goto :end

:unsupported
echo Unsupported environment: %executionEnv%
exit /b 1

:end
echo Checkstyle Analysis complete.
exit /b 0







