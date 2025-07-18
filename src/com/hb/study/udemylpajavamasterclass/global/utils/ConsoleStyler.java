package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by : heman on 16-07-2025, 01:09 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class ConsoleStyler {

   // Prints a bannered header
   public static void printBanner(String title) {
       System.out.println(CommonConstants.SECTION_SEPARATOR);
       System.out.println("📌 " + title.toUpperCase());
       System.out.println(CommonConstants.SECTION_SEPARATOR);
   }
    public static void startSection(String label) {
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println("🔷 START: " + label.toUpperCase());
        System.out.println(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        System.out.println(CommonConstants.DOTTED_LINE);
        System.out.println("🏁 END: " + label.toUpperCase());
        System.out.println(CommonConstants.SECTION_SEPARATOR);
    }

    public static void divider() {
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
    }

    public static void styleIt(String styleStr) {
        System.out.println(styleStr);
    }

    public static void styleEach(String labelPrefix, List<String> items) {
        if (items == null || items.isEmpty()) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }

        AtomicInteger counter = new AtomicInteger(1);
        System.out.println(CommonConstants.DOTTED_LINE);
        items.forEach(item -> {
            System.out.printf(CommonConstants.INDENT + "%s [%d] %-12s%n",
                    labelPrefix, counter.getAndIncrement(), item);
        });
        System.out.println(CommonConstants.DOTTED_LINE);
    }
    public static void styleIt(String outputText, boolean showLineNumbers, boolean enableColor) {
        if (outputText == null || outputText.isBlank()) {
            System.out.println(CommonConstants.INDENT + "⚠️ [No output to display]");
            return;
        }

        String[] lines = outputText.split("\\R"); // Handles all newline types

        // Optional ANSI coloring
        String borderColor = enableColor ? "\u001B[35m" : ""; // Magenta
        String resetColor = enableColor ? "\u001B[0m" : "";

        System.out.println(CommonConstants.INDENT + borderColor + "┌────────────────────────────────────────────────────" + resetColor);

        for (int i = 0; i < lines.length; i++) {
            String linePrefix = showLineNumbers ? String.format("[%02d] ", i + 1) : "» ";
            System.out.println(CommonConstants.INDENT + borderColor + "│ " + resetColor + linePrefix + lines[i]);
        }

        System.out.println(CommonConstants.INDENT + borderColor + "└────────────────────────────────────────────────────" + resetColor);
    }
}
