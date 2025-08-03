@echo off
setlocal EnableDelayedExpansion

:: === RELATIVE PATH SETUP ===
cd /d %~dp0..
set "PROJECT_ROOT=%CD%"
set "JACOCO_HOME=%PROJECT_ROOT%\tools\jacoco-0.8.13"
set "JAVA_HOME=C:\Program Files\Java\jdk-24"
set "JACOCO_AGENT_JAR=%JACOCO_HOME%\lib\jacocoagent.jar"
set "JACOCO_CLI_JAR=%JACOCO_HOME%\lib\jacococli.jar"
set "JUNIT_CONSOLE_JAR=%PROJECT_ROOT%\tools\junit-console\junit-platform-console-standalone-1.13.0.jar"

set "OUT_PROD_DIR=%PROJECT_ROOT%\out\production"
set "OUT_TEST_DIR=%PROJECT_ROOT%\out\test"
set "REPORT_DIR=%PROJECT_ROOT%\reports\jacoco"
set "LOG_DIR=%PROJECT_ROOT%\logs\jacoco-logs"
set "JUNIT_REPORT_DIR=%PROJECT_ROOT%\reports\junit\latest"

:: === TIMESTAMP & FILENAMES ===
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "execFile=jacoco-%ts%.exec"
set "xmlFile=jacoco-report-%ts%.xml"
set "htmlDir=jacoco-html-report-%ts%"
set "logFile=%LOG_DIR%\jacoco-log-%ts%.txt"

if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"
if not exist "%JUNIT_REPORT_DIR%" mkdir "%JUNIT_REPORT_DIR%"

echo ⚡ JaCoCo Coverage Run @ %ts% > "%logFile%"

:: === COMPILE IF BOTH PROD MODULES ARE MISSING ===
set "compileNeeded=false"
if not exist "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" (
    if not exist "%OUT_PROD_DIR%\misc_utils" (
        set "compileNeeded=true"
    )
)

if "!compileNeeded!"=="true" (
    echo ⚙ Compiling all sources >> "%logFile%"
    rmdir /s /q "%OUT_PROD_DIR%" 2>nul
    rmdir /s /q "%OUT_TEST_DIR%" 2>nul
    mkdir "%OUT_PROD_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_PROD_DIR%\misc_utils"
    mkdir "%OUT_TEST_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_TEST_DIR%\misc_utils"

    echo ✍ Compiling udemy_lpa_javamasterclass >> "%logFile%"
    for /R "%PROJECT_ROOT%\src\main\java" %%f in (*.java) do javac -d "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"

    echo ✍ Compiling misc_utils (depends on masterclass) >> "%logFile%"
    for /R "%PROJECT_ROOT%\misc_utils\src\main\java" %%f in (*.java) do javac -d "%OUT_PROD_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"
) else (
    echo ✅ Using precompiled .class files >> "%logFile%"
)

:: === RUN TESTS WITH JACOCO AGENT ===
"%JAVA_HOME%\bin\java" -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
    -jar "%JUNIT_CONSOLE_JAR%" ^
    --class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --scan-class-path "%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --reports-dir="%JUNIT_REPORT_DIR%" --details=tree >> "%logFile%" 2>&1

if not exist "%REPORT_DIR%\%execFile%" (
    echo ❌ Coverage file not generated >> "%logFile%"
    exit /b 1
)

:: === GENERATE REPORT ===
"%JAVA_HOME%\bin\java" -jar "%JACOCO_CLI_JAR%" report "%REPORT_DIR%\%execFile%" ^
    --classfiles "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" ^
    --classfiles "%OUT_PROD_DIR%\misc_utils" ^
    --sourcefiles "%PROJECT_ROOT%\src\main\java" ^
    --sourcefiles "%PROJECT_ROOT%\misc_utils\src\main\java" ^
    --xml "%REPORT_DIR%\%xmlFile%" ^
    --html "%REPORT_DIR%\%htmlDir%" >> "%logFile%" 2>&1

copy /Y "%REPORT_DIR%\%xmlFile%" "%REPORT_DIR%\jacoco-latest.xml" >nul
copy /Y "%REPORT_DIR%\%execFile%" "%REPORT_DIR%\jacoco-latest.exec" >nul

echo ✅ XML Report: %xmlFile% >> "%logFile%"
echo ✅ HTML Report: %htmlDir%\index.html >> "%logFile%"
echo ✅ Exec File: %execFile% >> "%logFile%"

echo.
type "%logFile%" | findstr /C:"✅" /C:"❌"
endlocal
