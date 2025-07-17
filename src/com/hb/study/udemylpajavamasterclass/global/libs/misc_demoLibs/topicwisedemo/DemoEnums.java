package com.hb.study.udemylpajavamasterclass.global.libs.misc_demoLibs.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 09:11 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoEnums {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.setUp();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("ENUMS");

        ConsoleStyler.startSection("Enum Declaration & Usage");
        for (Day day : Day.values()) {
            System.out.println("📆 Day: " + day + " → Mood: " + day.getMood());
        }
        ConsoleStyler.endSection("Enum Declaration & Usage");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.windDown();
    }
    enum Day {
        MONDAY("😐"), TUESDAY("😶"), WEDNESDAY("🙂"), THURSDAY("😀"), FRIDAY("🥳"),
        SATURDAY("🎉"), SUNDAY("🛌");

        private final String mood;

        Day(String mood) { this.mood = mood; }

        public String getMood() { return mood; }
    }
}
