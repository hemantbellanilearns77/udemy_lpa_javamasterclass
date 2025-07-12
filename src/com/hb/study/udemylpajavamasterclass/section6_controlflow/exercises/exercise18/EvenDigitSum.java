package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise18;

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
                System.out.println("\nExiting the input screen .... " +
                        "thanks for your attempts and inputs.... ");
            } else {
                System.out.println("**************************************************************");
                System.out.println("userInput was: " + userInput + ";" +
                        "\namd userInputWithoutBlanks is: " + userInputWithoutBlanks);
                System.out.println("**************************************************************");
                // Checking if user input number is Palindrome or not?
                try{
                    sumReceived = getEvenDigitSum (Integer.parseInt(userInputWithoutBlanks));
                    if(sumReceived != -1) {
                        System.out.println("Sum of the even digits of " + userInputWithoutBlanks +
                                " is: " + sumReceived);
                    } else {
                        System.out.println("You entered a negative integer, which is an invalid input, " +
                                "please try again or or input 'exit' or 'quit' to quit ");
                    }
                } catch(NumberFormatException nfe) {
                    System.out.println("\n**** Unfortunately your input could not parsed as an Integer, please try again or or input 'exit' or 'quit' to quit ****");
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
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }
}
