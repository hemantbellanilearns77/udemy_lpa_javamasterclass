package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise15;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOddRange {

    private static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;
        int start, end;
        demoTestCases();
        do {
             ConsoleStyler.styleOutput("Enter the range of numbers between whom the sum of odd number is required " +
                    "(Example: 1, 100): ");
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc. ), from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");
            if (userInputWithoutBlanks.equalsIgnoreCase("exit")) {
                continue;
            }
            ConsoleStyler.styleOutput("userInput was:" + userInput + ",userInputWithoutBlanks is:" + userInputWithoutBlanks);
            // Extracting the start and end of the range for whom the sum of odd numbers is to be calculated from user input without whitespace characters
            start = Integer.parseInt(userInputWithoutBlanks.substring(0, userInputWithoutBlanks.indexOf(',')));
            end = Integer.parseInt(userInputWithoutBlanks.substring(userInputWithoutBlanks.indexOf(',') + 1));
            ConsoleStyler.styleOutput("Sum of odd numbers between +  " + start + " and " + end + " is: " + sumOdd(start, end));
        } while (!(userInputWithoutBlanks.equalsIgnoreCase("exit")));
        execution.finalizeExecution();
    }

    private static void demoTestCases() {
        ConsoleStyler.startSection("""
                Demonstrating Example test cases for this exercise:
                            sumOdd(1, 100); → should return 2500
                            sumOdd(-1, 100); → should return -1
                            sumOdd(100, 100); → should return 0
                            sumOdd(13, 13); → should return 13 (This set contains one number, 13, and it is odd)
                            sumOdd(100, -100); → should return -1
                            sumOdd(100, 1000); → should return 247500
                """);
        int end;
        int start;
        ArrayList<String> listOfTestCases = new ArrayList<>();
        listOfTestCases.add("1, 100");
        listOfTestCases.add("-1,100");
        listOfTestCases.add("100, 100");
        listOfTestCases.add("13, 13");
        listOfTestCases.add("100, -100");
        listOfTestCases.add("100, 1000");
        for (String nextTestCase : listOfTestCases) {
            ConsoleStyler.styleOutput("Next Test Case is : " + nextTestCase);
            nextTestCase = nextTestCase.replaceAll("\\s+", "");
            // Extracting the start and end of the range for whom the sum of odd numbers is to be calculated from user input without whitespace characters
            start = Integer.parseInt(nextTestCase.substring(0, nextTestCase.indexOf(',')));
            end = Integer.parseInt(nextTestCase.substring(nextTestCase.indexOf(',') + 1));
            ConsoleStyler.styleOutput("Sum of odd numbers between +  " + start + " and " + end + " is: " + sumOdd(start, end));
        }
        ConsoleStyler.endSection("""
                    End of Test cases demonstration
                """);
    }

    public static int sumOdd(int start, int end) {
        int sum = -1;
        if (end >= start && start > 0) {
            sum = 0;
            int loopCounter = start;
            for (; loopCounter <= end; loopCounter++) {
                if (isOdd(loopCounter)) {
                    sum += loopCounter;
                }
            }
        }
        return sum;
    }

    public static boolean isOdd(int number) {
        boolean numberOddStatus = false;
        if (number > 0) {
            numberOddStatus = (number % 2) != 0;
        }
        return numberOddStatus;
    }
}
