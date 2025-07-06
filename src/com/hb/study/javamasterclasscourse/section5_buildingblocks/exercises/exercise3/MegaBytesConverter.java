package com.hb.study.javamasterclasscourse.section5_buildingblocks.exercises.exercise3;

public class MegaBytesConverter {
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        System.out.println("------------------------------------------------------");
        printMegaBytesAndKiloBytes(-1024);
        System.out.println("------------------------------------------------------");
        printMegaBytesAndKiloBytes(0);
        System.out.println("------------------------------------------------------");
        printMegaBytesAndKiloBytes(5000);
        System.out.println("------------------------------------------------------");

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaBytes = 0;
        int remainingKiloBytes = 0;
        if (kiloBytes < 0) {
            System.out.println("Invalid Value" );
        } else {
            megaBytes = kiloBytes / 1024;
            remainingKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = "
                    + megaBytes + " MB and " + remainingKiloBytes + " KB");

        }
    }
}
