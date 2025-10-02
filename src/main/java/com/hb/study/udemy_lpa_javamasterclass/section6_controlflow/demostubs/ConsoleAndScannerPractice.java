package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.demostubs;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import java.util.Calendar;
import java.util.Scanner;

public class ConsoleAndScannerPractice {
        public static void main(String[] args) {
        //

        int currentYer = Calendar.getInstance().get(Calendar.YEAR);
        ConsoleStyler.styleOutput("Current Year is: " + currentYer);
        try {
            ConsoleStyler.styleOutput(getInputFromConsole(currentYer));
        } catch(NullPointerException _) {
            ConsoleStyler.styleOutput("Inside catch.... ");
            ConsoleStyler.styleOutput(getInputFromScanner(currentYer));
        }
    }


    public static String getInputFromConsole(int currentYear) {

        String userInputYear = System.console().readLine();

        return "Your Age is: " + (currentYear - Integer.parseInt(userInputYear));
    }

    public static String getInputFromScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in);
        String userInputYear = scanner.nextLine();
        return "Your Age is: " + (currentYear - Integer.parseInt(userInputYear));
    }
}
