package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise5;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class LeapYear {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        String emptyString = "";
        ConsoleStyler.styleOutput(isLeapYear(1924) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(-1600) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(1600) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(2017) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(2000) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(1900) + emptyString);
        ConsoleStyler.styleOutput(isLeapYear(-1200) + emptyString);
        execution.finalizeExecution();
    }

    public static boolean isLeapYear(int year) {
        boolean leapYearStatus = false;
        if (year >= 1 && year <= 9999) {
            if ((year % 4) == 0) {
                leapYearStatus = true;
                if (year % 100 == 0) {
                    leapYearStatus = year % 400 == 0;
                }
            }
        }
        return leapYearStatus;
    }
}
