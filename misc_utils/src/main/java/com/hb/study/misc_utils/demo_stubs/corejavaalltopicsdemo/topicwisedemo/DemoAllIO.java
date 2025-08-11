package com.hb.study.misc_utils.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.io.IOException;
import java.nio.file.*;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 09:14 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoAllIO {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) throws IOException {
        execution.initialize();


        ConsoleStyler.printBanner("FILE I/O");

        ConsoleStyler.startSection("Write to File");
        Path path = Paths.get("sample_output.txt");
        Files.writeString(path, "🎪 Carnival welcomes you, Hemant!");
        ConsoleStyler.styleOutput("✅ Written to file: " + path);
        ConsoleStyler.endSection("Write to File");

        ConsoleStyler.startSection("Read from File");
        String content = Files.readString(path);
        ConsoleStyler.styleOutput("📖 Read content: " + content);
        ConsoleStyler.endSection("Read from File");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        execution.finalizeExecution();
    }
}


