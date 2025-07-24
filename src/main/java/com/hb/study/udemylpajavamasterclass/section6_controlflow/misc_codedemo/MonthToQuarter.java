package com.hb.study.udemylpajavamasterclass.section6_controlflow.misc_codedemo;
/*
Responded by Google Gemini for:
write a java program to demonstrate using enhanced switch statement which prints the current quarter of the year when a name of month is supplied as input, also the program should validate the input as a string containing the name of a calendar month only and no numbers or any other characters
Certainly! Below is a Java program that demonstrates the use of the enhanced switch statement to determine the current quarter of the year based on the name of the month provided as input. The program also validates the input to ensure it contains only the name of a calendar month.
*/

import java.util.Scanner;

public class MonthToQuarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a month: ");
        String month = scanner.nextLine().trim();

        // Validate input
        if (!isValidMonth(month)) {
            System.out.println("Invalid input. Please enter a valid month name.");
            return;
        }

        // Determine the quarter using enhanced switch statement
        String quarter = switch (month.toLowerCase()) {
            case "january", "february", "march" -> "Q1";
            case "april", "may", "june" -> "Q2";
            case "july", "august", "september" -> "Q3";
            case "october", "november", "december" -> "Q4";
            default -> "Unknown quarter"; // This case should never be reached due to validation
        };

        System.out.println("The month of " + month + " is in " + quarter + ".");
    }

    // Method to validate if the input is a valid month name
    private static boolean isValidMonth(String month) {
        String[] validMonths = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        for (String validMonth : validMonths) {
            if (validMonth.equalsIgnoreCase(month)) {
                return true;
            }
        }
        return false;
    }
}
/*

        ### Explanation:
        1. **Input Handling**: The program prompts the user to enter the name of a month.
        2. **Validation**: The `isValidMonth` method checks if the input matches any of the valid month names (case-insensitive).
        3. **Enhanced Switch Statement**: The enhanced switch statement is used to determine which quarter the month belongs to. It uses the `toLowerCase()` method to handle case insensitivity.
        4. **Output**: The program prints the corresponding quarter for the given month.

        ### How to Run:
        1. Copy the code into a file named `MonthToQuarter.java`.
        2. Compile the program using `javac MonthToQuarter.java`.
        3. Run the program using `java MonthToQuarter`.
        4. Enter a month name when prompted to see the corresponding quarter.
*/