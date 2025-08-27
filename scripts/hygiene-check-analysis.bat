@echo off
setlocal EnableDelayedExpansion

echo =================================================================================
echo     🧹 All Hygiene Workflow — Checkstyle then PMD then JaCoCo then SonarCloud
echo =================================================================================
set "executionEnv=%~1"
if /i "%executionEnv%"=="githubactions" goto :github
if /i "%executionEnv%"=="local" goto :local
goto :unsupported

:github
echo === Running in GitHub Actions ===
	:: === Preserve Original Directory ===
set "originalDir=%CD%"

	if "%rootPath%"=="" set "rootPath=%CD%"
	:: === Navigate to Project Root ===
	cd /d "%~dp0.."
	set "REPO_ROOT=%CD%"
	echo REPO_ROOT is !REPO_ROOT!

	:: === Parse Skip Flags ===
	set "skip_checkstyle=false"
	set "skip_pmd=false"
	set "skip_jacoco=false"
	set "skip_sonar=false"

	:: Remove the first argument (environment) from the list
	shift

	:: Iterate over remaining arguments to set skip flags
	for %%A in (%*) do (
		if /I "%%~A"=="--skip-checkstyle" set "skip_checkstyle=true"
		if /I "%%~A"=="--skip-pmd" set "skip_pmd=true"
		if /I "%%~A"=="--skip-jacoco" set "skip_jacoco=true"
		if /I "%%~A"=="--skip-sonar" set "skip_sonar=true"
	)

	:: === Generate Timestamp ===
	for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

	:: === Log Directory Setup ===
	set "hygieneLogFolder=logs\all-hygiene-logs"
	set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.txt"

	if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"

	:: === Begin Composite Logging ===
	echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
	echo --------------------------------------------------- >> "%hygieneLogPath%"

	:: === Step 1: Checkstyle ===
	if "%skip_checkstyle%"=="false" (
		echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
		call scripts\checkstyle.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
	) else (
		echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"

	:: === Step 2: PMD ===
	if "%skip_pmd%"=="false" (
		echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
		call scripts\pmd.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ PMD scan completed. >> "%hygieneLogPath%"
	) else (
		echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"

	:: === Step 3: JaCoCo ===
	if "%skip_jacoco%"=="false" (
		echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
		call scripts\jacoco-coverage-analysis.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
	) else (
		echo ⏭️ Skipping JaCoCo... >> "%hygieneLogPath%"
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"

	:: === Step 4: SonarCloud ===
	if "%skip_sonar%"=="false" (
		echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
		call scripts\sonar-scan.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
	) else (
		echo ⏭️ Skipping SonarCloud scan... >> "%hygieneLogPath%"
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	:: === Wrap-Up ===
	echo 🎯 All hygiene steps complete. | tee -a "%hygieneLogPath%"
	echo 📄 Composite log available at: %hygieneLogPath%

	:: === Restore Original Directory ===

cd /d "%originalDir%"
goto :end

:local
echo === Running Locally ===
:: === Preserve Original Directory ===
set "originalDir=%CD%"
:: === Navigate to Project Root ===
cd /d "%~dp0.."
set "REPO_ROOT=%CD%"
echo REPO_ROOT is !REPO_ROOT!

:: === Parse Skip Flags ===
set skip_checkstyle=false
set skip_pmd=false
set skip_jacoco=false
set skip_sonar=false
:: Remove the first argument (environment) from the list
shift


:: Iterate over remaining arguments to set skip flags
for %%A in (%*) do (
	if /I "%%~A"=="--skip-checkstyle" set "skip_checkstyle=true"
	if /I "%%~A"=="--skip-pmd" set "skip_pmd=true"
	if /I "%%~A"=="--skip-jacoco" set "skip_jacoco=true"
	if /I "%%~A"=="--skip-sonar" set "skip_sonar=true"
)

:: === Generate Timestamp ===
for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

:: === Log Directory Setup ===
set "hygieneLogFolder=logs\all-hygiene-logs"
set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.txt"
if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"

echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 1: Checkstyle ===
if "%skip_checkstyle%"=="false" (
    echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
    call scripts\checkstyle.bat local >> "%hygieneLogPath%" 2>&1
    echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
if "%skip_pmd%"=="false" (
    echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
    call scripts\pmd-local.bat local >> "%hygieneLogPath%" 2>&1
    echo ✅ PMD scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 3: JaCoCo ===
if "%skip_jacoco%"=="false" (
    echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
    call scripts\jacoco-coverage-analysis.bat local >> "%hygieneLogPath%" 2>&1
    echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping JaCoCo... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 4: SonarCloud ===
if "%skip_sonar%"=="false" (
    echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
    call scripts\sonar-scan.bat local>> "%hygieneLogPath%" 2>&1
    echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
) else (
    echo ⏭️ Skipping SonarCloud scan... >> "%hygieneLogPath%"
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === FINAL SUMMARY (based on previous reports) ===
echo 📊 Generating Hygiene Summary... >> "%hygieneLogPath%"

setlocal EnableDelayedExpansion
cd /d "%REPO_ROOT%"
echo current directory is %CD%


:: Locate Checkstyle Report
set checkstyleReportPath=
for /f "delims=" %%F in ('dir /b /a:-d /o-d reports\checkstyle\checkstyle-*.xml') do (
    echo found: "%%F"
    set "checkstyleReportPath=reports\checkstyle\%%F"
	echo checkstyleReportPath is: "!checkstyleReportPath!"
    goto :foundCheckstyle
)
:foundCheckstyle


:: Locate PMD Report
set pmdReportPath=
for /f "delims=" %%F in ('dir /b /a:-d /o-d reports\pmd\pmd-*.xml') do (
    set "pmdReportPath=reports\pmd\%%F"
	echo pmdReportPath is: "!pmdReportPath!"
    goto :foundPMD
)
:foundPMD

:: Validating Report findings
echo ?? Validating report paths...
set failed=false

if not exist "!checkstyleReportPath!" (
    echo ? Checkstyle report missing: !checkstyleReportPath!
    set failed=true
)
if not exist "!pmdReportPath!" (
    echo ? PMD report missing: !pmdReportPath!
    set failed=true
)
:: --- Checkstyle Violation Count ---
set /a checkstyleCount=0
for /f %%X in ('findstr /c:"<error " "!checkstyleReportPath!"') do (
    set /a checkstyleCount+=1
)
:: --- PMD Violation Count ---
set /a pmdCount=0
for /f %%X in ('findstr /c:"<violation " "!pmdReportPath!"') do (
    set /a pmdCount+=1
)

:: --- JaCoCo Coverage via PowerShell ---
if exist "reports\jacoco\jacoco-latest.xml" (
    echo found jacoco-latest.xml report file 
    for /f %%i in ('powershell -nologo -noprofile -Command "[xml]$xml = Get-Content 'reports\\jacoco\\jacoco-latest.xml'; $c = $xml.report.counter | Where-Object { $_.type -eq 'INSTRUCTION' }; if ($c) { $cov = [int]$c.covered; $miss = [int]$c.missed; $t = $cov + $miss; if ($t -ne 0) { '{0:N2}%%' -f (($cov * 100.0) / $t) } else { '0%%'} } else { '	 Jacoco report missing' }" ') do (
        set "jacocoTemp=%%i"
    )
)
if defined jacocoTemp (
    set "jacocoSummary=%jacocoTemp%"
)
REM echo ?? OutsideDo Code Coverage (JaCoCo): %jacocoSummary%
REM echo ?? OutsideDo Code Coverage (JaCoCo): !jacocoSummary!

echo ?? Final Summary
echo Checkstyle Violations: !checkstyleCount!
echo PMD Violations:        !pmdCount!
echo Code Coverage - JaCoCo: !jacocoSummary!

:: --- Summary Output ---
echo --------------------------------------------------- >> "%hygieneLogPath%"
echo 🧪 Hygiene Summary — %timestamp% >> "%hygieneLogPath%"
echo Checkstyle Violations: !checkstyleCount! >> "%hygieneLogPath%"
echo PMD Violations:        !pmdCount! >> "%hygieneLogPath%"
echo Code Coverage - JaCoCo: %jacocoSummary%  >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"
endlocal
echo 🎯 All hygiene steps complete. Composite log:
echo %hygieneLogPath%

:: === Restore Original Directory ===
cd /d "%originalDir%"
goto :end


:unsupported
echo Unsupported environment: %executionEnv%
exit /b 1

:end
echo 🎯 All hygiene steps complete.
exit /b 0