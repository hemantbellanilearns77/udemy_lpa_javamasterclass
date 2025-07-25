package com.hb.study.misc_utils.libs.datetimeutillib.core;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by : heman on 14-07-2025, 06:38 pm, in the "udemy_lpa_javamasterclass" project
 **/

public class PatternLibrary {

    public static String[] getIndianPatterns() {
        return new String[] {
                "dd/MM/yyyy",
                "dd MMMM yyyy",
                "EEEE, dd MMMM yyyy",
                "hh:mm a",
                "HH:mm:ss z",
                "dd MMMM yyyy, EEEE"
        };
    }

    public static String[] getGlobalPatterns() {
        return new String[] {
                "dd.MM.yyyy", "dd/MM/yyyy", "dd MMMM yyyy", "EEEE, dd MMMM yyyy",
                "yyyy-MM-dd", "MM/dd/yyyy", "MMMM dd, yyyy", "EEE, MMM dd, yyyy hh:mm a",
                "MM-dd-yyyy hh:mm:ss a", "dd-MM-yyyy", "dd MMM yyyy", "yyyy/MM/dd",
                "yyyy年MM月dd日", "yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy"
        };
    }
    public static void runIndianPatterns() {
        System.out.println("🗣️ LANGUAGE DEMO — Indian Regional Showcase");
        System.out.println(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        for (Locale locale : LocaleLibrary.getIndianRegionalLocales()) {
            System.out.printf("🔸 Locale: %s\n", locale.getDisplayName(locale) + "\n");
            for (String pattern : getIndianPatterns()) {
                String result = DTFormatterUtils.safeFormat(indiaTime, pattern, locale);
                System.out.printf("📍 %-25s → %s\n", pattern, result);
                FormatterExportUtil.logEntry("LangDemo:" + pattern, locale.toString(), result);
            }
            System.out.println(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        }
    }

    public static void runGlobalPatterns() {
        System.out.println("🎨 GLOBAL PATTERN SHOWCASE");
        System.out.println(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
        ZonedDateTime now = ZonedDateTime.now();

        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            for (String pattern : getGlobalPatterns()) {
                for (ZoneId zone : ZoneLibrary.getGlobalZones()) {
                    ZonedDateTime zoned = now.withZoneSameInstant(zone);
                    String result = DTFormatterUtils.safeFormat(zoned, pattern, locale);
                    System.out.printf("🌐 [%s] (%s/%s) → %s\n", pattern, zone.getId(), locale.toString(), result);
                    FormatterExportUtil.logEntry("GlobalPattern:" + pattern, locale.toString(), result);
                }
            }
        }
    }
}
