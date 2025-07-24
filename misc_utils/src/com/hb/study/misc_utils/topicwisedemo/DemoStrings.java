package com.hb.study.misc_utils.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * Demonstrates string manipulation, formatting, and comparison in Java
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */
/**
 * created by : heman on 16-07-2025, 07:52 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoStrings {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("STRING OPERATIONS");

        ConsoleStyler.startSection("Basic String Operations");
        String name = "Hemant";
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);
        System.out.println("Length: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());
        System.out.println("Lowercase: " + name.toLowerCase());
        ConsoleStyler.endSection("Basic String Operations");

        ConsoleStyler.startSection("String Comparison");
        String a = "Java";
        String b = "java";
        System.out.println("Equals: " + a.equals(b));
        System.out.println("Equals Ignore Case: " + a.equalsIgnoreCase(b));
        ConsoleStyler.endSection("String Comparison");

        ConsoleStyler.startSection("String Formatting");
        String formatted = String.format("🎯 %s scored %d points", name, 95);
        System.out.println(formatted);
        ConsoleStyler.endSection("String Formatting");

        ConsoleStyler.startSection("StringBuilder Usage");
        StringBuilder sb = new StringBuilder();
        sb.append("🎪 Welcome to the Carnival! ");
        sb.append("Enjoy the ride, ").append(name).append("!");
        System.out.println(sb.toString());
        ConsoleStyler.endSection("StringBuilder Usage");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
