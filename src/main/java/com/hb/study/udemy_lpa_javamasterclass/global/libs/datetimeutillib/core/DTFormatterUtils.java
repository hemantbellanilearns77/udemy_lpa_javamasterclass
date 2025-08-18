package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core;

/**
 * created by : heman on 14-07-2025, 06:29 pm, in the "udemy_lpa_javamasterclass" project
 **/

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DTFormatterUtils {
    private DTFormatterUtils() {
    }

    public static String safeFormat(ZonedDateTime dateTime, String pattern, Locale locale) {
        try {
            return DateTimeFormatter.ofPattern(pattern, locale).format(dateTime);
        } catch (Exception _) {
            return "[⚠️ Format error: " + pattern + "]";
        }
    }

}

