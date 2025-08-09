package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise11;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class IntEqualityPrinter {
    public static void main(String[] args) {
          /*
        *   printEqual(1, 1, 1); should print text All numbers are equal

            printEqual(1, 1, 2); should print text Neither all are equal or different

            printEqual(-1, -1, -1); should print text Invalid Value

            printEqual(1, 2, 3); should print text All numbers are different
        * */
        ConsoleStyler.styleOutput("printEqual(1, 1, 1) : ");  printEqual(1, 1, 1);
        ConsoleStyler.styleOutput("printEqual(1, 1, 2) : ");  printEqual(1, 1, 2);
        ConsoleStyler.styleOutput("printEqual(-1, -1, -1) : ");  printEqual(-1, -1, -1);
        ConsoleStyler.styleOutput("printEqual(1, 2, 3) : ");  printEqual(1, 2,3);
    }

    public static void printEqual(int first, int second, int third) {
        if( (first < 0 ) || (second < 0) || ( third < 0 ) ) {
            ConsoleStyler.styleOutput("Invalid Value");
            return;
        } else if( (first == second ) && (second == third)) {
            ConsoleStyler.styleOutput("All numbers are equal");
            return;
        } else {
            if( (first != second ) && ( first != third ) && ( second != third) ) {
                ConsoleStyler.styleOutput("All numbers are different");
                return;
            } else {
                ConsoleStyler.styleOutput("Neither all are equal or different");
                return;
            }
        }
    }
}
