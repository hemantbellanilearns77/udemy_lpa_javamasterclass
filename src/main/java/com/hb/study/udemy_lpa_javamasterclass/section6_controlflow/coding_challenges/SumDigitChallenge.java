package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

/*
Please preserve this ...... good validations, exception handling etc....
*/
public class SumDigitChallenge {
        public static void main(String[] ignoredUnusedArgs) {
        //
        Scanner scanner = new Scanner(System.in);
        String userInput, userInputWithoutBlanks;
        int sumReceived = -1;

        do {
            System.out.print("\nPlease inout positive integer (Example: 1234)  or 0 (the sum of whose digits is required: " +
                    "\nOR Please inout either of these words  (\"exit\" or \"quit\" or \"end\") to quit: " );
            userInput = scanner.nextLine();
            // removes all whitespace characters (i.e. spaces, tabs, newlines etc.. ) from string
            userInputWithoutBlanks = userInput.replaceAll("\\s+", "");
            if(userInputWithoutBlanks.equalsIgnoreCase("exit")) { continue ; }

            ConsoleStyler.styleOutput("userInput was: " + userInput); // + ", \nand userInputWithoutBlanks is:" + userInputWithoutBlanks);
            try{
                sumReceived = sumDigits(Integer.parseInt(userInputWithoutBlanks));
                ConsoleStyler.styleOutput("The sum of digits of " + userInputWithoutBlanks
                        + " is: " + sumReceived);
                if(sumReceived == -1) {
                    ConsoleStyler.styleOutput("Invalid Input : Negative Number is not acceptable, please input a positive integer or 9");
                }
            } catch(NumberFormatException nfe){
                ConsoleStyler.styleOutput("\nSorry Invalid Input !! \nPlease note that haracters other than a positive integer or 0 or " +
                        "either of these words  (\"exit\" or \"quit\" or \"end\") are  allowed as inputs, " +
                        "so please try again.... ");
                continue;
            };


        } while ( !userHasQuit(userInputWithoutBlanks) );

    }

    public static boolean userHasQuit(String userInputWithoutBlanks) {
        boolean userQuitsStatus = false;
            if(userInputWithoutBlanks.equalsIgnoreCase("exit")
                    || userInputWithoutBlanks.equalsIgnoreCase("quit")
                    || userInputWithoutBlanks.equalsIgnoreCase("end")
            ) {
                userQuitsStatus = true;
            }
        return userQuitsStatus;
    }

    public static int sumDigits(int number) {
        int sum = -1;
        int remainingNumber = number;
        int remainderDigit;
        if(remainingNumber >= 0 ) {
            sum+=1;
            while( (remainingNumber / 10) != 0) {
                remainderDigit = remainingNumber % 10;
                sum = sum  + remainderDigit;
                remainingNumber = remainingNumber / 10;
            }
            sum +=  remainingNumber;
        }
        return sum;
    }
}
