package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class SecondsAndMinutesChallenge {
    private static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);

        ConsoleStyler.styleOutput(getDurationString(-3945));  // This is the first test case
        ConsoleStyler.styleOutput(getDurationString(-65, 45));  // This is the second test case
        ConsoleStyler.styleOutput(getDurationString(65, 145));
        ConsoleStyler.styleOutput(getDurationString(65, 45));
        ConsoleStyler.styleOutput(getDurationString(3945));
        execution.finalizeExecution();
    }

    public static String getDurationString(int seconds) {

        if (seconds < 0) {
            return "Invalid data for seconds(" + seconds
                    + "), must be a positive integer value";
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }

    public static String getDurationString(int minutes, int seconds) {

        if (minutes < 0) {
            return "Invalid data for minutes(" + minutes
                    + "), must be a positive integer value";
        }

        if (seconds < 0 || seconds > 59) {
            return "Invalid data for seconds(" + seconds
                    + "), must be between 0 and 59";
        }

        int hours = minutes / 60;

        int remainingMinutes = minutes % 60;

        return hours + "h " + remainingMinutes + "m " + seconds + "s";
    }
}
