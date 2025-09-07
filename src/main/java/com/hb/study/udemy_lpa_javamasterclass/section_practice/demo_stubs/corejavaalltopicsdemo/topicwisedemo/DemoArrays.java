package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:56 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoArrays {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("ARRAYS");

        ConsoleStyler.startSection("Declaration & Initialization");
        int[] numbers = {10, 20, 30, 40};
        String[] fruits = new String[] {"Apple", "Banana", "Cherry"};
        ConsoleStyler.endSection("Declaration & Initialization");

        ConsoleStyler.startSection("Iteration");
        for (int num : numbers) {
            ConsoleStyler.styleOutput("🔢 Number: " + num);
        }
        for (int i = 0; i < fruits.length; i++) {
            ConsoleStyler.styleOutput("🍓 Fruit #" + (i + 1) + ": " + fruits[i]);
        }
        ConsoleStyler.endSection("Iteration");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
