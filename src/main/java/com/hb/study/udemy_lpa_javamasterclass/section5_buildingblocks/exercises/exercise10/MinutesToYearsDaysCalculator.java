package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise10;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MinutesToYearsDaysCalculator {
        public static void main(String[] args) {
        //
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays(long minutes) {
        if(minutes < 0) {
            ConsoleStyler.styleOutput("Invalid Value");
            return;
        }

        long years = minutes / (60*24*365);
        long remainingMinutes = minutes % (60*24*365);
        long days = remainingMinutes / (60*24);

        ConsoleStyler.styleOutput(minutes + " min = " + years + " y and " + days +" d " );
    }
}
