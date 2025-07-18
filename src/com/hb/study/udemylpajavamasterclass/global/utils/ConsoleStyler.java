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
        System.out.println(CommonConstants.DOTTED_LINE);
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

        System.out.println(CommonConstants.DOTTED_LINE);
    }
    /*public static void styleEach(String labelPrefix, Object input, boolean sort, boolean formatNumbers, boolean uppercaseStrings) {
        if (input == null) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }

        Stream<?> stream;

        // 🧠 Patch for primitive arrays
        if (input instanceof double[]) {
            stream = Arrays.stream((double[]) input).boxed();
        } else if (input instanceof int[]) {
            stream = Arrays.stream((int[]) input).boxed();
        } else if (input instanceof long[]) {
            stream = Arrays.stream((long[]) input).boxed();
        } else if (input instanceof boolean[]) {
            stream = IntStream.range(0, ((boolean[]) input).length)
                    .mapToObj(i -> ((boolean[]) input)[i]);
        } else if (input instanceof char[]) {
            stream = IntStream.range(0, ((char[]) input).length)
                    .mapToObj(i -> ((char[]) input)[i]);
        }

        // 🧠 Standard containers
        else if (input instanceof Object[]) {
            stream = Arrays.stream((Object[]) input);
        } else if (input instanceof List<?>) {
            List<?> list = (List<?>) input;
            if (!list.isEmpty() && list.get(0) instanceof double[]) {
                stream = list.stream().flatMap(arr -> Arrays.stream((double[]) arr).boxed());
            } else if (!list.isEmpty() && list.get(0) instanceof Object[]) {
                stream = list.stream().flatMap(arr -> Arrays.stream((Object[]) arr));
            } else {
                stream = list.stream();
            }
        } else if (input instanceof Set<?>) {
            stream = ((Set<?>) input).stream();
        } else if (input instanceof Stream<?>) {
            stream = (Stream<?>) input;
        } else {
            System.out.println(CommonConstants.INDENT + "⚠️ Unsupported input type: " + input.getClass().getSimpleName());
            return;
        }

        // 🪄 Format coordinates if input was clearly a List of arrays
        boolean isCoordinateMode =
                input instanceof List<?> && !((List<?>) input).isEmpty() &&
                        (((List<?>) input).get(0) instanceof double[] || ((List<?>) input).get(0) instanceof Object[]);

        List<Object> items = stream
                .map(obj -> {
                    if (obj == null) return "null";
                    if (formatNumbers && obj instanceof Number) {
                        return String.format("%12s", obj);
                    }
                    if (uppercaseStrings && obj instanceof String) {
                        return ((String) obj).toUpperCase();
                    }
                    return obj;
                })
                .collect(Collectors.toList());

        if (sort) {
            try {
                Collections.sort((List) items); // unchecked cast for sorting
            } catch (ClassCastException e) {
                System.out.println(CommonConstants.INDENT + "⚠️ Sorting skipped: non-comparable items");
            }
        }

        if (items.isEmpty()) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }

        System.out.println(CommonConstants.DOTTED_LINE);
        AtomicInteger counter = new AtomicInteger(1);

        for (int i = 0; i < items.size(); i += (isCoordinateMode ? 2 : 1)) {
            if (isCoordinateMode && i + 1 < items.size()) {
                System.out.printf(CommonConstants.INDENT + "%s [%d] → (%.4f, %.4f)%n",
                        labelPrefix, counter.getAndIncrement(),
                        Double.parseDouble(items.get(i).toString()),
                        Double.parseDouble(items.get(i + 1).toString()));
            } else {
                System.out.printf(CommonConstants.INDENT + "%s [%d] %s%n",
                        labelPrefix, counter.getAndIncrement(), items.get(i));
            }
        }

        System.out.println(CommonConstants.DOTTED_LINE);
    }*/

    // Overloaded wrapper with defaults applied
    public static void styleEach(String labelPrefix, Object input) {
        styleEach(labelPrefix, input, false, false, false);
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
