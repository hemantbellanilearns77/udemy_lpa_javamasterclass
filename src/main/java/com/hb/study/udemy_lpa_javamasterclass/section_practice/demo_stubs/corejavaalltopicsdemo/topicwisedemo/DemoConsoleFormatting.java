package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 21-07-2025, 11:23 am, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoConsoleFormatting {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();

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
    public static void main(String[] ignoredunusedArgs) {
        execution.initialize();

        demoConsoleColorFormatting();

        execution.finalizeExecution();
    }

    //demoFunction
    public static void demoConsoleColorFormatting() {
        // Print foreground colors
        ConsoleStyler.styleOutput("Foreground Colors:");
        for (int i = 0; i < 256; i++) {
            ConsoleStyler.styleOutput( ("\u001B[38;5;%dmColor %3d").formatted(i, i) + RESET );

            if ((i + 1) % 16 == 0) {
                ConsoleStyler.halfDivider(); // New line after every 16 colors
            }
        }

        ConsoleStyler.styleOutput("\nBackground Colors:");
        // Print background colors
        for (int i = 0; i < 256; i++) {
            ConsoleStyler.styleOutput( ("\u001B[48;5;%dmColor %3d").formatted(i, i) + RESET );
            if ((i + 1) % 16 == 0) {
                ConsoleStyler.halfDivider(); // New line after every 16 colors
            }
        }
        ConsoleStyler.styleOutput(BOLD + "This is bold text" + RESET);
        ConsoleStyler.styleOutput(UNDERLINE + "This is underlined text" + RESET);
        ConsoleStyler.styleOutput(ITALIC + "This is italic text" + RESET);
        ConsoleStyler.styleOutput(RED + "This is red text" + RESET);
        ConsoleStyler.styleOutput(GREEN + "This is green text" + RESET);
        ConsoleStyler.styleOutput(YELLOW + "This is yellow text" + RESET);
        ConsoleStyler.styleOutput(BLUE + "This is blue text" + RESET);
        ConsoleStyler.styleOutput(MAGENTA + "This is magenta text" + RESET);
        ConsoleStyler.styleOutput(CYAN + "This is cyan text" + RESET);
        ConsoleStyler.styleOutput(WHITE + "This is white text" + RESET);

        // Demonstrating background colors
        ConsoleStyler.styleOutput(BLACK_BG + WHITE + "This is white text on black background" + RESET);
        ConsoleStyler.styleOutput(RED_BG + BLACK + "This is black text on red background" + RESET);
        ConsoleStyler.styleOutput(GREEN_BG + BLACK + "This is black text on green background" + RESET);
        ConsoleStyler.styleOutput(YELLOW_BG + BLACK + "This is black text on yellow background" + RESET);
        ConsoleStyler.styleOutput(BLUE_BG + WHITE + "This is white text on blue background" + RESET);
        ConsoleStyler.styleOutput(MAGENTA_BG + WHITE + "This is white text on magenta background" + RESET);
        ConsoleStyler.styleOutput(CYAN_BG + BLACK + "This is black text on cyan background" + RESET);
        ConsoleStyler.styleOutput(WHITE_BG + BLACK + "This is black text on white background" + RESET);
    }
}