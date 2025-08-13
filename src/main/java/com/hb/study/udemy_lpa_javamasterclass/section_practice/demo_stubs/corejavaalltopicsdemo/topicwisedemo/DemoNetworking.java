package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 09:18 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoNetworking {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) throws MalformedURLException {
        execution.initialize();
        ConsoleStyler.printBanner("NETWORKING");

        ConsoleStyler.startSection("Read from URL");
        URL url = URI.create("https://www.oracle.com").toURL();
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line = reader.readLine();
            ConsoleStyler.styleOutput("🌐 First line from site: " + line);
        } catch(IllegalArgumentException illegalArgException) {
            ConsoleStyler.styleError("IllegalArgumentException : " + illegalArgException.getMessage());
        } catch (IOException ioException) {
            ConsoleStyler.styleError("IOException : " + ioException.getMessage());
        }
        ConsoleStyler.endSection("Read from URL");
        ConsoleStyler.printBanner("DEMO COMPLETE");
        execution.finalizeExecution();
    }
}
