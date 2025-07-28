@echo off
setlocal EnableDelayedExpansion

:: ================== CONFIG ==================
set "JAVA_HOME=%ProgramFiles%\Java\jdk-17"
set "JACOCO_AGENT_JAR=D:\Tools\jacoco-0.8.13\lib\jacocoagent.jar"
set "JACOCO_CLI_JAR=D:\Tools\jacoco-0.8.13\lib\jacococli.jar"
set "JUNIT_CONSOLE_JAR=D:\Tools\junit-platform\junit-platform-console-standalone-1.10.2.jar"

set "PROJECT_ROOT=%~dp0.."
set "SRC_DIR=src\main\java;misc_utils\src\main\java"
set "REPORT_DIR=%PROJECT_ROOT%\reports\jacoco"
set "LOG_DIR=%PROJECT_ROOT%\logs\jacoco-logs"
set "OUT_DIR=%PROJECT_ROOT%\out\production"

:: ================== TIMESTAMP ==================
for /f %%T in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set "ts=%%T"
set "execFile=jacoco-%ts%.exec"
set "xmlFile=jacoco-%ts%.xml"
set "htmlDir=report-%ts%"
set "logFile=%LOG_DIR%\jacoco-%ts%.txt"

:: ================== FLAGS ==================
set "skipCompile=false"
set "cleanOutDir=false"
for %%x in (%*) do (
    if "%%x"=="--skip-compile" set "skipCompile=true"
    if "%%x"=="--clean" set "cleanOutDir=true"
)

:: ================== VALIDATION ==================
if "!skipCompile!"=="true" if "!cleanOutDir!"=="true" (
    echo ??  Ignoring --clean because --skip-compile is also set.
    set "cleanOutDir=false"
)

:: ================== INIT ==================
if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"
if not exist "%OUT_DIR%\misc_utils" mkdir "%OUT_DIR%\misc_utils"
if not exist "%OUT_DIR%\udemylpajavamasterclass" mkdir "%OUT_DIR%\udemylpajavamasterclass"

:: ================== LOGGING ==================
(
echo ================================
echo ?? Start Time: %ts%
echo :: JaCoCo Coverage Script Run
echo ================================

:: ================== CLEAN (if valid) ==================
if "!cleanOutDir!"=="true" (
    echo ?? Cleaning out/production folder...
    rmdir /s /q "%OUT_DIR%" >nul 2>&1
    mkdir "%OUT_DIR%\misc_utils"
    mkdir "%OUT_DIR%\udemylpajavamasterclass"
)

:: ================== COMPILE ==================
if "!skipCompile!"=="true" (
    echo ?? Skipping compilation phase as per --skip-compile flag.
) else (
    echo ?? Compiling misc_utils...
    for /R "%PROJECT_ROOT%\misc_utils\src\main\java" %%f in (*.java) do (
        javac -d "%OUT_DIR%\misc_utils" "%%f"
    )

    echo ?? Compiling udemylpajavamasterclass...
    for /R "%PROJECT_ROOT%\src\main\java" %%f in (*.java) do (
        javac -d "%OUT_DIR%\udemylpajavamasterclass" "%%f"
    )
)

:: ================== TEST EXECUTION ==================
echo ?? Running tests with JaCoCo agent...

java -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
     -jar "%JUNIT_CONSOLE_JAR%" ^
     --scan-class-path "%OUT_DIR%\misc_utils;%OUT_DIR%\udemylpajavamasterclass"

if not exist "%REPORT_DIR%\%execFile%" (
    echo ? JaCoCo exec file not found. Aborting.
    exit /b 1
)

:: ================== GENERATE REPORTS ==================
echo ?? Generating XML and HTML reports...

java -jar "%JACOCO_CLI_JAR%" report "%REPORT_DIR%\%execFile%" ^
     --classfiles "%OUT_DIR%" ^
     --sourcefiles "%PROJECT_ROOT%\src\main\java" ^
     --sourcefiles "%PROJECT_ROOT%\misc_utils\src\main\java" ^
     --xml "%REPORT_DIR%\%xmlFile%" ^
     --html "%REPORT_DIR%\%htmlDir%"

copy /y "%REPORT_DIR%\%xmlFile%" "%REPORT_DIR%\jacoco-latest.xml" >nul
copy /y "%REPORT_DIR%\%execFile%" "%REPORT_DIR%\jacoco-latest.exec" >nul

echo.
echo ? Coverage XML:   %xmlFile%
echo ? Coverage HTML:  %htmlDir%\index.html
echo ? Exec Data File: %execFile%
echo ? Log File:       %logFile%
echo ?? End Time: %ts%
echo ================================
) > "%logFile%" 2>&1

endlocal
