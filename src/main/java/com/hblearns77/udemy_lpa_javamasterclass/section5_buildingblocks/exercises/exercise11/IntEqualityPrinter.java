package com.hblearns77.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise11;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class IntEqualityPrinter {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleOutput("printEqual(1, 1, 1) : ");  printEqual(1, 1, 1);
        ConsoleStyler.styleOutput("printEqual(1, 1, 2) : ");  printEqual(1, 1, 2);
        ConsoleStyler.styleOutput("printEqual(-1, -1, -1) : ");  printEqual(-1, -1, -1);
        ConsoleStyler.styleOutput("printEqual(1, 2, 3) : ");  printEqual(1, 2,3);
        execution.finalizeExecution();
    }

    public static void printEqual(int first, int second, int third) {
        if( (first < 0 ) || (second < 0) || ( third < 0 ) ) {
            ConsoleStyler.styleOutput("Invalid Value");
        } else if( (first == second ) && (second == third)) {
            ConsoleStyler.styleOutput("All numbers are equal");
        } else {
            if( (first != second ) && ( first != third ) && ( second != third) ) {
                ConsoleStyler.styleOutput("All numbers are different");
            } else {
                ConsoleStyler.styleOutput("Neither all are equal or different");
            }
        }
    }
}
