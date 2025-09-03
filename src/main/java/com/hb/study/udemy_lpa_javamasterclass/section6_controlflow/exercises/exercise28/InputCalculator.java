package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise28;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] ignoredunusedArgs) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        String nextInput;
        int nextNum;
        int sum = 0;
        long roundedAverage = 0;
        double actualAverage;
        int numberCount = 0;
        while(true) {
            ConsoleStyler.styleOutput("Please enter the next number or type 'exit' to quit: ");
            nextInput = scanner.nextLine();
            // Check if the user wants to exit - did this to fix Sonar blocker
            if (nextInput.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                nextNum = Integer.parseInt(nextInput);
                sum += nextNum;
                numberCount++;
                actualAverage = (double) sum/numberCount;
                roundedAverage = Math.round(actualAverage);

            } catch (NumberFormatException nfe) {
                //ConsoleStyler.styleOutput("Actual average is: " + actualAverage);
                ConsoleStyler.styleOutput("SUM = " + sum + " AVG = " + roundedAverage);
                break;
            }
        }
    }
}
