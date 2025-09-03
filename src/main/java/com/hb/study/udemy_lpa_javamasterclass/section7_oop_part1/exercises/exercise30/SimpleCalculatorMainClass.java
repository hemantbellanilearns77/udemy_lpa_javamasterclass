package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise30;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class SimpleCalculatorMainClass {
        public static void main(String[] ignoredUnusedArgs) {

        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        ConsoleStyler.styleOutput("add= " + calculator.getAdditionResult());
        ConsoleStyler.styleOutput("subtract= " + calculator.getSubtractionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        ConsoleStyler.styleOutput("multiply= " + calculator.getMultiplicationResult());
        ConsoleStyler.styleOutput("divide= " + calculator.getDivisionResult());
    }
}
