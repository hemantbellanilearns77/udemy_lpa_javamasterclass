@echo off
setlocal EnableDelayedExpansion

:: ==============================
:: CONFIGURATION
:: ==============================
set "JAVA_HOME=C:\Program Files\Java\jdk-24\"
set "JACOCO_AGENT_JAR=D:\Tools\jacoco-0.8.13\lib\jacocoagent.jar"
set "JACOCO_CLI_JAR=D:\Tools\jacoco-0.8.13\lib\jacococli.jar"
set "JUNIT_CONSOLE_JAR=D:\Tools\junit-console\junit-platform-console-standalone-1.13.0.jar"

set "PROJECT_ROOT=D:\GitHubRepos\udemy_lpa_javamasterclass"
set "OUT_PROD_DIR=%PROJECT_ROOT%\out\production"
set "OUT_TEST_DIR=%PROJECT_ROOT%\out\test"
set "REPORT_DIR=%PROJECT_ROOT%\reports\jacoco"
set "LOG_DIR=%PROJECT_ROOT%\logs\jacoco-logs"
set "JUNIT_REPORT_DIR=%PROJECT_ROOT%\reports\junit\latest"

:: ==============================
:: TIMESTAMP AND FILE NAMES
:: ==============================
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "execFile=jacoco-%ts%.exec"
set "xmlFile=jacoco-%ts%.xml"
set "htmlDir=report-%ts%"
set "logFile=%LOG_DIR%\jacoco-%ts%.txt"

:: ==============================
:: FLAGS
:: ==============================
set "compileRequested=false"
for %%x in (%*) do (
    if "%%x"=="--plscompile" set "compileRequested=true"
)

:: ==============================
:: START LOGGING
:: ==============================
echo ================================================= >> "%logFile%"
echo ⚡ JaCoCo Coverage Script Run @ %ts% >> "%logFile%"
echo ================================================= >> "%logFile%"

:: ==============================
:: VALIDATE REQUIRED DIRECTORIES
:: ==============================
if not exist "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" (
    echo ❌ ERROR: Missing production classes >> "%logFile%"
    exit /b 1
)
if not exist "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" (
    echo ❌ ERROR: Missing test classes >> "%logFile%"
    exit /b 1
)
if not exist "%JUNIT_REPORT_DIR%" mkdir "%JUNIT_REPORT_DIR%"

:: ==============================
:: CLEAN + COMPILE (if requested)
:: ==============================
if "!compileRequested!"=="true" (
    echo ⚙ Cleaning old class files... >> "%logFile%"
    rmdir /s /q "%OUT_PROD_DIR%" >nul 2>&1
    rmdir /s /q "%OUT_TEST_DIR%" >nul 2>&1
    mkdir "%OUT_PROD_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_TEST_DIR%\udemy_lpa_javamasterclass"

    echo ✍ Compiling production code... >> "%logFile%"
    for /R "%PROJECT_ROOT%\src\main\java" %%f in (*.java) do javac -d "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"

    echo ✍ Compiling test code... >> "%logFile%"
    for /R "%PROJECT_ROOT%\src\test\java" %%f in (*.java) do javac -d "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"
) else (
    echo ❎ Skipping compilation -- no switch provided >> "%logFile%"
)

:: ==============================
:: RUN TESTS WITH JACOCO AGENT
:: ==============================
echo 🔎 Running tests with JaCoCo agent... >> "%logFile%"
"%JAVA_HOME%\bin\java" -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
    -jar "%JUNIT_CONSOLE_JAR%" ^
	--class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\misc_utils" ^
    --scan-class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\misc_utils" ^
    --reports-dir="%JUNIT_REPORT_DIR%" --details=tree >> "%logFile%" 2>&1

:: ==============================
:: VALIDATE COVERAGE OUTPUT
:: ==============================
if not exist "%REPORT_DIR%\%execFile%" (
    echo ❌ Coverage file not generated >> "%logFile%"
    exit /b 1
)

:: ==============================
:: GENERATE JACOCO REPORTS
:: ==============================
echo ✏ Generating XML and HTML reports... >> "%logFile%"
"%JAVA_HOME%\bin\java" -jar "%JACOCO_CLI_JAR%" report "%REPORT_DIR%\%execFile%" ^
    --classfiles "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" ^
    --sourcefiles "%PROJECT_ROOT%\src\main\java" ^
    --xml "%REPORT_DIR%\%xmlFile%" ^
    --html "%REPORT_DIR%\%htmlDir%" >> "%logFile%" 2>&1

copy /Y "%REPORT_DIR%\%xmlFile%" "%REPORT_DIR%\jacoco-latest.xml" >nul
copy /Y "%REPORT_DIR%\%execFile%" "%REPORT_DIR%\jacoco-latest.exec" >nul

:: ==============================
:: FINAL SUMMARY
:: ==============================
echo ✅ Coverage XML: %xmlFile% >> "%logFile%"
echo ✅ Coverage HTML: %htmlDir%\index.html >> "%logFile%"
echo ✅ Exec File: %execFile% >> "%logFile%"
echo ✅ Log File: %logFile% >> "%logFile%"

echo ⏱ End Time: %ts% >> "%logFile%"
echo ================================================= >> "%logFile%"

:: Show filtered summary on console (optional)
echo.
type "%logFile%" | findstr /C:"✅" /C:"❌" /C:"⚙" /C:"⏱" /C:"✏" /C:"❎"

endlocal
