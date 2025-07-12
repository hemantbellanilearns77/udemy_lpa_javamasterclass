package com.hb.study.udemylpajavamasterclass.global.constants;

import java.util.Random;

public class CommonConstants {
    public static final String PROGRAMOUTPUTBEGINSSTR = "\n" + "*".repeat(54) + " Beginning of Program Execution ond Output " + "*".repeat(54) + "\n";
    public static final String PROGRAMOUTPUTENDSSTR = "\n" + "*".repeat(54) + " End of Program Execution and Output " + "*".repeat(54) + "\n";
    public static final String EXECUTIONSTATSINTROSTR = "The stats for \"duration\" of this program's execution are as below:\n";
    public static final String ASTERISKSEPERATORLINESTR = "*".repeat(144) + "\n";
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
