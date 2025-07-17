package com.hb.study.udemylpajavamasterclass.global.constants;

import java.util.Random;

public class CommonConstants {
    // Header & Separators
    public static final String HEADER = "\n" + "📘".repeat(3) + " JAVA EXERCISE SESSION " + "📘".repeat(3);
    public static final String SECTION_SEPARATOR = "\n" + "-".repeat(126);
    public static final String DOTTED_LINE = "·".repeat(126);
    public static final String INDENT = "\t\t\t"; // adjustable for your taste
    public static final String EXECUTIONSETUPSSTR =
            "⚙️ ".repeat(9) + "🔧 EXECUTION SETUP & BENCHMARK INITIALIZED; OUTPUT BEGINS BELOW 🔧" + "⚙️ ".repeat(9);

    public static final String EXECUTIONENDEDSTR =
           "⚙️ ".repeat(16) + " ✅ EXECUTION ENDED ✅ " + "⚙️ ".repeat(16);

    public static final String BENCHMARKSECTIONHEADER =
            "*".repeat(45) + " 📊 BENCHMARK INFO 📊 " + "*".repeat(45);

    public static final String BENCHMARKINSUMMARYSTR =
            INDENT + "📊 BENCHMARK SUMMARY of the above execution:\n";

    public static final String BENCHMARKINGDETAILSSTR =
            INDENT + "📊 BENCHMARK DETAILS of the above execution:\n";

    public static final String ASTERISKSEPERATORLINESTRFULL =
            "*".repeat(126);

    public static final String ASTERISKSEPERATORLINESTRHALF =
            "*".repeat(126 / 2);

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
