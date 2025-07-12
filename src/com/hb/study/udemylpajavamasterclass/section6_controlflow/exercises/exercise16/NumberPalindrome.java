package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise16;

import java.util.Scanner;

public class NumberPalindrome {

    public static void main(String[] args) {

        /*System.out.println("Is 10 a palindrome? : " + isPalindrome(10));
        System.out.println("Is 121 a palindrome? : " + isPalindrome(121));
        System.out.println("Is 456 a palindrome? : " + isPalindrome(456));
        System.out.println("Is 12021 a palindrome? : " + isPalindrome(12021));*/
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;

        do {
            System.out.print("Enter a number to check if its a palindrome or not: " +
                    "(Example: 1 or 121 or 20102 or 20000) or input 'exit' or 'quit' to quit:  " );
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc.. ) from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");

            if(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")) {
                    clearScreen();
                    System.out.println("\n\nExiting the input screen .... thanks for your attempts and inputs.... ");

                continue ;
            } else {
                System.out.println("userInput was:" + userInput + ", userInputWithoutBlanks is:" + userInputWithoutBlanks);
                // Checking if user input number is Palindrome or not?
                try{
                    System.out.println("Is " + userInputWithoutBlanks + " a palindrome? : " + isPalindrome(Integer.parseInt(userInputWithoutBlanks)));
                } catch(NumberFormatException nfe) {
                    System.out.println("Unfortunately your input could not parsed as an Integer, please try again or or input 'exit' or 'quit' to quit ");
                    continue;
                }
            }


        } while(!(userInputWithoutBlanks.equalsIgnoreCase("exit") || userInputWithoutBlanks.equalsIgnoreCase("quit")));
    }

    public static boolean isPalindrome(int numToEvaluate){
        boolean palindromeFound = false;
        //variables initialization
        int reverse = 0, rem = 0, temp = numToEvaluate;

        //int lastDigit = temp % 10;
        //loop to find reverse number
        while(temp != 0)
        {
            rem = temp % 10;
            reverse = reverse * 10 + rem;
            temp /= 10;
         };
        int firstDigit = rem;

        // palindrome if num and reverse are equal
        if(numToEvaluate == reverse) {

            //System.out.println(numToEvaluate + " is Palindrome");
            palindromeFound = true;
        }/* else {
            //System.out.println(numToEvaluate + " is not Palindrome");
            palindromeFound = false;
        }*/
        return  palindromeFound ;
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
