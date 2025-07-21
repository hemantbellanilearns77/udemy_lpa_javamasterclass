package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.constants.BackgroundColor;
import com.hb.study.udemylpajavamasterclass.global.constants.ForegroundColor;
import com.hb.study.udemylpajavamasterclass.global.models.SemanticColorRole;
import com.hb.study.udemylpajavamasterclass.global.models.Theme;

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
        System.out.printf( applyStyling(SemanticColorRole.PROGRAM_BANNER,"📌 " + title.toUpperCase() ));
        System.out.println(CommonConstants.SECTION_SEPARATOR);
    }

    public static void startSection(String label) {
        ConsoleStyler.divider();
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println(applyStyling(SemanticColorRole.SECTION_HEADING, "🔷 START: " + label.toUpperCase()));
        System.out.println(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        System.out.println(CommonConstants.DOTTED_LINE);
        System.out.println(applyStyling(SemanticColorRole.SECTION_HEADING, "🏁 END: " + label.toUpperCase()));
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        ConsoleStyler.divider();
    }

    public static void startSubSection(String outputText) {
        styleIt(outputText.toUpperCase(), SemanticColorRole.SUBSECTION_HEADING,
                false, true, false);

    }

    public static void divider() {
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
    }

    public static void halfDivider() {
        System.out.println(CommonConstants.INDENT + ForegroundColor.BRIGHT_YELLOW.getAnsiCode() + CommonConstants.ASTERISKSEPERATORLINESTRHALF + CommonConstants.RESET);
    }

    public static void styleInfo(String outputText) {
        styleIt(outputText, SemanticColorRole.INITIALIZATION_INFO);
    }

    public static void styleIt(String outputText, SemanticColorRole semanticColorRole, boolean allFlags) {
        styleIt(outputText, semanticColorRole, allFlags, allFlags, allFlags);
    }

    public static void styleIt(String outputText, SemanticColorRole semanticColorRole) {
        styleIt(outputText, semanticColorRole, false);
    }

    public static void styleIt(String outputText, boolean allFlags) {
        styleIt(outputText, null, allFlags, allFlags, allFlags);
    }

    public static void styleIt(String outputText) {
        styleIt(outputText, null, false, false, false);
    }

    public static void styleIt(String outputText, SemanticColorRole semannticRole, boolean showLineNumbers, boolean enableBorderColor, boolean showlinePrefix) {
        if (outputText == null || outputText.isBlank()) {
            System.out.println(CommonConstants.INDENT + "⚠️ [No output to display]");
            return;
        }
        if (semannticRole == null || semannticRole.name().isBlank() || semannticRole.name().isEmpty()) {
            semannticRole = SemanticColorRole.PLAIN_OUTPUT;
        }
        String[] lines = outputText.split("\\R"); // Handles all newline types

        // Optional ANSI coloring
        String borderColor = enableBorderColor ? ForegroundColor.BRIGHT_MAGENTA.getAnsiCode() : ""; // Magenta
        String resetColor = enableBorderColor ? CommonConstants.RESET : "";

        System.out.println(CommonConstants.INDENT + borderColor + "┌────────────────────────────────────────────────────" + resetColor);
        for (int lineCounter = 0; lineCounter < lines.length; lineCounter++) {
            String linePrefix = showLineNumbers ? String.format("[%02d]", (lineCounter + 1)) : String.format("%s", showlinePrefix ? ("» ") : "");
            String lineToPrint = linePrefix + lines[lineCounter];
            System.out.println(CommonConstants.INDENT + borderColor + "│ " + resetColor + applyStyling(semannticRole, lineToPrint));
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



        /*
          return switch (role) {
        case ERROR -> new Theme(
            BackgroundColor.BRIGHT_RED, ForegroundColor.BRIGHT_WHITE);

        case WARNING -> new Theme(
            BackgroundColor.WARNING_YELLOW, ForegroundColor.BLACK);

        case SECTION_HEADING -> new Theme(
            BackgroundColor.INDIGO, ForegroundColor.BRIGHT_WHITE);

        case SUBSECTION_HEADING -> new Theme(
            BackgroundColor.SLATE, ForegroundColor.BRIGHT_WHITE);

        case INITIALIZATION_INFO -> new Theme(
            BackgroundColor.SKY_BLUE, ForegroundColor.NAVY);

        case OUTPUT_HEADER -> new Theme(
            BackgroundColor.GOLD, ForegroundColor.BLACK);

        case BENCHMARK_SECTION_HEADER, PROGRAM_BANNER -> new Theme(
            BackgroundColor.SAPPHIRE, ForegroundColor.BRIGHT_WHITE);
    };
         */


    public static String applyStyling(SemanticColorRole role, String text, List<String> customFormattingElements) {
        StringBuilder themedText = new StringBuilder();

        Theme theme = getThemeFor(role, customFormattingElements);
        themedText.append(theme.getCombinedAnsi());
        if (theme.isHavingFormattingELements()) {
            for (String nextFormtString : theme.getFormattingElements()) {
                themedText.append(nextFormtString);
            }
        }
        themedText.append(text).append(CommonConstants.RESET);// Reset code
        return themedText.toString();
    }

    public static String applyStyling(SemanticColorRole role, String text) {
        return applyStyling(role, text, null);
    }
    public static Theme getThemeFor(SemanticColorRole role, List<String> customFormattingElements) {
        return switch (role) {
            case ERROR -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, null);
            case WARNING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BLACK, customFormattingElements);
            case SECTION_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.UNDERLINE));
            case SUBSECTION_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, null);
            case INITIALIZATION_INFO -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_RED, List.of(CommonConstants.BOLD));
            case SUBSECTION_ITALIC_INFO -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.ITALIC));
            case OUTPUT_HEADER -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.WHITE, null);
            case BENCHMARK_SECTION_HEADER -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.SAPPHIRE, null);
            case PROGRAM_BANNER -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_GREEN, null);

            case CUSTOM -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.WHITE,
                    customFormattingElements);
            default -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.NEUTRAL, null);
        };
    }

}
