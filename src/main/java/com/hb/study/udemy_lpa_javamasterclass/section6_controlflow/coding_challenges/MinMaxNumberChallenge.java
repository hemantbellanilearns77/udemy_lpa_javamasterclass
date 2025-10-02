package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.Scanner;

public class MinMaxNumberChallenge {

    private static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        double maxNumber = 0.0;
        double minNumber = 0.0;
        String nextInput;
        double nextDecimalNumber;
        int numberOfDecimalsScreened = 0;
        Scanner scanner = new Scanner(System.in);
        boolean loopAgain = false;
        do {
            try {
                ConsoleStyler.styleOutput("Please enter the next decimal number or exit to quit: ");
                nextInput = scanner.nextLine();
                if (!nextInput.equalsIgnoreCase("exit")){
                    nextDecimalNumber = Double.parseDouble(nextInput);
                    numberOfDecimalsScreened++;
                    minNumber = Math.min(nextDecimalNumber, minNumber);
                    maxNumber = Math.max(nextDecimalNumber, maxNumber);

                    loopAgain = true;
                }
            } catch(NumberFormatException _) {
                ConsoleStyler.styleOutput("The input you provided is either 'exit' or something that cannot be interpreted to a decimal number, so exiting");
                loopAgain = false;
            }

        } while(loopAgain);
        ConsoleStyler.styleOutput("The count of decimal numbers screened to come to max and min values is: " + numberOfDecimalsScreened);
        ConsoleStyler.styleOutput("The minimum number is: " + minNumber);
        ConsoleStyler.styleOutput("The maximum number is: " + maxNumber);
        execution.finalizeExecution();
    }
}
