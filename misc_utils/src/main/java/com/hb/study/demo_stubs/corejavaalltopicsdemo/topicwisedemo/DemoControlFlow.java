package com.hb.study.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

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
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("CONTROL FLOW");

        ConsoleStyler.startSection("Conditional Statements");
        int score = 82;
        if (score >= 90) {
            ConsoleStyler.styleOutput("🎉 Grade: A");
        } else if (score >= 75) {
            ConsoleStyler.styleOutput("🎊 Grade: B");
        } else {
            ConsoleStyler.styleOutput("😐 Grade: C or below");
        }
        ConsoleStyler.endSection("Conditional Statements");

        ConsoleStyler.startSection("Switch Statement");
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                ConsoleStyler.styleOutput("🍎 You picked an apple!");
                break;
            case "banana":
                ConsoleStyler.styleOutput("🍌 You picked a banana!");
                break;
            default:
                ConsoleStyler.styleOutput("🌀 Unknown fruit");
        }
        ConsoleStyler.endSection("Switch Statement");

        ConsoleStyler.startSection("Loops");

        ConsoleStyler.styleOutput("🔁 For loop:");
        for (int i = 1; i <= 5; i++) {
            ConsoleStyler.styleOutput(" Loop #" + i);
        }

        ConsoleStyler.styleOutput("🔂 While loop:");
        int count = 3;
        while (count > 0) {
            ConsoleStyler.styleOutput(" Countdown: " + count);
            count--;
        }

        ConsoleStyler.styleOutput("🔄 Do-While loop:");
        int tries = 1;
        do {
            ConsoleStyler.styleOutput(" Attempt #" + tries);
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
