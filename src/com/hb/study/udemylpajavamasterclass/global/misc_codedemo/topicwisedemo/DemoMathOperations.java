package com.hb.study.udemylpajavamasterclass.global.misc_codedemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:56 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoMathOperations {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("MATH OPERATIONS");

        ConsoleStyler.startSection("Basic Math");
        int a = 5, b = 2;
        System.out.println("Add: " + (a + b));
        System.out.println("Multiply: " + (a * b));
        ConsoleStyler.endSection("Basic Math");

        ConsoleStyler.startSection("Using Math Class");
        double val = 16.0;
        System.out.println("√16: " + Math.sqrt(val));
        System.out.println("Random (0-1): " + Math.random());
        ConsoleStyler.endSection("Using Math Class");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
