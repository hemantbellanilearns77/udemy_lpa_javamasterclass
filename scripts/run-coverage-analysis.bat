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

for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "execFile=jacoco-%ts%.exec"
set "xmlFile=jacoco-report-%ts%.xml"
set "htmlDir=jacoco-html-report-%ts%"
set "logFile=%LOG_DIR%\jacoco-log-%ts%.txt"

if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"
if not exist "%JUNIT_REPORT_DIR%" mkdir "%JUNIT_REPORT_DIR%"

echo ⚡ JaCoCo Coverage Run @ %ts% > "%logFile%"

:: === CONDITIONAL COMPILATION ===
set "compileNeeded=true"
if exist "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" set "compileNeeded=false"
if exist "%OUT_PROD_DIR%\misc_utils" set "compileNeeded=false"
if exist "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" set "compileNeeded=false"
if exist "%OUT_TEST_DIR%\misc_utils" set "compileNeeded=false"

if "!compileNeeded!"=="true" (
    echo ⚙ Compiling classes... >> "%logFile%"
    for /R "%PROJECT_ROOT%\src\main\java" %%f in (*.java) do javac -d "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"
    for /R "%PROJECT_ROOT%\misc_utils\src\main\java" %%f in (*.java) do javac -d "%OUT_PROD_DIR%\misc_utils" "%%f"
    for /R "%PROJECT_ROOT%\src\test\java" %%f in (*.java) do javac -d "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" "%%f"
    for /R "%PROJECT_ROOT%\misc_utils\src\test\java" %%f in (*.java) do javac -d "%OUT_TEST_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\misc_utils" "%%f"
) else (
    echo ⏩ Skipping compilation – class files found >> "%logFile%"
)

:: === RUN TESTS ===
"%JAVA_HOME%\bin\java" -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
  -jar "%JUNIT_CONSOLE_JAR%" ^
  --class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
  --scan-class-path "%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
  --reports-dir="%JUNIT_REPORT_DIR%" --details=tree >> "%logFile%" 2>&1

if not exist "%REPORT_DIR%\%execFile%" (
    echo ❌ Coverage file not generated >> "%logFile%"
    exit /b 1
)

:: === GENERATE REPORTS ===
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
type "%logFile%" | findstr /C:"✅" /C:"❌"

endlocal
