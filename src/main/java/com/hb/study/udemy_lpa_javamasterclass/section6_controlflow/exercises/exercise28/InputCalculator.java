package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise28;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.Scanner;

public class InputCalculator {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        inputThenPrintSumAndAverage();
        execution.finalizeExecution();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        String nextInput;
        int nextNum;
        int sum = 0;
        long roundedAverage = 0;
        double actualAverage = 0.0;
        int numberCount = 0;
        boolean breakOut = false;
        do {
            ConsoleStyler.styleOutput("Please enter the next number or type 'exit' to quit: ");
            nextInput = scanner.nextLine();
            if (nextInput.equalsIgnoreCase("exit")) {
                breakOut = true;
            } else {
                try {
                    nextNum = Integer.parseInt(nextInput);
                    sum += nextNum;
                    numberCount++;
                    actualAverage = (double) sum / numberCount;
                    roundedAverage = Math.round(actualAverage);

                } catch (NumberFormatException _) {
                    ConsoleStyler.styleOutput("Actual average is: " + actualAverage);
                    ConsoleStyler.styleOutput("SUM = " + sum + " AVG = " + roundedAverage);
                    breakOut = true;
                }
            }
        } while (!breakOut);
    }
}
