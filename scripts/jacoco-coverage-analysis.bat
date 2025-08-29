@echo off
setlocal EnableDelayedExpansion
echo ======================================================
echo JACOCO Coverage Analysis — XML Output for SonarCloud
echo ======================================================
set "executionEnv=%~1
if /i "%executionEnv%"=="githubactions" goto :github
if /i "%executionEnv%"=="local" goto :local
goto :unsupported

:github
echo === Running in GitHub Actions ===
if not defined JAVA_HOME (
    echo ❌ ERROR: JAVA_HOME is not set
    exit /b 1
)
cd /d %~dp0..
set "PROJECT_ROOT=%CD%"
set "JACOCO_HOME=%PROJECT_ROOT%\tools\jacoco-0.8.13"
REM set "JAVA_HOME=C:\Program Files\Java\jdk-24"
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

:: ========== COMPILE IF NEEDED ==========
set "compileNeeded=false"
if not exist "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" (
    if not exist "%OUT_PROD_DIR%\misc_utils" (
		echo i came in here 
        set "compileNeeded=true"
    )
) else (
   echo Hello compileNeeded is: %compileNeeded%
) 
if "!compileNeeded!"=="true" (
	echo I reached inside true for compileNeeded
    echo ? Compilation triggered >> "%logFile%"
	echo ? Compilation triggered
    rmdir /s /q "%OUT_PROD_DIR%" 2>nul
    rmdir /s /q "%OUT_TEST_DIR%" 2>nul
    mkdir "%OUT_PROD_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_PROD_DIR%\misc_utils"
    mkdir "%OUT_TEST_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_TEST_DIR%\misc_utils"

    echo ? Compiling udemy_lpa_javamasterclass  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\src\main\java\*.java" > sources_main_master.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_main_master.txt >> "%logFile%" 2>&1

    echo ? Compiling misc_utils depends on masterclass >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\misc_utils\src\main\java\*.java" > sources_main_misc.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_PROD_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_main_misc.txt >> "%logFile%" 2>&1

    echo ? Compiling udemy_lpa_javamasterclass TEST classes  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\src\test\java\*.java" > sources_test_master.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_test_master.txt >> "%logFile%" 2>&1

    echo ? Compiling misc_utils TEST classes  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\misc_utils\src\test\java\*.java" > sources_test_misc.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_TEST_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\misc_utils;%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_test_misc.txt >> "%logFile%" 2>&1
) else (
    echo ? Using precompiled class files >> "%logFile%"
)
echo I reached just before run tests
:: ========== RUN TESTS ==========
"%JAVA_HOME%\bin\java" --enable-preview -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
    -jar "%JUNIT_CONSOLE_JAR%" ^
    --class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --scan-class-path "%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --reports-dir="%JUNIT_REPORT_DIR%" --details=tree

if not exist "%REPORT_DIR%\%execFile%" (
    echo ? Coverage file not generated >> "%logFile%"
    exit /b 1
)

:: ========== GENERATE REPORT ==========
"%JAVA_HOME%\bin\java" --enable-preview -jar "%JACOCO_CLI_JAR%" report "%REPORT_DIR%\%execFile%" ^
    --classfiles "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" ^
    --classfiles "%OUT_PROD_DIR%\misc_utils" ^
    --sourcefiles "%PROJECT_ROOT%\src\main\java" ^
    --sourcefiles "%PROJECT_ROOT%\misc_utils\src\main\java" ^
    --xml "%REPORT_DIR%\%xmlFile%" ^
    --html "%REPORT_DIR%\%htmlDir%" >> "%logFile%" 2>&1

copy /Y "%REPORT_DIR%\%xmlFile%" "%REPORT_DIR%\jacoco-latest.xml" >nul
copy /Y "%REPORT_DIR%\%execFile%" "%REPORT_DIR%\jacoco-latest.exec" >nul

echo ? XML Report: %xmlFile% >> "%logFile%"
echo ? HTML Report: %htmlDir%\index.html >> "%logFile%"
echo ? Exec File: %execFile% >> "%logFile%"

:: ========== CLEANUP TEMP SOURCE FILE LISTS ==========
del /q sources_main_master.txt sources_main_misc.txt sources_test_master.txt sources_test_misc.txt 2>nul

echo.
type "%logFile%" | findstr /C:"?" /C:"?"
goto :end




:local
echo === Running Locally ===
if not defined JAVA_HOME (
    echo ❌ ERROR: JAVA_HOME is not set
    exit /b 1
)
cd /d %~dp0..
set "PROJECT_ROOT=%CD%"
set "JACOCO_HOME=%PROJECT_ROOT%\tools\jacoco-0.8.13"
REM set "JAVA_HOME=C:\Program Files\Java\jdk-24"
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

:: ========== COMPILE IF NEEDED ==========
set "compileNeeded=false"
if not exist "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" (
    if not exist "%OUT_PROD_DIR%\misc_utils" (
		echo i came in here 
        set "compileNeeded=true"
    )
) else (
   echo Hello compileNeeded is: %compileNeeded%
) 
if "!compileNeeded!"=="true" (
	echo I reached inside true for compileNeeded
    echo ? Compilation triggered >> "%logFile%"
	echo ? Compilation triggered
    rmdir /s /q "%OUT_PROD_DIR%" 2>nul
    rmdir /s /q "%OUT_TEST_DIR%" 2>nul
    mkdir "%OUT_PROD_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_PROD_DIR%\misc_utils"
    mkdir "%OUT_TEST_DIR%\udemy_lpa_javamasterclass"
    mkdir "%OUT_TEST_DIR%\misc_utils"

    echo ? Compiling udemy_lpa_javamasterclass  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\src\main\java\*.java" > sources_main_master.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_main_master.txt >> "%logFile%" 2>&1

    echo ? Compiling misc_utils depends on masterclass >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\misc_utils\src\main\java\*.java" > sources_main_misc.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_PROD_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_main_misc.txt >> "%logFile%" 2>&1

    echo ? Compiling udemy_lpa_javamasterclass TEST classes  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\src\test\java\*.java" > sources_test_master.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_TEST_DIR%\udemy_lpa_javamasterclass" -cp "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_test_master.txt >> "%logFile%" 2>&1

    echo ? Compiling misc_utils TEST classes  >> "%logFile%"
    dir /s /b "%PROJECT_ROOT%\misc_utils\src\test\java\*.java" > sources_test_misc.txt
    "%JAVA_HOME%\bin\javac" --enable-preview --release 24 -encoding UTF-8 -d "%OUT_TEST_DIR%\misc_utils" -cp "%OUT_PROD_DIR%\misc_utils;%OUT_PROD_DIR%\udemy_lpa_javamasterclass" @sources_test_misc.txt >> "%logFile%" 2>&1
) else (
    echo ? Using precompiled class files >> "%logFile%"
)
echo I reached just before run tests
:: ========== RUN TESTS ==========
"%JAVA_HOME%\bin\java" --enable-preview -javaagent:"%JACOCO_AGENT_JAR%"=destfile="%REPORT_DIR%\%execFile%" ^
    -jar "%JUNIT_CONSOLE_JAR%" ^
    --class-path "%OUT_PROD_DIR%\udemy_lpa_javamasterclass;%OUT_PROD_DIR%\misc_utils;%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --scan-class-path "%OUT_TEST_DIR%\udemy_lpa_javamasterclass;%OUT_TEST_DIR%\misc_utils" ^
    --reports-dir="%JUNIT_REPORT_DIR%" --details=tree

if not exist "%REPORT_DIR%\%execFile%" (
    echo ? Coverage file not generated >> "%logFile%"
    exit /b 1
)

:: ========== GENERATE REPORT ==========
"%JAVA_HOME%\bin\java" --enable-preview -jar "%JACOCO_CLI_JAR%" report "%REPORT_DIR%\%execFile%" ^
    --classfiles "%OUT_PROD_DIR%\udemy_lpa_javamasterclass" ^
    --classfiles "%OUT_PROD_DIR%\misc_utils" ^
    --sourcefiles "%PROJECT_ROOT%\src\main\java" ^
    --sourcefiles "%PROJECT_ROOT%\misc_utils\src\main\java" ^
    --xml "%REPORT_DIR%\%xmlFile%" ^
    --html "%REPORT_DIR%\%htmlDir%" >> "%logFile%" 2>&1

copy /Y "%REPORT_DIR%\%xmlFile%" "%REPORT_DIR%\jacoco-latest.xml" >nul
copy /Y "%REPORT_DIR%\%execFile%" "%REPORT_DIR%\jacoco-latest.exec" >nul

echo ? XML Report: %xmlFile% >> "%logFile%"
echo ? HTML Report: %htmlDir%\index.html >> "%logFile%"
echo ? Exec File: %execFile% >> "%logFile%"

:: ========== CLEANUP TEMP SOURCE FILE LISTS ==========
del /q sources_main_master.txt sources_main_misc.txt sources_test_master.txt sources_test_misc.txt 2>nul

echo.
type "%logFile%" | findstr /C:"?" /C:"?"
goto :end

:unsupported
echo Unsupported environment: %executionEnv%
exit /b 1

:end
echo JACOCO Coverage Analysis complete.
endlocal
exit /b 0