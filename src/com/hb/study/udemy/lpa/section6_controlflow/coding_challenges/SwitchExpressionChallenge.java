package com.hb.study.udemy.lpa.section6_controlflow.coding_challenges;

public class SwitchExpressionChallenge {
    public static String dayOfTheWeek;

    public static void main(String[] args) {
/*        printDayOfTheWeek(0);
        printDayOfTheWeek(1);
        printDayOfTheWeek(2);
        printDayOfTheWeek(3);
        printDayOfTheWeek(4);
        printDayOfTheWeek(5);
        printDayOfTheWeek(6);
        printDayOfTheWeek(7);*/

        System.out.println("The day " + 0 + " is " + printDayOfTheWeek(0));
        System.out.println("The day " + 1 + " is " + printDayOfTheWeek(1));
        System.out.println("The day " + 2 + " is " + printDayOfTheWeek(2));
        System.out.println("The day " + 3 + " is " + printDayOfTheWeek(3));
        System.out.println("The day " + 4 + " is " + printDayOfTheWeek(4));
        System.out.println("The day " + 5 + " is " + printDayOfTheWeek(5));
        System.out.println("The day " + 6 + " is " + printDayOfTheWeek(6));
        System.out.println("The day " + 7 + " is " + printDayOfTheWeek(7));

        System.out.println("--------------------------------------------------");
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
        //System.out.println("\nInside printDayOfTheWeekMethod");
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
        System.out.println("The day " + day + " is " + dayOfTheWeek);
    }*/

    public static String printDayOfTheWeek(int day) {
        //System.out.println("\nInside printDayOfTheWeekMethod");
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
        //System.out.println("Inside printDayOfTheWeekMethod");
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
        System.out.println("The day " + day + " is " + dayOfTheWeek);
    }
}
