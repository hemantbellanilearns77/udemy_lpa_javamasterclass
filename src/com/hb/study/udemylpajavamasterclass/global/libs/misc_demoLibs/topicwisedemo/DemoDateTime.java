package com.hb.study.udemylpajavamasterclass.global.libs.misc_demoLibs.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.time.*;


/**
 * created by : heman on 16-07-2025, 07:59 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoDateTime {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("DATE & TIME");

        ConsoleStyler.startSection("Local DateTime");
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("📆 Today: " + today);
        System.out.println("⏰ Time: " + time);
        System.out.println("🕒 Now: " + now);
        ConsoleStyler.endSection("Local DateTime");

        ConsoleStyler.startSection("Zoned DateTime");
        ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("🛫 Zoned: " + zoned);
        ConsoleStyler.endSection("Zoned DateTime");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}
