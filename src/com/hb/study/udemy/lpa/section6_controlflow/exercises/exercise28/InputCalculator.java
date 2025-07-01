package com.hb.study.udemy.lpa.section6_controlflow.exercises.exercise28;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        String nextInput = "";
        int nextNum = 0;
        int sum = 0;
        long roundedAverage = 0;
        double actualAverage = 0.0;
        int numberCount = 0;
        while(true) {
            //System.out.println("Please enter the next number or any other character to quit: ");
            nextInput = scanner.nextLine();
            try {
                nextNum = Integer.parseInt(nextInput);
                sum += nextNum;
                numberCount++;
                actualAverage = (double) sum/numberCount;
                roundedAverage = (long) Math.round(actualAverage);

            } catch (NumberFormatException nfe) {
                //System.out.println("Actual average is: " + actualAverage);
                System.out.println("SUM = " + sum + " AVG = " + roundedAverage);
                break;
            }
        }
    }
}
