package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.demo;

import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.controller.CUIModeOrchestrator;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.common.constants.DateTimeUtilLIbConstants;

import java.time.*;
import java.util.*;

public class DateTimeCarnival {



    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

        /*System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        System.out.println("🪔  WELCOME TO DATE-TIME CARNIVAL — DIWALI EDITION 🪔");
        System.out.println("🌏  A FESTIVAL OF FORMATS · CELEBRATING CULTURES IN CODE  🎆");
        System.out.println("✨  Java Locale Magic · Traditional Calendars · Currency Flair ✨");
        System.out.println("🎉  Curated by Hemant, The Formatter Maestro 🧵");
        System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟\n");*/

        System.out.println(DateTimeUtilLIbConstants.CARNIVALDEMOBANNER);

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
        System.out.println("🧃 MINIMAL FORMAT DEMO");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        Locale locale = Locale.getDefault();
        String formatted = DTFormatterUtils.safeFormat(now, "dd MMM yyyy HH:mm:ss z", locale);
        System.out.printf("🌍 [%s] → %s\n", locale.getDisplayName(), formatted);
    }

    public static void runLanguageDemo() {
        System.out.println("🗣️ LANGUAGE DEMO — Indian Regional Showcase");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        for (Locale locale : LocaleLibrary.getIndianRegionalLocales()) {
            System.out.printf("🔸 Locale: %s\n", locale.getDisplayName(locale));
            for (String pattern : PatternLibrary.getIndianPatterns()) {
                String result = DTFormatterUtils.safeFormat(indiaTime, pattern, locale);
                System.out.printf("📍 %-25s → %s\n", pattern, result);
            }
            System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }

    public static void runVedicShowcase() {
        System.out.println("🕉️ VEDIC MODE — (Placeholder)");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        System.out.println("📅 Traditional Indian calendar formatting to be implemented...");
    }

    public static void runCurrencyAndNumbers() {
        System.out.println("💱 CURRENCY & NUMBER FORMATTING DEMO");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        double sample = 1234567.89;
        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            System.out.printf("🌐 %s\n", locale.getDisplayName());
            System.out.println("💰 Currency: " + NumberUtils.formatCurrency(sample, locale));
            System.out.println("🔢 Number  : " + NumberUtils.formatNumber(sample, locale));
            System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }

    public static void runTraditionalCalendars() {
        System.out.println("🗓️ TRADITIONAL CALENDARS — Japan & Thailand");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        ZonedDateTime now = ZonedDateTime.now();
        JapaneseDate japaneseDate = JapaneseDate.from(now);
        ThaiBuddhistDate thaiDate = ThaiBuddhistDate.from(now);

        String japanFmt = DTFormatterUtils.safeFormat(now, "GGGG yyyy/MM/dd", Locale.JAPAN);
        String thaiFmt = DTFormatterUtils.safeFormat(now, "dd MMMM G yyyy", Locale.of("th", "TH"));

        System.out.println("🗾 Japanese: " + japanFmt);
        System.out.println("🇹🇭 Thai Buddhist: " + thaiFmt);
    }

    public static void runPatternFiesta() {
        System.out.println("🎨 PATTERN FIESTA — Global Formatting");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
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
            System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
    }

    public static void runFormatStyleCombos() {
        System.out.println("🖋️ FORMAT STYLE COMBINATIONS");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
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
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
    }*/
}