package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ForLoopPractice {
        public static void main(String[] unusedArgs) {
        //
        double interestAmount;
        double principalAmount = 10000.00;
        for(double interestRate = 2.0; interestRate <= 5.0; interestRate++) {
            interestAmount = calculateInterest(10000.00, interestRate);
            ConsoleStyler.styleOutput("Interest earned from $" + principalAmount + " at " + interestRate + "% interest," +
                    " is equal to a sum of: " + interestAmount);
        }
        ConsoleStyler.styleOutput("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        principalAmount = 100;
        for(double interestRate = 7.5; interestRate <= 10.0; interestRate+=0.25) {
            interestAmount = calculateInterest(100.00, interestRate);
            ConsoleStyler.styleOutput("Interest earned from $ " + principalAmount + " at " + interestRate + "% interest," +
                    " is equal to a sum of: $ " + interestAmount);
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate/100) );
    }
}
