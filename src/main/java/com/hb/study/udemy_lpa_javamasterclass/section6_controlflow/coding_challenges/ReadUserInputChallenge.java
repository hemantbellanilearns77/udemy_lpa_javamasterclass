package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

public class ReadUserInputChallenge {

        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }

        Scanner scanner = new Scanner(System.in);
        int countOfIntegers = 0;
        int sum = 0;
        int nextNumber = -1;
        String nextNumberInput = "";

        while(countOfIntegers < 5) {
            ConsoleStyler.styleOutput("Enter a Integer # " + (countOfIntegers+1) + " : ");
            nextNumberInput = scanner.nextLine();
            nextNumber = isValidInteger(nextNumberInput) ? Integer.parseInt(nextNumberInput)  : -1;
            if(nextNumber == -1) {
                continue;
            } else {
                sum += nextNumber;
                countOfIntegers++;
            }
        }
        ConsoleStyler.styleOutput("The sum of " + countOfIntegers + " integers as input above is : " + sum);
    }
    public static boolean isValidInteger(String nextNumberInput){

        boolean isValidInt = true;

        try {
            int nextNumber = Integer.parseInt(nextNumberInput);
        } catch(NumberFormatException numberFormatException){
            ConsoleStyler.styleOutput("Invalid Input");
            isValidInt = false;
            return isValidInt;
        }
        return isValidInt;
    }
}
