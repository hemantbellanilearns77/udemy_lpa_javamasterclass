package com.hb.study.udemy_lpa_javamasterclass.global.constants;

/**
 * created by : heman on 09-08-2025, 07:35 am, in the "run-pmd.bat" project
 **/
public class ExecutionConstants {
    public static final String EXECUTIONSETUPSSTR =
            "⚙️ ".repeat(9) + "🔧  EXECUTION BEGINNING & BENCHMARK INITIALIZED 🔧" + " ⚙️".repeat(9);

    public static final String EXECUTIONENDEDSTR =
            "⚙️ ".repeat(16) + "✅ EXECUTION ENDED ✅" + " ⚙️".repeat(16);

    // Benchmark Constants
    public static final String BENCHMARKSECTIONHEADER =
            "*".repeat(45) + " 📊 BENCHMARK INFO 📊 " + "*".repeat(45);
    public static final String BENCHMARKINSUMMARYSTR =
            "📊 " + CommonConstants.UNDERLINE + "BENCHMARK SUMMARY" + CommonConstants.RESET + " of the above execution:\n";
    public static final String BENCHMARKINGDETAILSSTR =
            "📊 " + CommonConstants.UNDERLINE + "BENCHMARK DETAILS" + CommonConstants.RESET + " of the above execution:\n";

    public static final String BENCHMARKINSUMMARYDAYSSTR =
            CommonConstants.INDENT + " 🕒 Days: %s day(s)%n";
    public static final String BENCHMARKINSUMMARYHOURSSSTR =
            CommonConstants.INDENT + " 🕒 Hours: %s hour(s)%n";
    public static final String BENCHMARKINSUMMARYMINUTESSSTR =
            CommonConstants.INDENT + " 🕒 Minutes: %s minute(s)%n";
    public static final String BENCHMARKINSUMMARYSECONDSSTR =
            CommonConstants.INDENT + " 🕒 Seconds: %s second(s)%n";
    public static final String BENCHMARKINSUMMARYMILLISSSTR =
            CommonConstants.INDENT + " 🕒 Milliseconds: %s millisecond(s)%n";
    public static final String BENCHMARKINSUMMARYNANOSSSTR =
            CommonConstants.INDENT + " 🕒 Nanoseconds: %s nanosecond(s)%n";

    private ExecutionConstants(){

    }

}
