package com.hb.study.udemylpajavamasterclass.global.constants;

import java.util.Random;

public class CommonConstants {
    public static final String EXECUTIONSETUPSSTR = "*".repeat(54) + " Execution of current code block is set-up and Output is as below " + "*".repeat(54);
    public static final String EXECUTIONENDEDSTR = "*".repeat(54) + " End of Execution and Output " + "*".repeat(54);
    public static final String BENCHMARKSECTIONHEADER = "*".repeat(54) + " BENCHMARK INFO " + "*".repeat(54) ;
    public static final String BENCHMARKINSUMMARYSTR = "📊 BENCHMARK SUMMARY of the above execution:";
    public static final String BENCHMARKINGDETAILSSTR = "📊 BENCHMARK DETAILS of the above execution:";
    public static final String ASTERISKSEPERATORLINESTRFULL = "*".repeat(144);
    public static final String ASTERISKSEPERATORLINESTRHALF = "*".repeat(72);
    public static final String DATEPATTERNDDMMYYYY = "dd/MM/yyyy";
    public static final int MAX_ITERATION_COUNT = new Random().nextInt(1, (3969 + 1));
    public static final String[] FIRST_NAMES = {
            "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
    };

    public static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };


}
