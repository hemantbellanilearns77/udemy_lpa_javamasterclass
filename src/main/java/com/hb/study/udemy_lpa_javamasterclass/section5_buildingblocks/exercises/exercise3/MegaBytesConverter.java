package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise3;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MegaBytesConverter {
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        ConsoleStyler.styleOutput("------------------------------------------------------");
        printMegaBytesAndKiloBytes(-1024);
        ConsoleStyler.styleOutput("------------------------------------------------------");
        printMegaBytesAndKiloBytes(0);
        ConsoleStyler.styleOutput("------------------------------------------------------");
        printMegaBytesAndKiloBytes(5000);
        ConsoleStyler.styleOutput("------------------------------------------------------");

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaBytes = 0;
        int remainingKiloBytes = 0;
        if (kiloBytes < 0) {
            ConsoleStyler.styleOutput("Invalid Value" );
        } else {
            megaBytes = kiloBytes / 1024;
            remainingKiloBytes = kiloBytes % 1024;
            ConsoleStyler.styleOutput(kiloBytes + " KB = "
                    + megaBytes + " MB and " + remainingKiloBytes + " KB");

        }
    }
}
