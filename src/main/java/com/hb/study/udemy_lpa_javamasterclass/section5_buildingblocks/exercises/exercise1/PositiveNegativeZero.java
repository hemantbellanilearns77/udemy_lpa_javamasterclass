package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise1;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class PositiveNegativeZero {

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        checkNumber(5);
        checkNumber(-9);
        checkNumber(0);
        execution.finalizeExecution();
    }
    public static void checkNumber(int number) {
        if(number == 0) {
            ConsoleStyler.styleOutput("zero");
        } else {
            if(number > 0) {
                ConsoleStyler.styleOutput("positive");
            }
            else {
                ConsoleStyler.styleOutput("negative");
            }
        }
    }
}

