package com.hb.study.udemylpajavamasterclass.misc_practice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LongToHumanReadableTime {
    public static void main(String[] args) {
        long epochMilli = System.currentTimeMillis();
        // 1. Convert long to Instant
        Instant instant = Instant.ofEpochMilli(epochMilli);

        // 2. Convert Instant to LocalDateTime (requires a ZoneId)
        // Use ZoneId.systemDefault() for the local time zone
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // 3. Format the LocalDateTime into a human-readable string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("Long value: " + epochMilli);
        System.out.println("Human-readable time: " + formattedDateTime);
    }
}