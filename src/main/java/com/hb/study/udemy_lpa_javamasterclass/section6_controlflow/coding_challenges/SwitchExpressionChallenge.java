package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class SwitchExpressionChallenge {
    private static final String THE_DAY = "The day ";
    private static final String IS = " is ";
    public static String dayOfTheWeek;

    public static void main(String[] args) {
/*      printDayOfTheWeek(0);
        printDayOfTheWeek(1);
        printDayOfTheWeek(2);
        printDayOfTheWeek(3);
        printDayOfTheWeek(4);
        printDayOfTheWeek(5);
        printDayOfTheWeek(6);
        printDayOfTheWeek(7);*/

        ConsoleStyler.styleOutput(THE_DAY + 0 + IS + printDayOfTheWeek(0));
        ConsoleStyler.styleOutput(THE_DAY + 1 + IS + printDayOfTheWeek(1));
        ConsoleStyler.styleOutput(THE_DAY + 2 + IS + printDayOfTheWeek(2));
        ConsoleStyler.styleOutput(THE_DAY + 3 + IS + printDayOfTheWeek(3));
        ConsoleStyler.styleOutput(THE_DAY + 4 + IS + printDayOfTheWeek(4));
        ConsoleStyler.styleOutput(THE_DAY + 5 + IS + printDayOfTheWeek(5));
        ConsoleStyler.styleOutput(THE_DAY + 6 + IS + printDayOfTheWeek(6));
        ConsoleStyler.styleOutput(THE_DAY + 7 + IS + printDayOfTheWeek(7));

        ConsoleStyler.divider();
        printWeekDay(0);
        printWeekDay(1);
        printWeekDay(2);
        printWeekDay(3);
        printWeekDay(4);
        printWeekDay(5);
        printWeekDay(6);
        printWeekDay(7);

    }

    /*public static void printDayOfTheWeek(int day) {
        //ConsoleStyler.styleOutput("\nInside printDayOfTheWeekMethod");
        dayOfTheWeek = switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };
        ConsoleStyler.styleOutput("The day " + day + " is " + dayOfTheWeek);
    }*/

    public static String printDayOfTheWeek(int day) {
        //ConsoleStyler.styleOutput("\nInside printDayOfTheWeekMethod");
        String dayOfWeek;
        return switch (day) {
            case 0 -> { dayOfWeek = "Sunday"; yield dayOfWeek;}
            case 1 -> { dayOfWeek = "Monday"; yield dayOfWeek;}
            case 2 -> { dayOfWeek = "Tuesday"; yield dayOfWeek;}
            case 3 -> { dayOfWeek = "Wednesday"; yield dayOfWeek;}
            case 4 -> { dayOfWeek = "Thursday"; yield dayOfWeek;}
            case 5 -> { dayOfWeek = "Friday"; yield dayOfWeek;}
            case 6 -> { dayOfWeek = "Saturday"; yield dayOfWeek;}
            default -> "Invalid Day";
        };
    }

    public static void printWeekDay(int day) {
        //ConsoleStyler.styleOutput("Inside printDayOfTheWeekMethod");
        if (day == 0)
            dayOfTheWeek = "Sunday";
        else if (day == 1)
            dayOfTheWeek = "Monday";
        else if (day == 2)
            dayOfTheWeek = "Tuesday";
        else if (day == 3)
            dayOfTheWeek = "Wednesday";
        else if (day == 4)
            dayOfTheWeek = "Thursday";
        else if (day == 5)
            dayOfTheWeek = "Friday";
        else if (day == 6)
            dayOfTheWeek = "Saturday";
        else
            dayOfTheWeek = "Invalid Day";
        ConsoleStyler.styleOutput(THE_DAY + day + IS + dayOfTheWeek);
    }
}
