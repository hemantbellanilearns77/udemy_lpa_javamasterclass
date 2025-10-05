package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise20;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class LastDigitChecker {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleOutput("hasSameLastDigit (41, 22, 71) gives: " + hasSameLastDigit(41, 22, 71));
        hasSameLastDigit(23, 32, 42);
        ConsoleStyler.styleOutput("hasSameLastDigit (23, 32, 42) gives: " + hasSameLastDigit(23, 32, 42));
        ConsoleStyler.styleOutput("hasSameLastDigit (9, 99, 999) gives: " + hasSameLastDigit(9, 99, 999));
        execution.finalizeExecution();
    }

    public static boolean hasSameLastDigit(int firstNum, int secondNum, int thirdNum) {
        boolean sameLastDigitFoundTwiceOrMore = false;

        int firstNumLastDigit;
        int secondNumLastDigit;
        int thirdNumLastDigit;
        if (isValid(firstNum) && isValid(secondNum) && isValid(thirdNum)) {
            firstNumLastDigit = firstNum % 10;
            secondNumLastDigit = secondNum % 10;
            thirdNumLastDigit = thirdNum % 10;
            if ((firstNumLastDigit == secondNumLastDigit)
                    || (firstNumLastDigit == thirdNumLastDigit)
                    || (secondNumLastDigit == thirdNumLastDigit)) {
                sameLastDigitFoundTwiceOrMore = true;
            }
        }
        ConsoleStyler.styleOutput(Boolean.toString(sameLastDigitFoundTwiceOrMore));
        return sameLastDigitFoundTwiceOrMore;
    }

    public static boolean isValid(int number) {
        return ((number >= 10) && (number <= 1000));
    }
}
