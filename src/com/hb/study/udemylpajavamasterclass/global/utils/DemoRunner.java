package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

/**
 * created by : heman on 16-07-2025, 01:13 pm, in the "udemy_lpa_javamasterclass" project
 * purpose: to demonstrate Console Styling and utilization of common global elements
 **/
public class DemoRunner {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */
        ConsoleStyler.divider();
        System.out.println("Banner printed below");
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONSETUPSSTR);
        ConsoleStyler.divider();
        // 🔷 Start Demo Session
        ConsoleStyler.startSection("Core Java Demo Session");

        // 📌 Print Header
        System.out.println(CommonConstants.HEADER);

        // 📚 String Validation Demo
        ConsoleStyler.startSection("String Validation");
        String testInput = "Hello World";
        boolean isValid = CommonUtils.isValidString(testInput);
        System.out.println("Input: '" + testInput + "' → isValid: " + isValid);
        ConsoleStyler.endSection("String Validation");

        // 🧮 Array Generation + Print
        ConsoleStyler.startSection("Array Generator");
        int[] randomArray = CommonUtils.generateIntArray(CommonConstants.ARRAY_LENGTH, 100);
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
        }
        ConsoleStyler.endSection("Loop Sample");

        // 🧮 Numeric Formatting
        ConsoleStyler.startSection("Double Formatter");
        double value = Math.PI;
        String formatted = CommonUtils.formatDouble(value);
        System.out.println("Formatted PI: " + formatted);
        ConsoleStyler.endSection("Double Formatter");

        // 🏁 Wrap up
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        System.out.println(CommonConstants.EXECUTIONENDEDSTR);
        ConsoleStyler.divider();


        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
