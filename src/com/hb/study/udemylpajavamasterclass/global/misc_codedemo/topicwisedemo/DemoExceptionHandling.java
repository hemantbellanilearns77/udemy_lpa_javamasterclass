package com.hb.study.udemylpajavamasterclass.global.misc_codedemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoExceptionHandling {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

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
            System.out.println("❌ Error: " + e.getMessage());
        }
        ConsoleStyler.endSection("Try-Catch Example");

        ConsoleStyler.startSection("Finally Block");
        try {
            System.out.println("🚀 Processing...");
        } finally {
            System.out.println("✅ Cleanup complete.");
        }
        ConsoleStyler.endSection("Finally Block");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
