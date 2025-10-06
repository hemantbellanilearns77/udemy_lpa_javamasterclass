package com.hblearns77.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

 import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

/**
 * Demonstrates string manipulation, formatting, and comparison in Java
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */
/**
 * created by : heman on 16-07-2025, 07:52 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoStrings {

    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("STRING OPERATIONS");

        ConsoleStyler.startSection("Basic String Operations");
        String name = "Hemant";
        String greeting = "Hello, " + name + "!";
        ConsoleStyler.styleOutput(greeting);
        ConsoleStyler.styleOutput("Length: " + name.length());
        ConsoleStyler.styleOutput("Uppercase: " + name.toUpperCase());
        ConsoleStyler.styleOutput("Lowercase: " + name.toLowerCase());
        ConsoleStyler.endSection("Basic String Operations");

        ConsoleStyler.startSection("String Comparison");
        String a = "Java";
        String b = "java";
        ConsoleStyler.styleOutput("Equals: " + a.equals(b));
        ConsoleStyler.styleOutput("Equals Ignore Case: " + a.equalsIgnoreCase(b));
        ConsoleStyler.endSection("String Comparison");

        ConsoleStyler.startSection("String Formatting");
        String formatted = String.format("🎯 %s scored %d points", name, 95);
        ConsoleStyler.styleOutput(formatted);
        ConsoleStyler.endSection("String Formatting");

        ConsoleStyler.startSection("StringBuilder Usage");
        StringBuilder sb = new StringBuilder();
        sb.append("🎪 Welcome to the Carnival! ");
        sb.append("Enjoy the ride, ").append(name).append("!");
        ConsoleStyler.styleOutput(sb.toString());
        ConsoleStyler.endSection("StringBuilder Usage");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
