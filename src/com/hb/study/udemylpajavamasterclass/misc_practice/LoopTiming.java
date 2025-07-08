package com.hb.study.udemylpajavamasterclass.misc_practice;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

/*

how to calculate how much time in minutes and seconds did a for loop take in Java
and can you add calculation of hours and day to the above?
Certainly! Below is the updated Java code that calculates the time taken by a `for` loop,
including days, hours, minutes, seconds, and milliseconds.
This example uses `System.nanoTime()` for high precision.
### Using `System.nanoTime()`
```java


public class LoopTiming {

        public static void main(String[] args) {
            // Start time
            long startTime = System.nanoTime();

            // Your for loop
            for (long i = 0; i < Integer.MAX_VALUE; i++) {
                // Simulate some work
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
            System.out.printf("Time taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n",
                    days, hours, minutes, seconds, milliseconds, nanoseconds);
        }
}


### Using `System.currentTimeMillis()`

If you prefer to use `System.currentTimeMillis()`, here's how you can do it:

```java
### Using `System.currentTimeMillis()`

If you prefer to use `System.currentTimeMillis()`, here's how you can do it:

```java
*/
public class LoopTiming {
    public static void main(String[] args) {
        // Start time
        long startTime = System.currentTimeMillis();

        long count = 0;
        // Your for loop
        for (int i = new Random().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE); i < Integer.MAX_VALUE; i++ ) {
            // Simulate some work
            count++;
        }
        System.out.println(count);
        // End time
        long endTime = System.currentTimeMillis();

        // Calculate the duration in milliseconds
        long duration = endTime - startTime;

        // Convert duration to seconds and milliseconds
        long milliseconds = duration % 1000;
        long seconds = duration / 1000;

        // Convert seconds to hours, days and minutes
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        // Remaining seconds, minutes, and hours
        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;

        Instant startInstant = Instant.ofEpochMilli(startTime);
        Instant endInstant = Instant.ofEpochMilli(endTime);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        //LocalDateTime dateTime = LocalDateTime.ofInstant(startInstant,ZoneId.systemDefault());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(startInstant, ZoneId.systemDefault());
        System.out.println("Execution started at: " + zonedDateTime.format(formatter));
        //dateTime = LocalDateTime.ofInstant(endInstant, ZoneId.systemDefault());
        zonedDateTime = ZonedDateTime.ofInstant(startInstant,ZoneId.systemDefault());
        System.out.println("Execution ended at: " + zonedDateTime.format(formatter));
        // Print the result
        System.out.printf("Overall Time taken to loop %d times: %d days, %d hours, %d minutes, %d seconds, %d milliseconds%n",
                          count, days, hours, minutes, seconds, milliseconds);
    }
}

