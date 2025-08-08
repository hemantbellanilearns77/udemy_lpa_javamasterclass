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

}

