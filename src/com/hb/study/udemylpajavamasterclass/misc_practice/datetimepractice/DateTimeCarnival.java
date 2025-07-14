package com.hb.study.udemylpajavamasterclass.misc_practice.datetimepractice;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.time.*;
import java.time.chrono.*;
import java.time.format.*;
import java.util.*;

/**
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 * ┃                              DATE-TIME CARNIVAL                            ┃
 * ┃                              ✨ Formatter Showcase ✨                       ┃
 * ┃-----------------------------------------------------------------------------┃
 * ┃ 📦 Package     : com.hb.study.udemylpajavamasterclass.misc_practice        ┃
 * ┃ 📜 Project     : udemy_lpa_javamasterclass                                  ┃
 * ┃ 🧠 Author      : Hemant (aka Formatter Maestro)                             ┃
 * ┃ 🕰️ Created On  : 14-July-2025, 10:33 AM                                     ┃
 * ┃-----------------------------------------------------------------------------┃
 * ┃ 🧭 Purpose:                                                                  ┃
 * ┃   This class is a celebratory showcase of Java's DateTimeFormatter APIs —  ┃
 * ┃   featuring built-in styles, custom regional formats, time zones, calendar ┃
 * ┃   systems, and benchmarking utilities. It's a creative deep dive into      ┃
 * ┃   internationalization and temporal aesthetics.                            ┃
 * ┃-----------------------------------------------------------------------------┃
 * ┃ 🎪 Features Demonstrated:                                                   ┃
 * ┃   ✔️ FormatStyle combinations (FULL, LONG, MEDIUM, SHORT)                   ┃
 * ┃   ✔️ Custom patterns for EU/US/Asia/Africa/Oceania regions                 ┃
 * ┃   ✔️ Locales including Hindi, Japanese, Thai, Arabic                        ┃
 * ┃   ✔️ ZonedDateTime and region-based offsets                                 ┃
 * ┃   ✔️ Japanese Imperial & Thai Buddhist calendar formats                     ┃
 * ┃   ✔️ AM/PM quirks handled via localized pattern symbols                     ┃
 * ┃   ✔️ Human-readable time offset display                                     ┃
 * ┃   ✔️ Benchmarking via currentTimeMillis & nanoTime                          ┃
 * ┃   ✔️ Output enhanced with asterisk separators and emoji headers 🪄         ┃
 * ┃-----------------------------------------------------------------------------┃
 * ┃ 🧪 Ideal for:                                                                ┃
 * ┃   - Learning advanced date formatting techniques                            ┃
 * ┃   - Building international-ready apps                                       ┃
 * ┃   - Demoing locale awareness and time zone behavior                         ┃
 * ┃   - Understanding calendar conversions and localized rendering              ┃
 * ┃-----------------------------------------------------------------------------┃
 * ┃ 💡 Tip:                                                                      ┃
 * ┃   Customize CommonConstants for even more stylistic formatting             ┃
 * ┃   Try plugging this into a GUI or REST API for a live calendar showcase 🎨┃
 * ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class DateTimeCarnival {

    public static ExcecutionUtil execution = new ExcecutionUtil();
    public static void main(String[] ignoredArgs) {
        execution.executionSetup();
        long millisStart = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(millisStart);
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime fromMillis = instant.atZone(ZoneId.systemDefault());
        long nanoStart = System.nanoTime();

        Duration duration = Duration.between(fromMillis, now);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("\n🎉 Welcome to the Ultimate Formatter Carnival!");
        System.out.println("🕒 System.currentTimeMillis(): " + millisStart);
        System.out.println("📅 Converted to ZonedDateTime: " + fromMillis);
        System.out.println("🕒 Current time (ZonedDateTime.now()): " + now);
        System.out.printf("⏳ Human-readable offset: %d hours, %d minutes, %d seconds ago\n\n", hours, minutes, seconds);

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");

        String[] customPatterns = {
                "dd.MM.yyyy", "dd/MM/yyyy", "dd MMMM yyyy", "EEEE, dd MMMM yyyy",
                "yyyy-MM-dd", "MM/dd/yyyy", "MMMM dd, yyyy", "EEE, MMM dd, yyyy hh:mm a",
                "MM-dd-yyyy hh:mm:ss a", "dd-MM-yyyy", "dd MMM yyyy", "yyyy/MM/dd",
                "yyyy年MM月dd日", "yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy"
        };

        Locale[] locales = {
                Locale.UK, Locale.US, Locale.FRANCE, new Locale("hi", "IN"),
                new Locale("th", "TH"), Locale.JAPAN, Locale.CHINA,
                new Locale("en", "AU"), new Locale("en", "NZ"),
                new Locale("de", "DE"), new Locale("ar", "EG"), new Locale("en", "ZA")
        };

        ZoneId[] zones = {
                ZoneId.of("Europe/London"),
                ZoneId.of("America/New_York"),
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("Asia/Bangkok"),
                ZoneId.of("Africa/Nairobi"),
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Asia/Kolkata")
        };

        System.out.println("🌐 Custom Pattern Demonstration:");
        for (Locale locale : locales) {
            System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
            System.out.println("🔸 Locale: " + locale.getDisplayName());
            for (String pattern : customPatterns) {
                for (ZoneId zone : zones) {
                    ZonedDateTime zoned = fromMillis.withZoneSameInstant(zone);
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
                        String result = formatter.format(zoned);
                        System.out.printf("📍 [%s] Zone: %-25s → %s\n", pattern, zone, result);
                    } catch (Exception e) {
                        System.out.printf("⚠️ Failed [%s] in %s\n", pattern, locale);
                    }
                }
            }
        }

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        System.out.println("🏯 Japanese Imperial Calendar:");
        JapaneseDate japanDate = JapaneseDate.from(fromMillis);
        DateTimeFormatter japFormatter = DateTimeFormatter.ofPattern("GGGG yyyy/MM/dd", Locale.JAPAN);
        System.out.println("🗾 Formatted: " + japFormatter.format(japanDate));

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        System.out.println("🛕 Thai Buddhist Calendar:");
        ThaiBuddhistDate thaiDate = ThaiBuddhistDate.from(fromMillis);
        DateTimeFormatter thaiFormatter = DateTimeFormatter.ofPattern("dd MMMM G yyyy", new Locale("th", "TH"));
        System.out.println("🇹🇭 Formatted: " + thaiFormatter.format(thaiDate));

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        System.out.println("🧪 FormatStyle Combinations:");
        Locale locale = Locale.getDefault(); // ✅ Fixed locale declaration
        FormatStyle[] styles = FormatStyle.values();
        for (FormatStyle dateStyle : styles) {
            for (FormatStyle timeStyle : styles) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter
                            .ofLocalizedDateTime(dateStyle, timeStyle)
                            .withLocale(locale);
                    System.out.printf("🖋️ [Date: %-6s | Time: %-6s] → %s\n", dateStyle, timeStyle, dtf.format(fromMillis));
                } catch (Exception ignored) {
                }
            }
        }

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        System.out.println("🖌️ Individual FormatStyles:");
        for (FormatStyle style : styles) {
            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(style).withLocale(locale);
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(style).withLocale(locale);
                System.out.printf("📆 Date (%-6s): %s\n", style, dateFormatter.format(fromMillis));
                System.out.printf("⏰ Time (%-6s): %s\n\n", style, timeFormatter.format(fromMillis));
            } catch (Exception ignored) {
            }
        }

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        System.out.println("📊 Benchmark Summary:");
        long millisEnd = System.currentTimeMillis();
        long nanoEnd = System.nanoTime();
        System.out.println("🕒 Total elapsed via System.currentTimeMillis(): " + (millisEnd - millisStart) + " ms");
        System.out.println("⏱️ Total elapsed via System.nanoTime()       : " + (nanoEnd - nanoStart) + " ns");

        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR + "\n");
        /*

         ******************************************************
         */
        execution.executionWindDown();
    }

}