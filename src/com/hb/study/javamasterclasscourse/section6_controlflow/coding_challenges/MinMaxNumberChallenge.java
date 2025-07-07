package com.hb.study.javamasterclasscourse.section6_controlflow.coding_challenges;

import java.util.Scanner;

public class MinMaxNumberChallenge {

    public static void main(String[] args) {

        double maxNumber = 0.0;
        double minNumber = 0.0;
        String nextInput;
        double nextDecimalNumber = 0.0;
        int numberOfDecimalsScreened = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Please enter the next decimal number or any other character to quit: ");
                nextInput = scanner.nextLine();
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
                System.out.println("Since you entered a non-decimal number character, so exiting");
                break;
            }
        }
        System.out.println("The count of decimal numbers screened to come to max and min values is: " + numberOfDecimalsScreened);
        System.out.println("The minimum number is: " + minNumber);
        System.out.println("The maximum number is: " + maxNumber);
    }
}
