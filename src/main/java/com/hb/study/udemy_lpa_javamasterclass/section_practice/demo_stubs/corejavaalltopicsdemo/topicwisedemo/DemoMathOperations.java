package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:56 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoMathOperations {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.printBanner("MATH OPERATIONS");

        ConsoleStyler.startSection("Basic Math");
        int a = 5;
        int b = 2;
        ConsoleStyler.styleOutput("Add: " + (a + b));
        ConsoleStyler.styleOutput("Multiply: " + (a * b));
        ConsoleStyler.endSection("Basic Math");

        ConsoleStyler.startSection("Using Math Class");
        double val = 39.69;
        ConsoleStyler.styleOutput("√16: " + Math.sqrt(val));
        ConsoleStyler.styleOutput("Euler's number e raised to the power of " + val + ": " + Math.exp(val));
        ConsoleStyler.endSection("Using Math Class");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        execution.finalizeExecution();
    }
}
