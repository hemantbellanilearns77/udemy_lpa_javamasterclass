package com.hb.study.udemylpajavamasterclass.section6_controlflow.demostubs;

import java.util.Calendar;
import java.util.Scanner;

public class ConsoleAndScannerPractice {
    public static void main(String[] args) {

        int currentYer = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Current Year is: " + currentYer);
        try {
            System.out.println(getInputFromConsole(currentYer));
        } catch(NullPointerException npe) {
            System.out.println("Inside catch.... ");
            System.out.println(getInputFromScanner(currentYer));
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
