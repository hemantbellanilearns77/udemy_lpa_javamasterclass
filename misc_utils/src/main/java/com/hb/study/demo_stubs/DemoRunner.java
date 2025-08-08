package com.hb.study.demo_stubs;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 01:13 pm, in the "udemy_lpa_javamasterclass" project
 * purpose: to demonstrate Console Styling and utilization of common global elements
 **/
public class DemoRunner {

    //Object level or Static declarations here...

    public static void main(String[] ignoredArgs) {
        ExcecutionUtil execution = new ExcecutionUtil();
        execution.initialize();
        demoFunction();
        execution.finalizeExecution();
    }

    private static void demoFunction() {
        ConsoleStyler.divider();
        ConsoleStyler.styleExecutionInsight("Banner printed below");
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONSETUPSSTR);
        ConsoleStyler.divider();
        // 🔷 Start Demo Session
        ConsoleStyler.startSection("Core Java Demo Session");

        // 📌 Print Header
        System.out.println(CommonConstants.HEADER);

        // 📚 String Validation Demo
        ConsoleStyler.startSection("String Validation");
        String testInput = "Hello World";
        ConsoleStyler.styleOutput(null, "Input: '" + testInput + "' → isValid: "
                + CommonUtils.isValidString(testInput));
        ConsoleStyler.endSection("String Validation");

        // 🧮 Array Generation + Print
        ConsoleStyler.startSection("Array Generator");
        int[] randomArray = CommonUtils.generateIntArray(CommonConstants.ARRAY_LENGTH, 63);
        CommonUtils.printArray("Generated Array", randomArray);
        ConsoleStyler.endSection("Array Generator");

        // 📊 Benchmarking Simulated Demo
        ConsoleStyler.startSection("Benchmarking");
        System.out.println(CommonConstants.BENCHMARKSECTIONHEADER);
        System.out.println(CommonConstants.BENCHMARKINSUMMARYSTR);
        System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR);
        ConsoleStyler.endSection("Benchmarking");

        // 🕹️ Loop Demo
        ConsoleStyler.startSection("Loop Sample");
        for (int i = 0; i < CommonConstants.MAX_ITERATION_COUNT; i++) {
            System.out.println("⏱️ Loop step " + (i + 1));
            ConsoleStyler.styleOutput( null, "⏱️ Loop step " + (i + 1));
        }
        ConsoleStyler.endSection("Loop Sample");

        // 🧮 Numeric Formatting
        ConsoleStyler.startSection("Double Formatter");
        double value = Math.PI;
        String formatted = CommonUtils.formatDouble(value);
        ConsoleStyler.styleOutput(null, "Formatted PI: " + formatted);
        ConsoleStyler.endSection("Double Formatter");

        // 🏁 Wrap up
        ConsoleStyler.styleExecutionInsight(CommonConstants.EXECUTIONSETUPSSTR);
        ConsoleStyler.styleExecutionInsight(CommonConstants.EXECUTIONENDEDSTR);
        ConsoleStyler.divider();
    }
}
