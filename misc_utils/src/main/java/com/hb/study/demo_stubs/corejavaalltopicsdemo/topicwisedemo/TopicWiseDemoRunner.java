package com.hb.study.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * created by : heman on 16-07-2025, 09:48 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class TopicWiseDemoRunner {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("TOPIC-WISE JAVA DEMO RUNNER 🎯");

        run("Primitives & Operators", () -> DemoPrimitivesOperators.main(new String[]{}));
        run("Control Flow", () -> DemoControlFlow.main(new String[]{}));
        run("OOP Concepts", () -> DemoOOPConcepts.main(new String[]{}));
        run("String Operations", () -> DemoStrings.main(new String[]{}));
        run("Arrays", () -> DemoArrays.main(new String[]{}));
        run("Math Operations", () -> DemoMathOperations.main(new String[]{}));
        run("Date & Time", () -> DemoDateTime.main(new String[]{}));
        run("Collections", () -> DemoCollections.main(new String[]{}));
        run("Exception Handling", () -> DemoExceptionHandling.main(new String[]{}));
        run("Enums", () -> DemoEnums.main(new String[]{}));
        run("File I/O", () -> {
            try {
                DemoAllIO.main(new String[]{});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        run("Networking", () -> {
            try {
                DemoNetworking.main(new String[]{});
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        });
        //run("Advanced Features", () -> DemoAdvancedFeatures.main(new String[]{}));

        ConsoleStyler.printBanner("🎉 ALL DEMOS EXECUTED");

        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    private static void run(String label, Runnable demoMethod)  {
        ConsoleStyler.divider();
        System.out.println("🚀 Launching: " + label);
        demoMethod.run();
        System.out.println("✅ Completed: " + label);
        ConsoleStyler.divider();
    }
}
