package com.hb.study.misc_utils.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoExceptionHandling {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("EXCEPTION HANDLING");

        ConsoleStyler.startSection("Try-Catch Example");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            ConsoleStyler.styleOutput("❌ Error: " + e.getMessage());
        }
        ConsoleStyler.endSection("Try-Catch Example");

        ConsoleStyler.startSection("Finally Block");
        try {
            ConsoleStyler.styleOutput("🚀 Processing...");
        } finally {
            ConsoleStyler.styleOutput("✅ Cleanup complete.");
        }
        ConsoleStyler.endSection("Finally Block");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
