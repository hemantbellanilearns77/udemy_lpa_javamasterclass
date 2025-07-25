@echo off
echo ===================================================
echo 🐾 PMD Static Analysis — Text + XML Reports
echo ===================================================

:: === Preserve Original Directory ===
set "originalDir=%CD%"

:: === Navigate to Project Root ===
cd /d D:\GitHubRepos\udemy_lpa_javamasterclass

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

:: === CONFIGURATION ===
set "PMD_BIN=D:\Tools\pmd-dist-7.15.0-bin\pmd-bin-7.15.0\bin\pmd.bat"
set "RULESET=config\pmd\pmd-ruleset.xml"
set "REPORT_DIR=reports\pmd"
set "LOG_DIR=logs\pmd-logs"
set "REPORT_TXT=%REPORT_DIR%\pmd-%timestamp%-report.txt"
set "REPORT_XML=%REPORT_DIR%\pmd-%timestamp%-report.xml"
set "LOG_PATH=%LOG_DIR%\pmd-log-%timestamp%.txt"

:: === DISCOVER MODULES ===
set "SOURCE_DIRS="
set "MODULE_PATHS=misc_utils\src\main\java src\main\java"

echo 🔎 Checking valid source modules...
for %%P in (%MODULE_PATHS%) do (
    if exist "%%P" (
        echo 🟢 Found: %%P
        if not defined SOURCE_DIRS (
            set "SOURCE_DIRS=%%P"
        ) else (
            set "SOURCE_DIRS=!SOURCE_DIRS!,%%P"
        )
    ) else (
        echo ⚪ Skipped (not found): %%P
    )
)

:: === VALIDATION ===
if not exist "%RULESET%" (
    echo ❌ PMD ruleset not found at: %RULESET%
    cd /d "%originalDir%"
    pause
    exit /b 1
)

if not defined SOURCE_DIRS (
    echo ❌ No valid source directories found. Aborting PMD scan.
    cd /d "%originalDir%"
    pause
    exit /b 1
)

if not exist "%REPORT_DIR%" mkdir "%REPORT_DIR%"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: === EXECUTION ===
echo 🔍 Running PMD Text Analysis...
call "%PMD_BIN%" check ^
  -d "%SOURCE_DIRS%" ^
  -R "%RULESET%" ^
  --no-progress ^
  -f text ^
  -r "%REPORT_TXT%" ^
  > "%LOG_PATH%" 2>&1

echo ✅ Text report saved: %REPORT_TXT%

echo 📄 Generating PMD XML Report...
call "%PMD_BIN%" check ^
  -d "%SOURCE_DIRS%" ^
  -R "%RULESET%" ^
  --no-progress ^
  -f xml ^
  -r "%REPORT_XML%" ^
  >> "%LOG_PATH%" 2>&1

echo 📦 XML report for SonarCloud saved: %REPORT_XML%
echo 📝 Execution log saved to: %LOG_PATH%

:: === Restore Original Directory ===
cd /d "%originalDir%"
pause