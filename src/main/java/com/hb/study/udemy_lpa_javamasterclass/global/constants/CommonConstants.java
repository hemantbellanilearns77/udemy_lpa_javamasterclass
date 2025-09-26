package com.hb.study.udemy_lpa_javamasterclass.global.constants;

import java.security.SecureRandom;

public class CommonConstants {
    public static final SecureRandom secureRandom = new SecureRandom();
    public static final String  ALPHANUMCHARSALLCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final String ALBPHABETCARSALLUPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String ITALIC = "\u001B[3m"; // ANSI code for italics
    public static final String EMPTYSTRING = "";
    // Header & Separators
    public static final String HEADER = "📘".repeat(3) + " JAVA EXERCISE SESSION " + "📘".repeat(3);
    public static final String SECTION_SEPARATOR = "_".repeat(126);
    public static final String DOTTED_LINE = "·".repeat(126);
    public static final String FULLLINEASTERISKSEPERATOR =
            "*".repeat(126);

    public static final String HALFLINEASTERISKSEPERATOR =
            "*".repeat(126 / 2);
    public static final String INDENT = "\t\t\t"; // adjustable for your taste
    public static final String NEWLINE = System.lineSeparator();


    public static final String INITIALIZATIONS_INFO = "INITIALIZATIONS : " ;

    // Demo Limits
    public static final int MAX_ITERATION_COUNT = secureRandom.nextInt(1, (3969 + 1));
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
    public static final double EPSILON = 1e-9;


    private CommonConstants() {} // Prevent instantiation
}
