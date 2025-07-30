package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise28;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] ignoredArgs) {
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
            System.out.println("Please enter the next number or type 'exit' to quit: ");
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
                //System.out.println("Actual average is: " + actualAverage);
                System.out.println("SUM = " + sum + " AVG = " + roundedAverage);
                break;
            }
        }
    }
}
