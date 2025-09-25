package com.hb.study.udemy_lpa_javamasterclass.section4_basics.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

public class OperatorsChallenge {
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    // Named constants instead of magic numbers
    private static final double FIRST_VALUE = 20.0d;
    private static final double SECOND_VALUE = 80.0d;
    private static final double MULTIPLIER = 100.0d;
    private static final double DIVISOR_ONE = 40.58d;
    private static final double DIVISOR_TWO = 29.0d; // from 2900/100d

    public static void main(String[] args) {
        execution.initialize(args);

        ConsoleStyler.styleExecutionInsight("""
                The below was earlier used without parenthesis to demonstrate operator parenthesis, removed to fix a Sonar:
                double myValuesTotal = myFirstValue + mySecondValue * 100.00d;
                """);

        double myValuesTotal = (FIRST_VALUE + SECOND_VALUE) * MULTIPLIER;
        ConsoleStyler.styleOutput("myValuesTotal : " + myValuesTotal);

        // Reuse helper method instead of duplicating logic
        checkRemainder(myValuesTotal, DIVISOR_ONE);
        checkRemainder(myValuesTotal, DIVISOR_TWO);

        execution.finalizeExecution();
    }

    private static void checkRemainder(double total, double divisor) {
        double remainder = total % divisor;
        ConsoleStyler.styleOutput("theRemainder : " + remainder);

        // Use tolerance for floating point comparison
        if (Math.abs(remainder) < 1e-9) {
            ConsoleStyler.styleOutput("There's no remainder");
        } else {
            ConsoleStyler.styleOutput("Got some remainder");
        }
    }
}
