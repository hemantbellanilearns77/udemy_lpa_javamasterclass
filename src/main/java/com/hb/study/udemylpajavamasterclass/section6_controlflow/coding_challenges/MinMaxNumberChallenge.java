package com.hb.study.udemylpajavamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

public class MinMaxNumberChallenge {

    public static void main(String[] ignoredArgs) {

        double maxNumber = 0.0;
        double minNumber = 0.0;
        String nextInput;
        double nextDecimalNumber;
        int numberOfDecimalsScreened = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                ConsoleStyler.styleOutput("Please enter the next decimal number or exit to quit: ");
                nextInput = scanner.nextLine();
                if (nextInput.equalsIgnoreCase("exit")){
                    break;
                }
                nextDecimalNumber = Double.parseDouble(nextInput);
                numberOfDecimalsScreened++;
               if(numberOfDecimalsScreened == 1){
                   minNumber = maxNumber = nextDecimalNumber;
               } else {
                   if(nextDecimalNumber > maxNumber) {
                       maxNumber = nextDecimalNumber;
                   }
                   if(nextDecimalNumber < minNumber){
                       minNumber = nextDecimalNumber;
                   }
               }
            } catch(NumberFormatException nfe) {
                ConsoleStyler.styleOutput("Since you entered a non-decimal number character, so exiting");
                break;
            }
        }
        ConsoleStyler.styleOutput("The count of decimal numbers screened to come to max and min values is: " + numberOfDecimalsScreened);
        ConsoleStyler.styleOutput("The minimum number is: " + minNumber);
        ConsoleStyler.styleOutput("The maximum number is: " + maxNumber);
    }
}
