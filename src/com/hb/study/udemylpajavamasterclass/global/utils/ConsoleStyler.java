package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * created by : heman on 16-07-2025, 01:09 pm, in the "udemy_lpa_javamasterclass" project
 **/

public class ConsoleStyler {

    // Prints a bannered header
    public static void printBanner(String title) {
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println("📌 " + (CommonConstants.BOLD + CommonConstants.GREEN +  title.toUpperCase() + CommonConstants.RESET));
        System.out.println(CommonConstants.SECTION_SEPARATOR);
    }

    public static void startSection(String label) {
        ConsoleStyler.divider();
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println("🔷 START: " + CommonConstants.CYAN + CommonConstants.UNDERLINE + label.toUpperCase() + CommonConstants.RESET );
        System.out.println(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        System.out.println(CommonConstants.DOTTED_LINE);
        System.out.println("🏁 END: " + CommonConstants.CYAN + CommonConstants.UNDERLINE + label.toUpperCase() + CommonConstants.RESET );
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        ConsoleStyler.divider();
    }

    public static void startSubSection(String outputText) {
        styleIt(outputText.toUpperCase(), (CommonConstants.BOLD + CommonConstants.ITALIC + CommonConstants.BLUE),
                false, true,false);

    }
    public static void divider() {
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
    }

    public static void halfDivider() {
        System.out.println(CommonConstants.INDENT + CommonConstants.YELLOW + CommonConstants.ASTERISKSEPERATORLINESTRHALF + CommonConstants.RESET);
    }
    public static void styleInfo(String outputText) {
        styleIt(outputText,(CommonConstants.ITALIC + CommonConstants.RED), false, true, false);
    }
    public static void styleIt(String outputText, String textFormatting, boolean allFlags) {
        styleIt(outputText,textFormatting, allFlags, allFlags, allFlags);
    }
    public static void styleIt(String outputText, String textFormatting) {
        styleIt(outputText,textFormatting, false);
    }
    public static void styleIt(String outputText, boolean allFlags) {
        styleIt(outputText,null, allFlags, allFlags, allFlags);
    }
    public static void styleIt(String outputText) {
        styleIt(outputText, null, false, false, false);
    }
    public static void styleIt(String outputText, String textFormatting, boolean showLineNumbers, boolean enableBorderColor, boolean showlinePrefix) {
        if (outputText == null || outputText.isBlank()) {
            System.out.println(CommonConstants.INDENT + "⚠️ [No output to display]");
            return;
        }
        if(textFormatting == null || textFormatting.isBlank() || textFormatting.isEmpty()) {
            textFormatting = "";
        }
        String[] lines = outputText.split("\\R"); // Handles all newline types

        // Optional ANSI coloring
        String borderColor = enableBorderColor ? CommonConstants.MAGENTA : ""; // Magenta
        String resetColor = enableBorderColor ? CommonConstants.RESET : "";

        System.out.println(CommonConstants.INDENT + borderColor + "┌────────────────────────────────────────────────────" + resetColor);
        for (int lineCounter = 0; lineCounter < lines.length; lineCounter++) {
            String linePrefix = showLineNumbers ? String.format("%s[%02d]%s", textFormatting, (lineCounter + 1), CommonConstants.RESET) :
                    String.format("%s%s",textFormatting,showlinePrefix ? ("» "): "");
            System.out.println(CommonConstants.INDENT + borderColor + "│ " + resetColor + linePrefix + (textFormatting + lines[lineCounter]) + CommonConstants.RESET);
        }

        System.out.println(CommonConstants.INDENT + borderColor + "└────────────────────────────────────────────────────" + resetColor);
    }


    // Overloaded wrapper with defaults applied
    public static void styleEach(String labelPrefix, Object input, boolean allFlags) {
        styleEach(labelPrefix, input, allFlags, allFlags, allFlags);
    }

    // Overloaded wrapper to just show line numbers, no uppercase, no sorting
    public static void styleEachAsIs(String labelPrefix, Object input) {
        styleEach(labelPrefix, input, false);
    }
    public static void styleEach(String labelPrefix, Object input, boolean sort, boolean formatNumbers, boolean uppercaseStrings) {
        if (input == null) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }

        final List<Object> items = new ArrayList<>();
        boolean isTupleMode = false;
        int tupleSize = -1;

        // 🔍 Type Normalization
        if (input instanceof double[]) {
            final double[] arr = (double[]) input;
            tupleSize = arr.length;
            for (double val : arr) items.add(val);
            isTupleMode = true;
        } else if (input instanceof double[][]) {
            final double[][] array2D = (double[][]) input;
            tupleSize = array2D[0].length;
            for (final double[] tuple : array2D) {
                for (final double val : tuple) items.add(val);
            }
            isTupleMode = true;
        } else if (input instanceof double[][][]) {
            final double[][][] array3D = (double[][][]) input;
            tupleSize = array3D[0][0].length;
            for (final double[][] group : array3D) {
                for (final double[] tuple : group) {
                    for (final double val : tuple) items.add(val);
                }
            }
            isTupleMode = true;
        }

        // 🧠 Other primitive types
        else if (input instanceof int[]) {
            final int[] arr = (int[]) input;
            for (final int val : arr) items.add(val);
        } else if (input instanceof long[]) {
            final long[] arr = (long[]) input;
            for (final long val : arr) items.add(val);
        } else if (input instanceof boolean[]) {
            final boolean[] arr = (boolean[]) input;
            for (final boolean val : arr) items.add(val);
        } else if (input instanceof char[]) {
            final char[] arr = (char[]) input;
            for (final char val : arr) items.add(val);
        }

        // 🧠 Containers
        else if (input instanceof Object[]) {
            items.addAll(Arrays.asList((Object[]) input));
        } else if (input instanceof List<?>) {
            final List<?> list = (List<?>) input;
            if (!list.isEmpty() && list.get(0) instanceof double[]) {
                isTupleMode = true;
                tupleSize = ((double[]) list.get(0)).length;
                for (final Object o : list) {
                    for (final double v : (double[]) o) items.add(v);
                }
            } else if (!list.isEmpty() && list.get(0) instanceof Object[]) {
                isTupleMode = true;
                tupleSize = ((Object[]) list.get(0)).length;
                for (final Object o : list) {
                    items.addAll(Arrays.asList((Object[]) o));
                }
            } else {
                items.addAll(list);
            }
        } else if (input instanceof Set<?>) {
            items.addAll((Set<?>) input);
        } else if (input instanceof Stream<?>) {
            ((Stream<?>) input).forEach(items::add);
        } else {
            System.out.println(CommonConstants.INDENT + "⚠️ Unsupported input type: " + input.getClass().getSimpleName());
            return;
        }

        // 💎 Format pass
        final List<Object> formattedItems = items.stream()
                .map(obj -> {
                    if (obj == null) return "null";
                    if (formatNumbers && obj instanceof Number) return String.format("%12s", obj);
                    if (uppercaseStrings && obj instanceof String) return ((String) obj).toUpperCase();
                    return obj;
                })
                .collect(Collectors.toList());

        // 🔍 Sorting
        if (sort) {
            try {
                Collections.sort((List) formattedItems);
            } catch (ClassCastException e) {
                System.out.println(CommonConstants.INDENT + "⚠️ Sorting skipped: non-comparable items");
            }
        }

        // 🚫 Empty check
        if (formattedItems.isEmpty()) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }

        // 🎨 Styled Output
        //System.out.println(CommonConstants.DOTTED_LINE);
        final AtomicInteger counter = new AtomicInteger(0);


        for (int i = 0; i < formattedItems.size(); i += (isTupleMode ? tupleSize : 1)) {
            final int tupleStart = i;
            if (isTupleMode && i + tupleSize <= formattedItems.size()) {
                final String tuple = IntStream.range(0, tupleSize)
                        .mapToObj(j -> formattedItems.get(tupleStart + j).toString())
                        .collect(Collectors.joining(", "));
                System.out.printf(CommonConstants.INDENT + "%s [%d] → (%s)%n", labelPrefix, counter.getAndIncrement(), tuple);
            } else {
                System.out.printf(CommonConstants.INDENT + "%s [%d] %s%n", labelPrefix, counter.getAndIncrement(), formattedItems.get(i));
            }
        }

        //System.out.println(CommonConstants.DOTTED_LINE);
    }
}
