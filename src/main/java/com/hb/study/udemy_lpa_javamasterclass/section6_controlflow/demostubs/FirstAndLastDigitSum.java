package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class FirstAndLastDigitSum {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        sumFirstAndLastDigit(0);
        sumFirstAndLastDigit(9);

    }

    public static int sumFirstAndLastDigit(int numToEvaluate){

        int firstDigit = 0, lastDigit = 0,  rem = 0, temp = 0;
        int sum = -1;
        if(numToEvaluate >= 0 ) {
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
            ConsoleStyler.styleOutput("The sum of first and last digits is :  " + (firstDigit + lastDigit));
        }
        return sum;


    }


}
