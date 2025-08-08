package com.hb.study.libs.datetimeutillib.demo;

import com.hb.study.libs.datetimeutillib.controller.CUIModeOrchestrator;
import com.hb.study.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.libs.datetimeutillib.common.constants.DateTimeUtilLIbConstants;

import java.time.*;
import java.util.*;

public class DateTimeCarnival {



    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

        /*ConsoleStyler.styleOutput("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        ConsoleStyler.styleOutput("🪔  WELCOME TO DATE-TIME CARNIVAL — DIWALI EDITION 🪔");
        ConsoleStyler.styleOutput("🌏  A FESTIVAL OF FORMATS · CELEBRATING CULTURES IN CODE  🎆");
        ConsoleStyler.styleOutput("✨  Java Locale Magic · Traditional Calendars · Currency Flair ✨");
        ConsoleStyler.styleOutput("🎉  Curated by Hemant, The Formatter Maestro 🧵");
        ConsoleStyler.styleOutput("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟\n");*/

        ConsoleStyler.styleOutput(DateTimeUtilLIbConstants.CARNIVALDEMOBANNER);

        Locale defaultLocale = Locale.getDefault();
        ZoneId defaultZone = ZoneId.systemDefault();

        for (FormatterMode mode : FormatterMode.values()) {
            CUIModeOrchestrator.runMode(mode, defaultLocale, defaultZone, null);
        }


        execution.finalizeExecution();
    }

   /* public static void runFullCarnivalBlast() {
        runMinimalFormat();
        runLanguageDemo();
        runVedicShowcase();
        runCurrencyAndNumbers();
        runTraditionalCalendars();
        runPatternFiesta();
        runFormatStyleCombos();
    }*/

   /* public static void runMinimalFormat() {
        ConsoleStyler.styleOutput("🧃 MINIMAL FORMAT DEMO");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        Locale locale = Locale.getDefault();
        String formatted = DTFormatterUtils.safeFormat(now, "dd MMM yyyy HH:mm:ss z", locale);
        System.out.printf("🌍 [%s] → %s\n", locale.getDisplayName(), formatted);
    }

    public static void runLanguageDemo() {
        ConsoleStyler.styleOutput("🗣️ LANGUAGE DEMO — Indian Regional Showcase");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        for (Locale locale : LocaleLibrary.getIndianRegionalLocales()) {
            System.out.printf("🔸 Locale: %s\n", locale.getDisplayName(locale));
            for (String pattern : PatternLibrary.getIndianPatterns()) {
                String result = DTFormatterUtils.safeFormat(indiaTime, pattern, locale);
                System.out.printf("📍 %-25s → %s\n", pattern, result);
            }
            ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }

    public static void runVedicShowcase() {
        ConsoleStyler.styleOutput("🕉️ VEDIC MODE — (Placeholder)");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ConsoleStyler.styleOutput("📅 Traditional Indian calendar formatting to be implemented...");
    }

    public static void runCurrencyAndNumbers() {
        ConsoleStyler.styleOutput("💱 CURRENCY & NUMBER FORMATTING DEMO");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        double sample = 1234567.89;
        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            System.out.printf("🌐 %s\n", locale.getDisplayName());
            ConsoleStyler.styleOutput("💰 Currency: " + NumberUtils.formatCurrency(sample, locale));
            ConsoleStyler.styleOutput("🔢 Number  : " + NumberUtils.formatNumber(sample, locale));
            ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }

    public static void runTraditionalCalendars() {
        ConsoleStyler.styleOutput("🗓️ TRADITIONAL CALENDARS — Japan & Thailand");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        JapaneseDate japaneseDate = JapaneseDate.from(now);
        ThaiBuddhistDate thaiDate = ThaiBuddhistDate.from(now);

        String japanFmt = DTFormatterUtils.safeFormat(now, "GGGG yyyy/MM/dd", Locale.JAPAN);
        String thaiFmt = DTFormatterUtils.safeFormat(now, "dd MMMM G yyyy", Locale.of("th", "TH"));

        ConsoleStyler.styleOutput("🗾 Japanese: " + japanFmt);
        ConsoleStyler.styleOutput("🇹🇭 Thai Buddhist: " + thaiFmt);
    }

    public static void runPatternFiesta() {
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
    }

    public static void runFormatStyleCombos() {
        ConsoleStyler.styleOutput("🖋️ FORMAT STYLE COMBINATIONS");
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        Locale locale = Locale.getDefault();
        for (FormatStyle dateStyle : FormatStyle.values()) {
            for (FormatStyle timeStyle : FormatStyle.values()) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(dateStyle, timeStyle).withLocale(locale);
                    System.out.printf("🧪 [%s/%s] → %s\n", dateStyle, timeStyle, dtf.format(now));
                } catch (Exception ignored) {}
            }
        }
        ConsoleStyler.styleOutput(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
    }*/
}