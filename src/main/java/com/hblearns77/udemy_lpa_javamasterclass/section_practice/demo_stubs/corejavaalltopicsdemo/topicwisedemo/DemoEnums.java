package com.hblearns77.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

/**
 * created by : heman on 16-07-2025, 09:11 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoEnums {

    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("ENUMS");

        ConsoleStyler.startSection("Enum Declaration & Usage");
        for (Day day : Day.values()) {
            ConsoleStyler.styleOutput("📆 Day: " + day + " → Mood: " + day.getMood());
        }
        ConsoleStyler.endSection("Enum Declaration & Usage");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
    enum Day {
        MONDAY("😐"), TUESDAY("😶"), WEDNESDAY("🙂"), THURSDAY("😀"), FRIDAY("🥳"),
        SATURDAY("🎉"), SUNDAY("🛌");

        private final String mood;

        Day(String mood) { this.mood = mood; }

        public String getMood() { return mood; }
    }
}
