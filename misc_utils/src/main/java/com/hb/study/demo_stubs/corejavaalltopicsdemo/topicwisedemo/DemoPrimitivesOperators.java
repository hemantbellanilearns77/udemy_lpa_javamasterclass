package com.hb.study.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

/**
 * Demonstrates primitive types, variables, and basic operators in Java
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:41 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoPrimitivesOperators {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.printBanner("PRIMITIVES & OPERATORS");

        ConsoleStyler.startSection("Primitive Declarations");
        int age = 25;
        double price = 99.99;
        boolean isAvailable = true;
        char grade = 'A';

        ConsoleStyler.styleOutput("Age: " + age);
        ConsoleStyler.styleOutput("Price: " + price);
        ConsoleStyler.styleOutput("Available? " + isAvailable);
        ConsoleStyler.styleOutput("Grade: " + grade);
        ConsoleStyler.endSection("Primitive Declarations");

        ConsoleStyler.startSection("Arithmetic Operators");
        int a = 10, b = 3;
        ConsoleStyler.styleOutput("Add: " + (a + b));
        ConsoleStyler.styleOutput("Subtract: " + (a - b));
        ConsoleStyler.styleOutput("Multiply: " + (a * b));
        ConsoleStyler.styleOutput("Divide: " + ((double) a / b));
        ConsoleStyler.styleOutput("Modulus: " + (a % b));
        ConsoleStyler.endSection("Arithmetic Operators");

        ConsoleStyler.startSection("Comparison Operators");
        ConsoleStyler.styleOutput("Is A > B? " + (a > b));
        ConsoleStyler.styleOutput("Is A == B? " + (a == b));
        ConsoleStyler.styleOutput("Is A != B? " + (a != b));
        ConsoleStyler.endSection("Comparison Operators");

        ConsoleStyler.startSection("Logical Operators");
        boolean isAdult = age >= 18;
        boolean hasTicket = false;
        ConsoleStyler.styleOutput("Can enter? " + (isAdult && hasTicket));
        ConsoleStyler.styleOutput("Override entry? " + (isAdult || hasTicket));
        ConsoleStyler.styleOutput("Ticket denied? " + !hasTicket);
        ConsoleStyler.endSection("Logical Operators");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        execution.finalizeExecution();
    }
}
