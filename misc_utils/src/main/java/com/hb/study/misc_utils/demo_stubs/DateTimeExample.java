package com.hb.study.misc_utils.demo_stubs;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/*To convert `System.getCurrentMillis()` to a full `FormatStyle` date-time format in Java, you can use the `java.time` package, which provides a modern date and time API. Here's how you can do it:

        1. Get the current milliseconds using `System.currentTimeMillis()`.
        2. Convert those milliseconds to an `Instant`.
        3. Convert the `Instant` to a `ZonedDateTime` or `LocalDateTime` depending on whether you need time zone information.
        4. Format the date-time using `DateTimeFormatter` with the desired `FormatStyle`.

        Here's an example code snippet that demonstrates this process:
        ### Explanation:
        - `System.currentTimeMillis()` retrieves the current time in milliseconds since the epoch (January 1, 1970).
        - `Instant.ofEpochMilli(currentMillis)` converts the milliseconds to an `Instant`.
        - `LocalDateTime.ofInstant(instant, ZoneId.systemDefault())` converts the `Instant` to a `LocalDateTime` in the system's default time zone.
        - `DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)` creates a formatter for a full date-time style.
        - Finally, `localDateTime.format(formatter)` formats the `LocalDateTime` to a string representation.

        You can adjust the `ZoneId` if you need to work with a specific time zone.*/

public class DateTimeExample {
    public static void main(String[] args) {
        // Step 1: Get current milliseconds
        long currentMillis = System.currentTimeMillis();

        // Step 2: Convert milliseconds to Instant
        Instant instant = Instant.ofEpochMilli(currentMillis);

        // Step 3: Convert Instant to LocalDateTime (or ZonedDateTime)
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        // Step 4: Format the LocalDateTime using FULL FormatStyle
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String formattedDateTime = zonedDateTime.format(formatter);

        // Output the formatted date-time
        ConsoleStyler.styleOutput(null,formattedDateTime);
    }
}
