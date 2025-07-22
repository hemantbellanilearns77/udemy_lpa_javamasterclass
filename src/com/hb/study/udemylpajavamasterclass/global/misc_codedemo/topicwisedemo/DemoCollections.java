package com.hb.study.udemylpajavamasterclass.global.misc_codedemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoCollections {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

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
            System.out.println("🎫 Guest: " + guest);
        }
        ConsoleStyler.endSection("List Example");

        ConsoleStyler.startSection("Map Example");
        Map<Integer, String> seatMap = new HashMap<>();
        seatMap.put(101, "Alice");
        seatMap.put(102, "Bob");
        System.out.println("🪑 Seat 101: " + seatMap.get(101));
        ConsoleStyler.endSection("Map Example");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
