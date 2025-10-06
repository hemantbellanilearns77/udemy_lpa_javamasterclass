package com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.demostubs;


import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class FirstAndLastDigitSum {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        sumFirstAndLastDigit(0);
        sumFirstAndLastDigit(9);
        execution.finalizeExecution();
    }

    public static void sumFirstAndLastDigit(int numToEvaluate) {

        int firstDigit;
        int lastDigit;
        int rem = 0;
        int temp;
        int sum;
        if (numToEvaluate >= 0) {
            temp = numToEvaluate;
            lastDigit = temp % 10;
            //loop to find reverse number
            while (temp != 0) {
                rem = temp % 10;
                temp /= 10;
            }

            firstDigit = rem;
            ConsoleStyler.styleOutput("The first and last digits are:  " + firstDigit + " and " + lastDigit);
            sum = firstDigit + lastDigit;
            ConsoleStyler.styleOutput("The sum of first and last digits is :  " + sum);
        }


    }


}
