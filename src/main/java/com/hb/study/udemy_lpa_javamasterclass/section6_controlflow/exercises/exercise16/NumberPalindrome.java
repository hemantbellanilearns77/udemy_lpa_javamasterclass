package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise16;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.Scanner;

public class NumberPalindrome {

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        ConsoleStyler.styleOutput("Is 10 a palindrome? : " + isPalindrome(10));
        ConsoleStyler.styleOutput("Is 121 a palindrome? : " + isPalindrome(121));
        ConsoleStyler.styleOutput("Is 456 a palindrome? : " + isPalindrome(456));
        ConsoleStyler.styleOutput("Is 12021 a palindrome? : " + isPalindrome(12021));
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;

        do {
            ConsoleStyler.styleOutput("Enter a number to check if its a palindrome or not: " +
                    "(Example: 1 or 121 or 20102 or 20000) or input 'exit' or 'quit' to quit:  ");
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc.. ) from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");
            if (userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")) {
                ConsoleStyler.styleOutput("CommonConstants.NEWLINE\nExiting the input screen .... thanks for your attempts and inputs.... ");
            } else {
                ConsoleStyler.styleOutput("userInput was:" + userInput + ", userInputWithoutBlanks is:" + userInputWithoutBlanks);
                // Checking if user input number is Palindrome or not?
                try {
                    ConsoleStyler.styleOutput("Is " + userInputWithoutBlanks + " a palindrome? : " + isPalindrome(Integer.parseInt(userInputWithoutBlanks)));
                } catch (NumberFormatException numberFormatException) {
                    ConsoleStyler.styleOutput("Unfortunately your input could not parsed as an Integer, please try again or or input 'exit' or 'quit' to quit " + CommonConstants.NEWLINE + numberFormatException.getMessage());
                }
            }
        } while (!(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")));
        execution.finalizeExecution();
    }

    public static boolean isPalindrome(int numToEvaluate) {
        boolean palindromeFound = false;
        //variables initialization
        int reverse = 0;
        int rem;
        int temp = numToEvaluate;

        //loop to find reverse number
        while (temp != 0) {
            rem = temp % 10;
            reverse = reverse * 10 + rem;
            temp /= 10;
        }

        // palindrome if num and reverse are equal
        if (numToEvaluate == reverse) {

            ConsoleStyler.styleOutput(numToEvaluate + " is Palindrome");
            palindromeFound = true;
        } else {
            ConsoleStyler.styleOutput(numToEvaluate + " is not Palindrome");
        }
        return palindromeFound;
    }
}
