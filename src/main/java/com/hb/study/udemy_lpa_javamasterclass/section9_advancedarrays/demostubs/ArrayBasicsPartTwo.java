package com.hb.study.udemy_lpa_javamasterclass.section9_advancedarrays.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class ArrayBasicsPartTwo {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String... args) {
        execution.initialize(args);
        String[] textList = "Hello World Again".split(" ");
        printText(textList);
        String[] testStringArray = {"Test1", "Test2", "Test3", "Test4", "Test5"};
        ConsoleStyler.styleOutput(String.join("; ", testStringArray));
        execution.finalizeExecution();
    }

    private static void printText(String[] textList) {
        for (String stringElement : textList) {
            ConsoleStyler.styleOutput(stringElement);
        }
    }
}
