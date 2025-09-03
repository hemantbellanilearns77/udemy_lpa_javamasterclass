package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.demo_stubs;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class LoopTiming {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }

        demooLoopTimingsByCopilotUsingNano();
        demooLoopTimingsByCopilotUsingCurrentMillis();
    }

    public static void demooLoopTimingsByCopilotUsingNano() {
        ConsoleStyler.styleIntro("""
                I had asked Copilot
                how to calculate how much time in minutes and seconds did a for loop take in Java
                and can you add calculation of hours and day to the above?
                Certainly! Below is the updated Java code that calculates the time taken by a `for` loop,
                including days, hours, minutes, seconds, and milliseconds.
                This example uses `System.nanoTime()` for high precision.
                ### Using `System.nanoTime()`
                ```java
                """);

        ConsoleStyler.styleIntro("""
                Copilot responded:
                Certainly! Below is the updated Java code that calculates the time taken by a `for` loop,
                ncluding days, hours, minutes, seconds, and milliseconds.
                This example uses `System.nanoTime()` for high precision.
                ### Using `System.nanoTime()`
                 ```java
                """);
        // Start time
        long startTime = System.nanoTime();

        // Your for loop
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            ConsoleStyler.styleOutput("" + i);
        }

        // End time
        long endTime = System.nanoTime();

        // Calculate the duration in nanoseconds
        long duration = endTime - startTime;

        // Convert duration to milliseconds
        long milliseconds = duration / 1_000_000;
        long nanoseconds = duration % 1_000_000;

        // Convert milliseconds to seconds
        long seconds = milliseconds / 1000;
        milliseconds = milliseconds % 1000;

        // Convert seconds to hours, days and minutes
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        // Remaining seconds, minutes, and hours
        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;

        // Print the result
        ConsoleStyler.styleOutput("Time taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n"
                .formatted(days, hours, minutes, seconds, milliseconds, nanoseconds));

    }

    public static void demooLoopTimingsByCopilotUsingCurrentMillis() {
        ConsoleStyler.styleIntro("""
                Additionally Copilot also shared the way to do it using :
                 ### Using `System.currentTimeMillis()`
                If you prefer to use `System.currentTimeMillis()`, here's how you can do it:
                ### Using `System.currentTimeMillis()`
                If you prefer to use `System.currentTimeMillis()`, here's how you can do it:
                """);
        // Start time
        long startTime = System.currentTimeMillis();

        long count = 0;
        // Your for loop
        for (int i = new SecureRandom().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE); i < Integer.MAX_VALUE; i++) {
            // Simulate some work
            count++;
        }
        ConsoleStyler.styleOutput(count + CommonConstants.EMPTYSTRING);
        // End time
        long endTime = System.currentTimeMillis();

        // Calculate the duration in milliseconds
        long duration = endTime - startTime;

        // Convert duration to seconds and milliseconds
        long milliseconds = duration % 1000;
        long nanoseconds = duration % 1_000_000;
        long seconds = duration / 1000;

        // Convert seconds to hours, days and minutes
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        // Remaining seconds, minutes, and hours
        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;


        //Formating Start and End Time using ZonedDateTime Formatting
        Instant startInstant = Instant.ofEpochMilli(startTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        ZonedDateTime zonedStartDateTime = ZonedDateTime.ofInstant(startInstant, ZoneId.systemDefault());
        ConsoleStyler.styleOutput("Execution started at: " + zonedStartDateTime.format(formatter));

        Instant endInstant = Instant.ofEpochMilli(endTime);
        ZonedDateTime zonedEndDateTime = ZonedDateTime.ofInstant(endInstant, ZoneId.systemDefault());
        ConsoleStyler.styleOutput("Execution ended at: " + zonedEndDateTime.format(formatter));

        // Print the result

        ConsoleStyler.styleOutput("OverallTime taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n"
                .formatted(days, hours, minutes, seconds, milliseconds, nanoseconds));
    }
}

