package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise18;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

public class EvenDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;
        int sumReceived = 0;

        do {
            System.out.print("Enter a number to find the sum of its even digits: " +
                    "or input 'exit' or 'quit' to quit:  " );
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc.. ) from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");

            if(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")) {
                clearScreen();
                ConsoleStyler.styleOutput("\nExiting the input screen .... " +
                        "thanks for your attempts and inputs.... ");
            } else {
                ConsoleStyler.styleOutput("**************************************************************");
                ConsoleStyler.styleOutput("userInput was: " + userInput + ";" +
                        "\namd userInputWithoutBlanks is: " + userInputWithoutBlanks);
                ConsoleStyler.styleOutput("**************************************************************");
                // Checking if user input number is Palindrome or not?
                try{
                    sumReceived = getEvenDigitSum (Integer.parseInt(userInputWithoutBlanks));
                    if(sumReceived != -1) {
                        ConsoleStyler.styleOutput("Sum of the even digits of " + userInputWithoutBlanks +
                                " is: " + sumReceived);
                    } else {
                        ConsoleStyler.styleOutput("You entered a negative integer, which is an invalid input, " +
                                "please try again or or input 'exit' or 'quit' to quit ");
                    }
                } catch(NumberFormatException nfe) {
                    ConsoleStyler.styleOutput("\n**** Unfortunately your input could not parsed as an Integer, please try again or or input 'exit' or 'quit' to quit ****");
                }
            }
        } while(!(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")));
    }
    public static int getEvenDigitSum (int number){
        int sum = -1;
        int numberCopy = number;
        int nextEvenDigit = 0;
        if( !(numberCopy < 0)) {
            sum += 1;
            while(numberCopy != 0) {
             if( ((numberCopy % 10) % 2) == 0) {
                nextEvenDigit = numberCopy % 10;
                sum += nextEvenDigit;
             }
             numberCopy /= 10;
            }
        }
        return sum;

    }
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            ConsoleStyler.styleOutput("Error clearing screen: " + e.getMessage());
        }
    }
}
