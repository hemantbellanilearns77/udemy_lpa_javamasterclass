package com.hb.study.udemy_lpa_javamasterclass.section4_basics.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class OperatorsChallenge {

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        double myFirstValue = 20.0d;
        double mySecondValue = 80.0d;

        double myValuesTotal = calculateTotal(myFirstValue, mySecondValue);
        ConsoleStyler.styleOutput("myValuesTotal : " + myValuesTotal);

        double modDivisor = 40.58d;
        double remainder = calculateRemainder(myValuesTotal, modDivisor);
        ConsoleStyler.styleOutput("Divisor: " + modDivisor + " | Remainder: " + remainder);
        ConsoleStyler.styleOutput(remainder == 0.0 ? "There's no remainder" : "Got some remainder");

        modDivisor = 2900 / 100d; // 29.0
        remainder = calculateRemainder(myValuesTotal, modDivisor);
        ConsoleStyler.styleOutput("Divisor: " + modDivisor + " | Remainder: " + remainder);
        ConsoleStyler.styleOutput(remainder == 0.0 ? "There's no remainder" : "Got some remainder");

        execution.finalizeExecution();
    }

    // Extracted method: calculates the total
    public static double calculateTotal(double firstValue, double secondValue) {
        return (firstValue + secondValue) * 100.0d;
    }

    // Extracted method: calculates remainder
    public static double calculateRemainder(double total, double divisor) {
        return total % divisor;
    }
}
