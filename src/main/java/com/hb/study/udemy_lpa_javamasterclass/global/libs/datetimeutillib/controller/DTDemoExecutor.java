package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.controller;

import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.DTFormatterUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.LocaleLibrary;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.NumberUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.PatternLibrary;
import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * created by : heman on 08-08-2025, 01:52 pm, in the "run-pmd.bat" project
 **/
public class DTDemoExecutor {
    private DTDemoExecutor() {

    }
    // Add below existing methods
    public static void runMinimalDemo(Locale locale, ZoneId zone) {
        ConsoleStyler.styleOutput("🧃 MINIMAL FORMAT DEMO");
        ConsoleStyler.divider();
        ZonedDateTime now = ZonedDateTime.now(zone);
        String result = DTFormatterUtils.safeFormat(now, "dd MMM yyyy HH:mm:ss z", locale);
        ConsoleStyler.styleOutput( "🌍 [%s | %s] → %s".formatted(locale.getDisplayName(), zone.getId(), result) );
    }

    public static void runFormatStyleCombos(Locale locale, ZoneId zone) {
        ConsoleStyler.styleOutput("🖋️ FORMAT STYLE COMBINATIONS");
        ConsoleStyler.divider();
        ZonedDateTime now = ZonedDateTime.now(zone);
        for (FormatStyle dateStyle : FormatStyle.values()) {
            for (FormatStyle timeStyle : FormatStyle.values()) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(dateStyle, timeStyle)
                            .withLocale(locale);
                    String result = dtf.format(now);
                    ConsoleStyler.styleOutput( "🧪 [%s/%s] → %s".formatted(dateStyle,timeStyle,result) );
                } catch(DateTimeException dateTimeException) {
                    ConsoleStyler.styleError("DateTimeException : " + dateTimeException.getMessage());
                }
            }
        }
    }


    public static void runIndianPatternsShowcase() {
        PatternLibrary.runIndianPatterns();
    }
    public static void runVedicShowcase() {
        ConsoleStyler.styleOutput("🕉️ VEDIC MODE — (Coming Soon - Placeholder)");
        ConsoleStyler.styleOutput("📅 Traditional Indian calendar formatting to be implemented...");
        ConsoleStyler.styleOutput("📅 Lunar calendars · Vikram Samvat · Shaka Samvat · Panchang Exploration");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.NEWLINE);
    }

    public static void runCurrencyAndNumbers() {
        ConsoleStyler.styleOutput("💱 CURRENCY & NUMBER FORMATTING DEMO");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.NEWLINE);
        double sample = 1234567.89;
        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            ConsoleStyler.styleOutput("🌐 %s".formatted(locale.getDisplayName()));
            ConsoleStyler.styleOutput("💰 Currency: " + NumberUtils.formatCurrency(sample, locale));
            ConsoleStyler.styleOutput("🔢 Number  : " + NumberUtils.formatNumber(sample, locale));
            ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.NEWLINE);
        }
    }

    public static void runTraditionalCalendars() {
        ConsoleStyler.styleOutput("🗓️ TRADITIONAL CALENDARS — Japan & Thailand");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.NEWLINE);
        ZonedDateTime now = ZonedDateTime.now();

        String japanFmt = DTFormatterUtils.safeFormat(now, "GGGG yyyy/MM/dd", Locale.JAPAN);
        String thaiFmt = DTFormatterUtils.safeFormat(now, "dd MMMM G yyyy", Locale.of("th", "TH"));

        ConsoleStyler.styleOutput("🗾 Japanese: " + japanFmt);
        ConsoleStyler.styleOutput("🇹🇭 Thai Buddhist: " + thaiFmt);
    }

    public static void runPatternFiesta() {
        ConsoleStyler.styleOutput("🎨 PATTERN FIESTA — Demo of a lot of Pattern variations ");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.NEWLINE);
        PatternLibrary.runIndianPatterns();
        PatternLibrary.runGlobalPatterns();
    }

    public static void runGlobalPatternsShowcase() {
        PatternLibrary.runGlobalPatterns();
    }
}
