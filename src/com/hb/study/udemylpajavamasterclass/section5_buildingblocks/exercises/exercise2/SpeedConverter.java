package com.hb.study.udemylpajavamasterclass.section5_buildingblocks.exercises.exercise2;

public class SpeedConverter {
    public static void main(String[] args) {
        double testValueKilometersPerHour = 1.5;
        printConversion(testValueKilometersPerHour);
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
                System.out.println(kilometersPerHour + " km/h = "
                        + toMilesPerHour(kilometersPerHour) + " mi/h");
                return;
        }
        System.out.println("Invalid Value");
    }
}
