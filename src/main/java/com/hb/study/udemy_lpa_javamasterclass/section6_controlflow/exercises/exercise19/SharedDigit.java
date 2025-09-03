package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise19;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class SharedDigit {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        System.out.print("Do 12 and 23 have any shared digit?: ");
        ConsoleStyler.styleOutput(Boolean.toString(hasSharedDigit(12, 23)));
        System.out.print("Do 9 and 99 have any shared digit?: ");
        ConsoleStyler.styleOutput(Boolean.toString(hasSharedDigit(9, 99)));
        System.out.print("Do 15 and 55 have any shared digit?: ");
        ConsoleStyler.styleOutput(Boolean.toString(hasSharedDigit(15, 55)));
}

    public static boolean hasSharedDigit (int firstNumber, int secondNumber) {

        boolean sharedDigitsFound = false;
        int firstNumOnesDigit, secondNumOnesDigit, firstNumTensDigit, secondNumTensDigit;
        if( !(firstNumber < 10 || firstNumber > 99 || secondNumber < 10 || secondNumber > 99 )){
            firstNumOnesDigit = firstNumber / 10;
            firstNumTensDigit = firstNumber % 10;
            secondNumOnesDigit = secondNumber / 10;
            secondNumTensDigit = secondNumber % 10;
            if( (firstNumOnesDigit == secondNumOnesDigit)
                    || (firstNumOnesDigit == secondNumTensDigit)
            ){
                ConsoleStyler.styleOutput("Yes, found a shared digit : " + firstNumOnesDigit);
                sharedDigitsFound = true;
            } else if((firstNumTensDigit == secondNumOnesDigit)
                    || (firstNumTensDigit == secondNumTensDigit)){
                ConsoleStyler.styleOutput("Yes, found a shared digit : " + firstNumTensDigit);
                sharedDigitsFound = true;
            } else {
                ConsoleStyler.styleOutput("No Shared Digit found");
            }
        } else {
            ConsoleStyler.styleOutput("Invalid numbers input... ");
        }
    return sharedDigitsFound;
    }
}
