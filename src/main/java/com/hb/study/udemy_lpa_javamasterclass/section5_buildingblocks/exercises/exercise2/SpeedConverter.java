package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise2;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class SpeedConverter {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        double testValueKilometersPerHour = 1.5;
        printConversion(testValueKilometersPerHour);
        execution.finalizeExecution();
    }
    public static long toMilesPerHour(double kilometersPerHour) {
        long roundedMilesPerHour = -1;
        if(kilometersPerHour >= 0) {
            roundedMilesPerHour = Math.round(((1/1.609) * kilometersPerHour));
        }
        return roundedMilesPerHour;
    }
    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour >= 0) {
                ConsoleStyler.styleOutput(kilometersPerHour + " km/h = "
                        + toMilesPerHour(kilometersPerHour) + " mi/h");
                return;
        }
        ConsoleStyler.styleOutput("Invalid Value");
    }
}
