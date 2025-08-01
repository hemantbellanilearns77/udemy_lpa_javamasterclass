package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise15;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOddRange {
  // This program has a lot .....
    // Scanner
    // Whitespace removal from String
    // Integer Parsing from String
    // Arraylist traversal using for each loop
    //do while loop with an exit phrase condition
    /*
    Example test cases:
    sumOdd(1, 100); → should return 2500
    sumOdd(-1, 100); → should return -1
    sumOdd(100, 100); → should return 0
    sumOdd(13, 13); → should return 13 (This set contains one number, 13, and it is odd)
    sumOdd(100, -100); → should return -1
    sumOdd(100, 1000); → should return 247500
     */
    public static void main(String[] ignoredArgs) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String userInputWithoutBlanks;
        String delimitedUserInput;
        int start, end;
        /*do {
            System.out.print("Enter the range of numbers between whom the sum of odd number is required " +
                    "(Example: 1, 100): " );
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc. ), from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");
            if(userInputWithoutBlanks.equalsIgnoreCase("exit")) { continue ; }
            System.out.println("userInput was:" + userInput + ",userInputWithoutBlanks is:" + userInputWithoutBlanks);
            // Extracting the start and end of the range for whom the sum of odd numbers is to be calculated from user input without whitespace characters
            start = Integer.parseInt(userInputWithoutBlanks.substring(0,userInputWithoutBlanks.indexOf(',')));
            end = Integer.parseInt(userInputWithoutBlanks.substring(userInputWithoutBlanks.indexOf(',') +1));
            System.out.println("Sum of odd numbers between +  " + start + " and " + end + " is: " + sumOdd(start, end));
        } while(!(userInputWithoutBlanks.equalsIgnoreCase("exit")));
*/
        ArrayList<String> listOfTestCases = new ArrayList<>();
        listOfTestCases.add("1, 100");
        listOfTestCases.add("-1,100");
        listOfTestCases.add("100, 100");
        listOfTestCases.add("13, 13");
        listOfTestCases.add("100, -100");
        listOfTestCases.add("100, 1000");
        for (String nextTestCase : listOfTestCases){
            System.out.println("Next Test Case is : " + nextTestCase);
            nextTestCase = nextTestCase.replaceAll("\\s+", "");
            // Extracting the start and end of the range for whom the sum of odd numbers is to be calculated from user input without whitespace characters
            start = Integer.parseInt(nextTestCase.substring(0,nextTestCase.indexOf(',')));
            end = Integer.parseInt(nextTestCase.substring(nextTestCase.indexOf(',') +1));
            System.out.println("Sum of odd numbers between +  " + start + " and " + end + " is: " + sumOdd(start, end));
        }


    }
    public static int sumOdd(int start, int end) {
        int sum = -1;
        if( (end >= start) && (start > 0 && end > 0) ) {
            sum = 0;
            int loopCounter = start;
            for(; loopCounter <= end; loopCounter++) {
                if(isOdd(loopCounter)){
                    sum += loopCounter;
                }
            }
        }
        return sum;
    }

    public static boolean isOdd(int number) {
        boolean numberOddStatus = false;
        if(number > 0) {
            numberOddStatus = ((number % 2)!=0) ? true: false;
        }
        return numberOddStatus;
    }
}
