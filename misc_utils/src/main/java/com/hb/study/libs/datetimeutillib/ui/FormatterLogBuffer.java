package com.hb.study.libs.datetimeutillib.ui;

/**
 * created by : heman on 14-07-2025, 08:50 pm, in the "udemy_lpa_javamasterclass" project
 **/


import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

public class FormatterLogBuffer {

    private static final List<String> lines = new ArrayList<>();

    public static void append(String text) {
        lines.add(text);
    }

    public static String getLog() {
        return String.join("\n", lines);
    }

    public static void clear() {
        lines.clear();
    }

    public static void exportMarkdown() {
        ConsoleStyler.styleOutput("\n📘 Markdown Export:\n");
        for (String line : lines) {
            ConsoleStyler.styleOutput("- " + line);
        }
    }
}