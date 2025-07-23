package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.core;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import java.util.*;
/**
 * created by : heman on 14-07-2025, 08:36 pm, in the "udemy_lpa_javamasterclass" project
 **/


public class FormatterExportUtil {

    private static final List<String> log = new ArrayList<>();

    public static void logEntry(String demoName, String locale, String output) {
        log.add(String.format("🔹 %s [%s] → %s", demoName, locale, output));
    }

    public static void logSeparator() {
        log.add("\n" + CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");
    }

    public static void exportMarkdown(String filename) {
        System.out.println("\n📝 EXPORT LOG — MARKDOWN STYLE");
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}