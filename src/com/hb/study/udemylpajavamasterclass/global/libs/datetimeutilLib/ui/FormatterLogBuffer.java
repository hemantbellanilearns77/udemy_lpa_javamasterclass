package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib.ui;

/**
 * created by : heman on 14-07-2025, 08:50 pm, in the "udemy_lpa_javamasterclass" project
 **/


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
        System.out.println("\n📘 Markdown Export:\n");
        for (String line : lines) {
            System.out.println("- " + line);
        }
    }
}