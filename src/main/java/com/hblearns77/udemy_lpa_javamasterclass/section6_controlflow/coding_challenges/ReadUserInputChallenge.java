package com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.Scanner;

public class ReadUserInputChallenge {
    private static final ExecutionUtil execution = new ExecutionUtil();
        public static void main(String[] args) {
        execution.initialize(args);

        Scanner scanner = new Scanner(System.in);
        int countOfIntegers = 0;
        int sum = 0;
        int nextNumber;
        String nextNumberInput;

        while(countOfIntegers < 5) {
            ConsoleStyler.styleOutput("Enter a Integer # " + (countOfIntegers+1) + " : ");
            nextNumberInput = scanner.nextLine();
            nextNumber = isValidInteger(nextNumberInput) ? Integer.parseInt(nextNumberInput)  : -1;
            if(nextNumber != -1) {
                sum += nextNumber;
                countOfIntegers++;
            }
        }
        ConsoleStyler.styleOutput("The sum of " + countOfIntegers + " integers as input above is : " + sum);
        execution.finalizeExecution();
    }
    public static boolean isValidInteger(String nextNumberInput){

        boolean isValidInt = true;
        int nextNumber;
        try {
            nextNumber = Integer.parseInt(nextNumberInput);
            ConsoleStyler.styleExecutionInsight("You entered: " + nextNumber + " and that's a valid Input!");
        } catch(NumberFormatException _){
            ConsoleStyler.styleExecutionInsight("You entered: " + nextNumberInput + " and that's an Invalid Input!");
            isValidInt = false;
        }
        return isValidInt;
    }
}
