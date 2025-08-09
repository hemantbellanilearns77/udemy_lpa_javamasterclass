package com.hb.study.misc_utils.demo_stubs;
/*To convert nanoseconds returned by `System.nanoTime()` to a human-readable date and time format in Java, you need to keep in mind that `System.nanoTime()` returns the current value of the running Java Virtual Machine's high-resolution time source, which is not related to any specific date or time. Instead, you typically use `System.currentTimeMillis()` to get the current time in milliseconds since the epoch (January 1, 1970, 00:00:00 GMT).

        However, if you want to convert a duration in nanoseconds to a human-readable format, you can do that by converting the nanoseconds to milliseconds and then formatting it. Below is a Java program that demonstrates how to convert a duration in nanoseconds to a human-readable date and time format.

        ```java*/
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class NanosecondsToDateTime {
    public static void main(String[] args) {
        // Example: Get the current time in nanoseconds
        long nanoseconds = System.nanoTime();

        // Convert nanoseconds to milliseconds

        // Get the current time in milliseconds since epoch
        long currentTimeMillis = System.currentTimeMillis();

        // Create an Instant from the current time in milliseconds
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);

        // Convert Instant to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Format the LocalDateTime to a human-readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);


        // Convert nanoseconds to milliseconds
        // Output the resul
        long milliseconds = nanoseconds / 1_000_000;
        ConsoleStyler.styleOutput("MillisecondsL " + milliseconds);
        ConsoleStyler.styleOutput("Nanoseconds: " + nanoseconds);
        ConsoleStyler.styleOutput("Current Time in Human-Readable Format: " + formattedDateTime);
    }
}
/*
```

        ### Explanation:
        1. **Get Current Time in Nanoseconds**: The program retrieves the current time in nanoseconds using `System.nanoTime()`.
        2. **Convert to Milliseconds**: It converts nanoseconds to milliseconds by dividing by 1,000,000.
        3. **Get Current Time in Milliseconds**: It retrieves the current time in milliseconds since the epoch using `System.currentTimeMillis()`.
        4. **Create an Instant**: An `Instant` object is created from the current time in milliseconds.
        5. **Convert to LocalDateTime**: The `Instant` is converted to `LocalDateTime` using the system's default time zone.
        6. **Format the DateTime**: The `LocalDateTime` is formatted into a human-readable string using `DateTimeFormatter`.
        7. **Output**: Finally, it prints the nanoseconds and the formatted date and time.

        ### Note:
        - If you want to convert a specific duration in nanoseconds to a date and time, you would need to add that duration to a specific starting point in time (like the epoch) and then format it accordingly.*/
