package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise3;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MegaBytesConverter {
        public static void main(String[] ignoredUnusedArgs) {
        //
        printMegaBytesAndKiloBytes(2500);
        ConsoleStyler.halfDivider();
        printMegaBytesAndKiloBytes(-1024);
        ConsoleStyler.halfDivider();
        printMegaBytesAndKiloBytes(0);
        ConsoleStyler.halfDivider();
        printMegaBytesAndKiloBytes(5000);
        ConsoleStyler.halfDivider();

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
