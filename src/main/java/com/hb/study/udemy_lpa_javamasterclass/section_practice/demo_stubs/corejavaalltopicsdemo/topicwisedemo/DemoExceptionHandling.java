package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoExceptionHandling {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredignoredUnusedArgs) {
        execution.initialize();

        ConsoleStyler.styleExecutionInsight("DEMO EXCEPTION HANDLING");

        ConsoleStyler.startSection("Try-Catch Example");
        try {

            ConsoleStyler.styleOutput("Division by Zero: " + 10/0);
        } catch (ArithmeticException e) {
            ConsoleStyler.styleError("❌ Error: " + e.getMessage());
        }
        ConsoleStyler.endSection("Try-Catch Example");

        ConsoleStyler.startSection("Finally Block");
        try {
            ConsoleStyler.styleOutput("🚀 Processing...");
        } finally {
            ConsoleStyler.styleOutput("✅ Cleanup complete.");
        }
        ConsoleStyler.endSection("Finally Block");

        ConsoleStyler.styleExecutionInsight("DEMO EXCEPTION HANDLING - COMPLETE");

        execution.finalizeExecution();
    }
}
