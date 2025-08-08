package com.hb.study.libs.datetimeutillib.core;

/**
 * created by : heman on 14-07-2025, 06:29 pm, in the "udemy_lpa_javamasterclass" project
 **/

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.libs.datetimeutillib.ui.FormatterLogBuffer;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DTFormatterUtils {
    public static String safeFormat(ZonedDateTime dateTime, String pattern, Locale locale) {
        try {
            return DateTimeFormatter.ofPattern(pattern, locale).format(dateTime);
        } catch (Exception e) {
            return "[⚠️ Format error: " + pattern + "]";
        }
    }
    // Add below existing methods
    public static void runMinimalDemo(Locale locale, ZoneId zone) {
        ConsoleStyler.styleOutput("🧃 MINIMAL FORMAT DEMO");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");

        ZonedDateTime now = ZonedDateTime.now(zone);
        String result = safeFormat(now, "dd MMM yyyy HH:mm:ss z", locale);
        System.out.printf("🌍 [%s | %s] → %s\n", locale.getDisplayName(), zone.getId(), result);
        FormatterLogBuffer.append("🧃 Minimal Format → " + result);
    }


    public static void runFormatStyleCombos(Locale locale, ZoneId zone) {
        ConsoleStyler.styleOutput("🖋️ FORMAT STYLE COMBINATIONS");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");

        ZonedDateTime now = ZonedDateTime.now(zone);
        for (FormatStyle dateStyle : FormatStyle.values()) {
            for (FormatStyle timeStyle : FormatStyle.values()) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(dateStyle, timeStyle)
                            .withLocale(locale);
                    String result = dtf.format(now);
                    System.out.printf("🧪 [%s/%s] → %s\n", dateStyle, timeStyle, result);
                    FormatterLogBuffer.append("🧪 " + dateStyle + "/" + timeStyle + " → " + result);
                } catch (Exception ignored) {}
            }
        }
    }


    public static void runIndianPatternsShowcase() {
        PatternLibrary.runIndianPatterns();
       /* ConsoleStyler.styleOutput("🗣️ LANGUAGE DEMO — Indian Regional Showcase");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        for (Locale locale : LocaleLibrary.getIndianRegionalLocales()) {
            System.out.printf("🔸 Locale: %s\n", locale.getDisplayName(locale));
            for (String pattern : PatternLibrary.getIndianPatterns()) {
                String result = DTFormatterUtils.safeFormat(indiaTime, pattern, locale);
                System.out.printf("📍 %-25s → %s\n", pattern, result);
            }
            ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }*/
    }

    public static void runVedicShowcase() {
        ConsoleStyler.styleOutput("🕉️ VEDIC MODE — (Coming Soon - Placeholder)");
        ConsoleStyler.styleOutput("📅 Traditional Indian calendar formatting to be implemented...");
        ConsoleStyler.styleOutput("📅 Lunar calendars · Vikram Samvat · Shaka Samvat · Panchang Exploration");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
    }

    public static void runCurrencyAndNumbers() {
        ConsoleStyler.styleOutput("💱 CURRENCY & NUMBER FORMATTING DEMO");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        double sample = 1234567.89;
        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            System.out.printf("🌐 %s\n", locale.getDisplayName());
            ConsoleStyler.styleOutput("💰 Currency: " + NumberUtils.formatCurrency(sample, locale));
            ConsoleStyler.styleOutput("🔢 Number  : " + NumberUtils.formatNumber(sample, locale));
            ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        }
    }

    public static void runTraditionalCalendars() {
        ConsoleStyler.styleOutput("🗓️ TRADITIONAL CALENDARS — Japan & Thailand");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        JapaneseDate japaneseDate = JapaneseDate.from(now);
        ThaiBuddhistDate thaiDate = ThaiBuddhistDate.from(now);

        String japanFmt = DTFormatterUtils.safeFormat(now, "GGGG yyyy/MM/dd", Locale.JAPAN);
        String thaiFmt = DTFormatterUtils.safeFormat(now, "dd MMMM G yyyy", Locale.of("th", "TH"));

        ConsoleStyler.styleOutput("🗾 Japanese: " + japanFmt);
        ConsoleStyler.styleOutput("🇹🇭 Thai Buddhist: " + thaiFmt);
    }

    /*public static void runPatternFiesta() {
        ConsoleStyler.styleOutput("🎨 PATTERN FIESTA — Global Formatting");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            System.out.printf("🔸 Locale: %s\n", locale.getDisplayName());
            for (String pattern : PatternLibrary.getGlobalPatterns()) {
                for (ZoneId zone : ZoneLibrary.getGlobalZones()) {
                    ZonedDateTime zoned = now.withZoneSameInstant(zone);
                    String result = DTFormatterUtils.safeFormat(zoned, pattern, locale);
                    System.out.printf("📍 [%s] %s → %s\n", pattern, zone.getId(), result);
                }
            }
            ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }*/
    public static void runPatternFiesta() {
        ConsoleStyler.styleOutput("🎨 PATTERN FIESTA — Demo of a lot of Pattern variations ");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        PatternLibrary.runIndianPatterns();
        PatternLibrary.runGlobalPatterns();
    }

    public static void runGlobalPatternsShowcase() {
        PatternLibrary.runGlobalPatterns();
    }
}

