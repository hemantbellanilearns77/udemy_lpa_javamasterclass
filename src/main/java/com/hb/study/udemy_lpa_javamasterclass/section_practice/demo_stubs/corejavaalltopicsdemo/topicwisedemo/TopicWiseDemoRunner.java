package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * created by : heman on 16-07-2025, 09:48 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class TopicWiseDemoRunner {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

        public static void main(String[] ignoredUnusedArgs) {
        //
        execution.initialize();

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
            } catch (IOException ioException) {
                ConsoleStyler.styleError("IOException : " + ioException.getMessage());
            }
        });
        run("Networking", () -> {
            try {
                DemoNetworking.main(new String[]{});
            } catch (MalformedURLException malformedURLException) {
                ConsoleStyler.styleError("MalformedURLException : " + malformedURLException.getMessage());
            }
        });

        ConsoleStyler.printBanner("🎉 ALL DEMOS EXECUTED");
        execution.finalizeExecution();
    }

    private static void run(String label, Runnable demoMethod)  {
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("🚀 Launching: " + label);
        demoMethod.run();
        ConsoleStyler.styleOutput("✅ Completed: " + label);
        ConsoleStyler.divider();
    }
}
