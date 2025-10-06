package com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class SwitchExpressionChallenge {
    public static final ExecutionUtil execution = new ExecutionUtil();
    private static final String THE_DAY = "The day ";
    private static final String IS = " is ";
    private static final String SUNDAY = "Sunday";
    private static final String MONDAY = "Monday";
    private static final String TUESDAY = "Tuesday";
    private static final String WEDNESDAY = "Wednesday";
    private static final String THURSDAY = "Thursday";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";
    private static final String INVALID_DAY = "Invalid Day";
    static String dayOfTheWeek;

    public static void main(String[] args) {
        execution.initialize(args);
        printDayOfTheWeek(0);
        printDayOfTheWeek(1);
        printDayOfTheWeek(2);
        printDayOfTheWeek(3);
        printDayOfTheWeek(4);
        printDayOfTheWeek(5);
        printDayOfTheWeek(6);
        printDayOfTheWeek(7);

        ConsoleStyler.styleOutput(THE_DAY + 0 + IS + printDayOfTheWeek(0));
        ConsoleStyler.styleOutput(THE_DAY + 1 + IS + printDayOfTheWeek(1));
        ConsoleStyler.styleOutput(THE_DAY + 2 + IS + printDayOfTheWeek(2));
        ConsoleStyler.styleOutput(THE_DAY + 3 + IS + printDayOfTheWeek(3));
        ConsoleStyler.styleOutput(THE_DAY + 4 + IS + printDayOfTheWeek(4));
        ConsoleStyler.styleOutput(THE_DAY + 5 + IS + printDayOfTheWeek(5));
        ConsoleStyler.styleOutput(THE_DAY + 6 + IS + printDayOfTheWeek(6));
        ConsoleStyler.styleOutput(THE_DAY + 7 + IS + printDayOfTheWeek(7));

        ConsoleStyler.divider();
        alternativePrintDayOfTheWeek(0);
        alternativePrintDayOfTheWeek(1);
        alternativePrintDayOfTheWeek(2);
        alternativePrintDayOfTheWeek(3);
        alternativePrintDayOfTheWeek(4);
        alternativePrintDayOfTheWeek(5);
        alternativePrintDayOfTheWeek(6);
        alternativePrintDayOfTheWeek(7);
        execution.finalizeExecution();
    }

    public static void alternativePrintDayOfTheWeek(int day) {
        ConsoleStyler.styleOutput("\nInside printDayOfTheWeekMethod");
       dayOfTheWeek = switch (day) {
            case 0 -> SUNDAY;
            case 1 -> MONDAY;
            case 2 -> TUESDAY;
            case 3 -> WEDNESDAY;
            case 4 -> THURSDAY;
            case 5 -> FRIDAY;
            case 6 -> SATURDAY;
            default -> INVALID_DAY;
        };
        ConsoleStyler.styleOutput(THE_DAY + day + " is " + dayOfTheWeek);
    }

    public static String printDayOfTheWeek(int day) {
        ConsoleStyler.styleOutput("\nInside printDayOfTheWeekMethod");

        return switch (day) {
            case 0 -> {
                dayOfTheWeek = SUNDAY;
                yield dayOfTheWeek;
            }
            case 1 -> {
                dayOfTheWeek = MONDAY;
                yield dayOfTheWeek;
            }
            case 2 -> {
                dayOfTheWeek = TUESDAY;
                yield dayOfTheWeek;
            }
            case 3 -> {
                dayOfTheWeek = WEDNESDAY;
                yield dayOfTheWeek;
            }
            case 4 -> {
                dayOfTheWeek = THURSDAY;
                yield dayOfTheWeek;
            }
            case 5 -> {
                dayOfTheWeek = FRIDAY;
                yield dayOfTheWeek;
            }
            case 6 -> {
                dayOfTheWeek = SATURDAY;
                yield dayOfTheWeek;
            }
            default -> INVALID_DAY;
        };
    }
}
