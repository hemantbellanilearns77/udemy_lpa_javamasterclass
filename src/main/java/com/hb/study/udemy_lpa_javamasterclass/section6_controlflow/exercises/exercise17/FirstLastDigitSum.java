package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise17;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


import java.util.Scanner;

public class FirstLastDigitSum {
        public static void main(String[] ignoredUnusedArgs) {
        //
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;

        do {
            System.out.print("Enter a number to find the sum of its first and last digits: " +
                    "or input 'exit' or 'quit' to quit:  " );
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc.. ) from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");

            if(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")) {
                ConsoleStyler.styleOutput("\nExiting the input screen .... " +
                        "thanks for your attempts and inputs.... ");
            } else {
                ConsoleStyler.styleOutput("userInput was: " + userInput + ";" +
                        "\namd userInputWithoutBlanks is: " + userInputWithoutBlanks);
                // Checking if user input number is Palindrome or not?
                try{
                    ConsoleStyler.styleOutput("Sum of first and last digits of " + userInputWithoutBlanks +
                            "is: " + sumFirstAndLastDigit (Integer.parseInt(userInputWithoutBlanks)));
                } catch(NumberFormatException nfe) {
                    ConsoleStyler.styleOutput("Unfortunately your input could not parsed as an Integer, please try again or or input 'exit' or 'quit' to quit ");
                }
            }
        } while(!(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")));

    }

    public static int sumFirstAndLastDigit(int number) {
        int sum = -1;
        int numberCopy = number;
        int firstDigit = 0;
        int lastDigit = numberCopy % 10;
        if( !(number < 0)) {
            while(numberCopy != 0) {
                firstDigit = numberCopy % 10;
                numberCopy /= 10;
            }
            sum = firstDigit + lastDigit;
        }
        return sum;
    }

}
