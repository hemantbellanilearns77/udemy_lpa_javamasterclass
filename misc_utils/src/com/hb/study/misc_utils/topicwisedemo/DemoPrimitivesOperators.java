package com.hb.study.misc_utils.topicwisedemo;

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
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("PRIMITIVES & OPERATORS");

        ConsoleStyler.startSection("Primitive Declarations");
        int age = 25;
        double price = 99.99;
        boolean isAvailable = true;
        char grade = 'A';

        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Available? " + isAvailable);
        System.out.println("Grade: " + grade);
        ConsoleStyler.endSection("Primitive Declarations");

        ConsoleStyler.startSection("Arithmetic Operators");
        int a = 10, b = 3;
        System.out.println("Add: " + (a + b));
        System.out.println("Subtract: " + (a - b));
        System.out.println("Multiply: " + (a * b));
        System.out.println("Divide: " + ((double) a / b));
        System.out.println("Modulus: " + (a % b));
        ConsoleStyler.endSection("Arithmetic Operators");

        ConsoleStyler.startSection("Comparison Operators");
        System.out.println("Is A > B? " + (a > b));
        System.out.println("Is A == B? " + (a == b));
        System.out.println("Is A != B? " + (a != b));
        ConsoleStyler.endSection("Comparison Operators");

        ConsoleStyler.startSection("Logical Operators");
        boolean isAdult = age >= 18;
        boolean hasTicket = false;
        System.out.println("Can enter? " + (isAdult && hasTicket));
        System.out.println("Override entry? " + (isAdult || hasTicket));
        System.out.println("Ticket denied? " + !hasTicket);
        ConsoleStyler.endSection("Logical Operators");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
