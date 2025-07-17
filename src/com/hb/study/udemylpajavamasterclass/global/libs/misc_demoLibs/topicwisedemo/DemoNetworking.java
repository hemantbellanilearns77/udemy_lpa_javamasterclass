package com.hb.study.udemylpajavamasterclass.global.libs.misc_demoLibs.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 09:18 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoNetworking {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) throws MalformedURLException {
        execution.setUp();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("NETWORKING");

        ConsoleStyler.startSection("Read from URL");

        URL url = new URL("https://www.oracle.com");
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line = reader.readLine();
            System.out.println("🌐 First line from site: " + line);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ConsoleStyler.endSection("Read from URL");

        ConsoleStyler.printBanner("DEMO COMPLETE");

        /*
         *****************************************************
         */
        execution.windDown();
    }
}
