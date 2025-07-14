package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib;

/**
 * created by : heman on 14-07-2025, 06:29 pm, in the "udemy_lpa_javamasterclass" project
 **/

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.libs.ui.FormatterLogBuffer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
        System.out.println("🧃 MINIMAL FORMAT DEMO");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");

        ZonedDateTime now = ZonedDateTime.now(zone);
        String result = safeFormat(now, "dd MMM yyyy HH:mm:ss z", locale);
        System.out.printf("🌍 [%s | %s] → %s\n", locale.getDisplayName(), zone.getId(), result);
        FormatterLogBuffer.append("🧃 Minimal Format → " + result);
    }


    public static void runFormatStyleCombos(Locale locale, ZoneId zone) {
        System.out.println("🖋️ FORMAT STYLE COMBINATIONS");
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");

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

}

