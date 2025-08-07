package com.hb.study.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.Random;

/**
 * created by : heman on 21-07-2025, 11:23 am, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoConsoleFormatting {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };
    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
     
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
    public static void main(String[] ignoredArgs) {
        execution.initialize();

        demoConsoleColorFormatting();

        execution.finalizeExecution();
    }

    //demoFunction
    public static void demoConsoleColorFormatting() {
        // Print foreground colors
        System.out.println("Foreground Colors:");
        for (int i = 0; i < 256; i++) {
            System.out.printf("\u001B[38;5;%dmColor %3d  \u001B[0m", i, i);
            if ((i + 1) % 16 == 0) {
                System.out.println(); // New line after every 16 colors
            }
        }

        System.out.println("\nBackground Colors:");
        // Print background colors
        for (int i = 0; i < 256; i++) {
            System.out.printf("\u001B[48;5;%dmColor %3d  \u001B[0m", i, i);
            if ((i + 1) % 16 == 0) {
                System.out.println(); // New line after every 16 colors
            }
        }
        System.out.println(BOLD + "This is bold text" + RESET);
        System.out.println(UNDERLINE + "This is underlined text" + RESET);
        System.out.println(ITALIC + "This is italic text" + RESET);
        System.out.println(RED + "This is red text" + RESET);
        System.out.println(GREEN + "This is green text" + RESET);
        System.out.println(YELLOW + "This is yellow text" + RESET);
        System.out.println(BLUE + "This is blue text" + RESET);
        System.out.println(MAGENTA + "This is magenta text" + RESET);
        System.out.println(CYAN + "This is cyan text" + RESET);
        System.out.println(WHITE + "This is white text" + RESET);

        // Demonstrating background colors
        System.out.println(BLACK_BG + WHITE + "This is white text on black background" + RESET);
        System.out.println(RED_BG + BLACK + "This is black text on red background" + RESET);
        System.out.println(GREEN_BG + BLACK + "This is black text on green background" + RESET);
        System.out.println(YELLOW_BG + BLACK + "This is black text on yellow background" + RESET);
        System.out.println(BLUE_BG + WHITE + "This is white text on blue background" + RESET);
        System.out.println(MAGENTA_BG + WHITE + "This is white text on magenta background" + RESET);
        System.out.println(CYAN_BG + BLACK + "This is black text on cyan background" + RESET);
        System.out.println(WHITE_BG + BLACK + "This is black text on white background" + RESET);
    }
}