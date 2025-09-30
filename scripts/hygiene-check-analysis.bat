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
REM echo === Running in GitHub Actions ===
	:: === Preserve Original Directory ===
set "originalDir=%CD%"

	if "%rootPath%"=="" set "rootPath=%CD%"
	:: === Navigate to Project Root ===
	cd /d "%~dp0.."
	set "REPO_ROOT=%CD%"
	REM echo REPO_ROOT is !REPO_ROOT!

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
    echo skip_sonar is %skip_sonar%
	:: === Generate Timestamp ===
	for /f %%i in ('powershell -command "Get-Date -Format yyyy-MM-dd--HH-mm-ss"') do set timestamp=%%i

	:: === Log Directory Setup ===
	set "hygieneLogFolder=logs\all-hygiene-logs"
	set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.txt"

	if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"
	REM --- Add echo logs here to confirm the values ---
	REM echo skip_checkstyle is %skip_checkstyle%
	REM echo skip_pmd is %skip_pmd%
	REM echo skip_jacoco is %skip_jacoco%
	REM echo skip_sonar is %skip_sonar%
	if "%skip_sonar%"=="false" (
		REM echo SONAR_SCANNER_BIN as received from environment is %SONAR_SCANNER_BIN%
	)
	REM ------------------------------------------------

	:: === Begin Composite Logging ===
	echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	REM echo 🔗 Starting full hygiene sweep at %timestamp% 
	REM echo ---------------------------------------------------

	:: === Step 1: Checkstyle ===
	if "%skip_checkstyle%"=="false" (
		echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
		REM echo 🚀 Step 1: Running Checkstyle...
		call scripts\checkstyle.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
		REM echo ✅ Checkstyle scan completed. 
	) else (
		echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
		REM echo ⏭️ Skipping Checkstyle...
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	REM echo ---------------------------------------------------

	:: === Step 2: PMD ===
	if "%skip_pmd%"=="false" (
		echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
		REM echo 🚀 Step 2: Running PMD... 
		call scripts\pmd.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ PMD scan completed. >> "%hygieneLogPath%"
		REM echo ✅ PMD scan completed. 
	) else (
		echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
		REM echo ⏭️ Skipping PMD...
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	REM echo --------------------------------------------------- 

	:: === Step 3: JaCoCo ===
	if "%skip_sonar%"=="false" (
		if "%skip_jacoco%"=="false" (
			echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
			REM echo 🚀 Step 3: Running JaCoCo... 
			call scripts\jacoco-coverage-analysis.bat githubactions >> "%hygieneLogPath%" 2>&1
			echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
			REM echo ✅ JaCoCo analysis completed. 
		) else (
			echo ⏭️ Skipping JaCoCo... because skip_jacoco was true  >> "%hygieneLogPath%"
			REM echo ⏭️ Skipping JaCoCo... because skip_jacoco was true  
		)
	)	else (
		echo ⏭️ Skipping JaCoCo... because skip_sonar was true >> "%hygieneLogPath%"
		REM echo ⏭️ Skipping JaCoCo... because skip_sonar was true 
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	REM echo ---------------------------------------------------
	:: === Step 4: SonarCloud ===
	if "%skip_sonar%"=="false" (
		echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
		REM echo 🚀 Step 4: Running SonarCloud scan... 
		call scripts\sonar-scan.bat githubactions >> "%hygieneLogPath%" 2>&1
		echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
		REM echo ✅ SonarCloud scan completed.
	) else (
		echo ⏭️ Skipping SonarCloud scan... because skip_sonar was true  >> "%hygieneLogPath%"
		echo ⏭️ Skipping SonarCloud scan... because skip_sonar was true
	)
	echo --------------------------------------------------- >> "%hygieneLogPath%"
	REM echo --------------------------------------------------- 
	:: === Wrap-Up ===
	echo 🎯 All hygiene steps complete. | tee -a "%hygieneLogPath%"
	REM echo 📄 Composite log available at: %hygieneLogPath%



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

echo skip_checkstyle is %skip_checkstyle%
echo skip_pmd is %skip_pmd%
echo skip_jacoco is %skip_jacoco%
echo skip_sonar is %skip_sonar%
:: === Log Directory Setup ===
set "hygieneLogFolder=logs\all-hygiene-logs"
set "hygieneLogPath=%hygieneLogFolder%\all-hygiene-%timestamp%.txt"
if not exist "%hygieneLogFolder%" mkdir "%hygieneLogFolder%"

echo 🔗 Starting full hygiene sweep at %timestamp% >> "%hygieneLogPath%"
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 1: Checkstyle ===
if "%skip_checkstyle%"=="false" (
    echo 🚀 Step 1: Running Checkstyle... >> "%hygieneLogPath%"
	echo 🚀 Step 1: Running Checkstyle... 
    call scripts\checkstyle.bat local >> "%hygieneLogPath%" 2>&1
    echo ✅ Checkstyle scan completed. >> "%hygieneLogPath%"
	echo ✅ Checkstyle scan completed.
) else (
    echo ⏭️ Skipping Checkstyle... >> "%hygieneLogPath%"
	echo ⏭️ Skipping Checkstyle...
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 2: PMD ===
if "%skip_pmd%"=="false" (
    echo 🚀 Step 2: Running PMD... >> "%hygieneLogPath%"
	echo 🚀 Step 2: Running PMD...
    call scripts\pmd.bat local >> "%hygieneLogPath%" 2>&1
    echo ✅ PMD scan completed. >> "%hygieneLogPath%"
	echo ✅ PMD scan completed.
) else (
    echo ⏭️ Skipping PMD... >> "%hygieneLogPath%"
	echo ⏭️ Skipping PMD...
)
echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 3: JaCoCo ===
if "%skip_jacoco%"=="false" (
	echo 🚀 Step 3: Running JaCoCo... >> "%hygieneLogPath%"
	echo 🚀 Step 3: Running JaCoCo...
	call scripts\jacoco-coverage-analysis.bat local >> "%hygieneLogPath%" 2>&1
	echo ✅ JaCoCo analysis completed. >> "%hygieneLogPath%"
	echo ✅ JaCoCo analysis completed.
) else (
	echo ⏭️ Skipping JaCoCo... >> "%hygieneLogPath%"
	echo ⏭️ Skipping JaCoCo...
)


echo --------------------------------------------------- >> "%hygieneLogPath%"

:: === Step 4: SonarCloud ===
if "%skip_sonar%"=="false" (
    echo 🚀 Step 4: Running SonarCloud scan... >> "%hygieneLogPath%"
	echo 🚀 Step 4: Running SonarCloud scan...
    call scripts\sonar-scan.bat local>> "%hygieneLogPath%" 2>&1
    echo ✅ SonarCloud scan completed. >> "%hygieneLogPath%"
	echo ✅ SonarCloud scan completed
) else (
    echo ⏭️ Skipping SonarCloud scan... >> "%hygieneLogPath%"
	echo ⏭️ Skipping SonarCloud scan...
)
echo --------------------------------------------------- >> "%hygieneLogPath%"
echo --------------------------------------------------- 
:: === FINAL SUMMARY (based on previous reports) ===
echo 📊 Generating Hygiene Summary... >> "%hygieneLogPath%"
echo 📊 Generating Hygiene Summary... 
echo --------------------------------------------------- >> "%hygieneLogPath%"
echo --------------------------------------------------- 
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

set "jacocoLatestReportPath=%REPO_ROOT%\reports\jacoco\jacoco-latest.xml"
for /f "usebackq tokens=* delims=" %%i in (`powershell -nologo -noprofile -ExecutionPolicy Bypass -File "scripts\calc-jacoco-local.ps1" -reportPath "%jacocoLatestReportPath%"`) do (
    set "jacocoSummary=%%i"
	echo jacocoSummary is !jacocoSummary!
	rem remove any accidental double percent signs
	rem set "jacocoSummary=%jacocoSummary:%%=%"
	:: Clean up double percent signs from PowerShell
    rem set "jacocoSummary=!jacocoSummary:%%=%!"
    echo [DEBUG] JaCoCo raw: %%i → cleaned: !jacocoSummary!
    goto :done
)

:done


REM :: --- JaCoCo Coverage via PowerShell ---
REM if exist "reports\jacoco\jacoco-latest.xml" (
    REM echo found jacoco-latest.xml report file 
    REM for /f %%i in ('powershell -nologo -noprofile -Command "[xml]$xml = Get-Content 'reports\\jacoco\\jacoco-latest.xml'; $c = $xml.report.counter | Where-Object { $_.type -eq 'LINE' }; if ($c) { $cov = [int]$c.covered; $miss = [int]$c.missed; $t = $cov + $miss; if ($t -ne 0) { '{0:N2}%%' -f (($cov * 100.0) / $t) } else { '0%%'} } else { '	 Jacoco report missing' }" ') do (
        REM set "jacocoTemp=%%i"
    REM )
REM )
REM if defined jacocoTemp (
    REM set "jacocoSummary=%jacocoTemp%"
REM )
REM echo ?? OutsideDo Code Coverage (JaCoCo): %jacocoSummary% or !jacocoSummary!

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
REM echo 🎯 All hygiene steps complete.
exit /b 0