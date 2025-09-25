package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoCollections {

    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("COLLECTIONS");

        ConsoleStyler.startSection("List Example");
        List<String> guests = new ArrayList<>();
        guests.add("Alice");
        guests.add("Bob");
        guests.add("Charlie");
        for (String guest : guests) {
            ConsoleStyler.styleOutput("🎫 Guest: " + guest);
        }
        ConsoleStyler.endSection("List Example");

        ConsoleStyler.startSection("Map Example");
        Map<Integer, String> seatMap = new HashMap<>();
        seatMap.put(101, "Alice");
        seatMap.put(102, "Bob");
        ConsoleStyler.styleOutput("🪑 Seat 101: " + seatMap.get(101));
        ConsoleStyler.endSection("Map Example");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
