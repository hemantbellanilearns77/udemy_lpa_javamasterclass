package com.hb.study.misc_utils.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * Demonstrates control flow in Java: conditionals and loops
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */


/**
 * created by : heman on 16-07-2025, 07:48 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoControlFlow {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("CONTROL FLOW");

        ConsoleStyler.startSection("Conditional Statements");
        int score = 82;
        if (score >= 90) {
            System.out.println("🎉 Grade: A");
        } else if (score >= 75) {
            System.out.println("🎊 Grade: B");
        } else {
            System.out.println("😐 Grade: C or below");
        }
        ConsoleStyler.endSection("Conditional Statements");

        ConsoleStyler.startSection("Switch Statement");
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("🍎 You picked an apple!");
                break;
            case "banana":
                System.out.println("🍌 You picked a banana!");
                break;
            default:
                System.out.println("🌀 Unknown fruit");
        }
        ConsoleStyler.endSection("Switch Statement");

        ConsoleStyler.startSection("Loops");

        System.out.println("🔁 For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(" Loop #" + i);
        }

        System.out.println("🔂 While loop:");
        int count = 3;
        while (count > 0) {
            System.out.println(" Countdown: " + count);
            count--;
        }

        System.out.println("🔄 Do-While loop:");
        int tries = 1;
        do {
            System.out.println(" Attempt #" + tries);
            tries++;
        } while (tries <= 3);

        ConsoleStyler.endSection("Loops");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
