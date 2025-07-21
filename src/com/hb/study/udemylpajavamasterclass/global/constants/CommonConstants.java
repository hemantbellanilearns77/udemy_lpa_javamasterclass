package com.hb.study.udemylpajavamasterclass.global.constants;

import java.util.Random;

public class CommonConstants {
    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String ITALIC = "\u001B[3m"; // ANSI code for italics

    // Text colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Background colors
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String MAGENTA_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";
    // Header & Separators
    public static final String HEADER = "\n" + "📘".repeat(3) + " JAVA EXERCISE SESSION " + "📘".repeat(3);
    public static final String SECTION_SEPARATOR = "\n" + "_".repeat(126);
    public static final String DOTTED_LINE = "·".repeat(126);
    public static final String ASTERISKSEPERATORLINESTRFULL =
            "*".repeat(126);

    public static final String ASTERISKSEPERATORLINESTRHALF =
            "*".repeat(126 / 2);
    public static final String INDENT = "\t\t\t"; // adjustable for your taste
    public static final String EXECUTIONSETUPSSTR =
            "⚙️ ".repeat(9) + "🔧 EXECUTION SETUP & BENCHMARK INITIALIZED; OUTPUT BEGINS BELOW 🔧" + " ⚙️".repeat(9);

    public static final String EXECUTIONENDEDSTR =
           "⚙️ ".repeat(16) + "✅ EXECUTION ENDED ✅" + " ⚙️".repeat(16);

    // Benchmark Constants
    public static final String BENCHMARKSECTIONHEADER =
            "*".repeat(45) + " 📊 BENCHMARK INFO 📊 " + "*".repeat(45);
    public static final String BENCHMARKINSUMMARYSTR =
            "📊 " + UNDERLINE + "BENCHMARK SUMMARY" + RESET + " of the above execution:\n";
    public static final String BENCHMARKINGDETAILSSTR =
            "📊 " + UNDERLINE + "BENCHMARK DETAILS" + RESET + " of the above execution:\n";

    public static final String BENCHMARKINSUMMARYDAYSSTR =
            "%s 🕒 Days: %s day(s)%n";
    public static final String BENCHMARKINSUMMARYHOURSSSTR =
            "%s 🕒 Hours: %s hour(s)%n";
    public static final String BENCHMARKINSUMMARYMINUTESSSTR =
            "%s 🕒 Minutes: %s minute(s)%n";
    public static final String BENCHMARKINSUMMARYSECONDSSTR =
            "%s 🕒 Seconds: %s second(s)%n";
    public static final String BENCHMARKINSUMMARYMILLISSSTR =
            "%s 🕒 Milliseconds: %s millisecond(s)%n";
    public static final String BENCHMARKINSUMMARYNANOSSSTR =
            "%s 🕒 Nanoseconds: %s nanosecond(s)%n";

    // Demo Limits
    public static final int MAX_ITERATION_COUNT = new Random().nextInt(1, (3969 + 1));
    public static final int ARRAY_LENGTH = 15;
    public static final int COLLECTION_DEMO_SIZE = 20;
    public static final int STRING_SAMPLE_LIMIT = 5;

    // Sample Date Format Patterns
    public static final String DATE_PATTERN_STANDARD = "dd/MM/yyyy";
    public static final String DATE_PATTERN_VERBOSE = "EEEE, MMMM dd, yyyy";

    // Misc Labels
    public static final String DB_DEMO_LABEL = "💾 Database Interaction Demo";
    public static final String SWING_UI_LABEL = "🎨 Swing UI Showcase";
    public static final String JFX_DEMO_LABEL = "🖼️ JavaFX Feature Preview";

    public static final String[] FIRST_NAMES = {
            "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
    };

    public static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    private CommonConstants() {} // Prevent instantiation




}
