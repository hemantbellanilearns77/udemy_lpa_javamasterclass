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
        System.out.printf(applyStyling("📌 " + title.toUpperCase(), SemanticColorRole.PROGRAM_BANNER));
        System.out.println(CommonConstants.SECTION_SEPARATOR);
    }

    public static void startSection(String label) {
        ConsoleStyler.divider();
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println(applyStyling("🔷 START: ", null, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD)) +
                applyStyling(label.toUpperCase(), SemanticColorRole.SECTION_HEADING));
        System.out.println(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        System.out.println(CommonConstants.DOTTED_LINE);
        System.out.println(applyStyling("🏁 END: ", null, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD)) +
                applyStyling(label.toUpperCase(), SemanticColorRole.SECTION_HEADING));
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        ConsoleStyler.divider();
    }

    public static void styleIntro(String outputText) {
        styleIt(outputText.toUpperCase(), SemanticColorRole.INTRO_TEXT,
                false, true, false);

    }

    public static void divider() {
        System.out.println(ForegroundColor.MUSTARD.getAnsiCode() + CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.RESET);
    }

    public static void halfDivider() {
        System.out.println(CommonConstants.INDENT + ForegroundColor.MUSTARD.getAnsiCode() + CommonConstants.HALFLINEASTERISKSEPERATOR + CommonConstants.RESET);
    }

    public static void styleInitializationInfo(String outputText) {
        styleIt((CommonConstants.INITIALIZATIONS_INFO + System.lineSeparator() + outputText),
                SemanticColorRole.INITIALIZATION_INFO,false,true,false);
    }

    public static void styleExecutionInsight(String outputText) {
        styleIt(outputText, SemanticColorRole.ITALICIZED_EXECUTION_INSIGHT);
    }

    private static void styleIt(String outputText, SemanticColorRole semanticColorRole) {
        styleIt(outputText, semanticColorRole, false, false, false);
    }

    public static void styleOutput(String outputHeading, String outputText) {
        if (outputHeading != null && !outputHeading.isBlank()) {
            styleIt(outputHeading, SemanticColorRole.OUTPUT_HEADING);
        } if(outputText!= null && !outputText.isBlank()) {
            styleIt(outputText, null);
        }
    }

    public static void styleIt(String outputText, SemanticColorRole semanticRole,  boolean showLineNumbers, boolean enableBorderColor, boolean showlinePrefix) {
        if (outputText == null || outputText.isBlank()) {
            System.out.println(CommonConstants.INDENT + "⚠️ [No output to display]");
            return;
        }

        String[] lines = outputText.split("\\R"); // Handles all newline types

        // Optional ANSI coloring
        String borderColor = enableBorderColor ? ForegroundColor.BRIGHT_MAGENTA.getAnsiCode() : ""; //
        String resetColor = enableBorderColor ? CommonConstants.RESET : "";

        System.out.println(CommonConstants.INDENT + borderColor + "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────" + resetColor);

        //StringBuilder linesToPrint = new StringBuilder();
        for (int lineCounter = 0; lineCounter < lines.length; lineCounter++) {
            String linePrefix = showLineNumbers ? String.format("[%02d]", (lineCounter + 1)) : String.format("%s", showlinePrefix ? ("» ") : "");
            String lineToPrint = linePrefix + lines[lineCounter];
            System.out.println(CommonConstants.INDENT + borderColor + "│ " + resetColor + applyStyling(lineToPrint, semanticRole));
            //linesToPrint.append(CommonConstants.INDENT).append(borderColor).append("│ ").append(resetColor).append(lineToPrint);
        }
        System.out.println(CommonConstants.INDENT + borderColor + "│ ");
        //linesToPrint.append(CommonConstants.INDENT).append(borderColor).append("│ ");
        //System.out.println(applyStyling(linesToPrint.toString(), semanticRole));
        System.out.println(CommonConstants.INDENT + borderColor + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────" + resetColor);
    }

    // Overloaded wrapper to just show line numbers, no uppercase, no sorting
    public static void styleEachAsIs(String labelPrefix, Object input) {
        styleEach(labelPrefix, input, false, false, false);
    }

    public static void styleEach(String labelPrefix, Object input, boolean sort, boolean formatNumbers, boolean uppercaseStrings) {
        if (input == null) {
            System.out.println(CommonConstants.INDENT + "⚠️ No items to display.");
            return;
        }
        labelPrefix = (labelPrefix==null || labelPrefix.isBlank())? "" : (labelPrefix + ": ");
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
        StringBuilder styledOutputBuilder = new StringBuilder();
        final AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < formattedItems.size(); i += (isTupleMode ? tupleSize : 1)) {
            final int tupleStart = i;
            if (isTupleMode && i + tupleSize <= formattedItems.size()) {
                final String tuple = IntStream.range(0, tupleSize)
                        .mapToObj(j -> formattedItems.get(tupleStart + j).toString())
                        .collect(Collectors.joining(", "));
                styledOutputBuilder.append("%s%s [%d] → (%s)%n".formatted(CommonConstants.INDENT, labelPrefix,counter.getAndIncrement(),tuple));
                /*
                    System.out.printf(CommonConstants.INDENT + "%s [%d] → (%s)%n",
                        labelPrefix, counter.getAndIncrement(), tuple);
                        */
            } else {
                styledOutputBuilder.append("%s [%d] %s%s".formatted( labelPrefix,counter.getAndIncrement(),formattedItems.get(i),"\t"));
                //System.out.printf(CommonConstants.INDENT + "%s [%d] %s%n", labelPrefix, counter.getAndIncrement(), formattedItems.get(i));
            }
        }
        ConsoleStyler.styleOutput(null, styledOutputBuilder.toString());
    }

    public static String applyStyling(String text, SemanticColorRole semanticColorRole,
                                      BackgroundColor bgColor, ForegroundColor fgColor, List<String> customFormattingElements) {
        StringBuilder themedText = new StringBuilder();
        Theme theme;
        if (semanticColorRole != null && !(semanticColorRole.name().isBlank())) {
            theme = getThemeFor(semanticColorRole, customFormattingElements);
        } else {
            theme = new Theme(
                    bgColor == null ? BackgroundColor.NEUTRAL : bgColor,
                    fgColor == null ? ForegroundColor.NEUTRAL : fgColor,
                    customFormattingElements
            );
        }
        if (customFormattingElements != null && !customFormattingElements.isEmpty()) {
            List<String> temp = theme.getFormattingElements();
            temp.addAll(customFormattingElements);
            theme.setFormattingElements(temp);
            theme.setHasFormattingElements(true);
        }
        themedText.append(theme.getCombinedAnsi());
        if (theme.isHavingFormattingElements() && !theme.getFormattingElements().isEmpty()) {
            for (String nextFormtString : theme.getFormattingElements()) {
                themedText.append(nextFormtString);
            }
        }
        themedText.append(text).append(CommonConstants.RESET);// Reset code
        return themedText.toString();
    }

    private static String applyStyling(String text, SemanticColorRole role) {
        return applyStyling(text, role, null, null, null);
    }

    private static String applyStyling(String text, BackgroundColor bgColor, ForegroundColor fgColor, List<String> customFormattingElements) {
        return applyStyling(text, null, bgColor, fgColor, customFormattingElements);
    }

    private static Theme getThemeFor(SemanticColorRole role, List<String> customFormattingElements) {
        return switch (role) {
            case PROGRAM_BANNER,OUTPUT_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of(CommonConstants.BOLD));
            case INTRO_TEXT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.BOLD));
            case INITIALIZATION_INFO -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD));
            case BENCHMARK_SECTION_HEADER, SECTION_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of( CommonConstants.BOLD,CommonConstants.UNDERLINE));
          case ITALICIZED_EXECUTION_INSIGHT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of(CommonConstants.ITALIC));
            case ERROR,WARNING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), null);
            case null, default -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.NEUTRAL, null);
        };

        /*return switch (role) {
            case PROGRAM_BANNER -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_GREEN, List.of(CommonConstants.BOLD));
            case BENCHMARK_SECTION_HEADER -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.UNDERLINE, CommonConstants.BOLD));
            case SECTION_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.UNDERLINE, CommonConstants.BOLD));
            case INTRO_TEXT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.BOLD));
            case INITIALIZATION_INFO -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD));
            case ITALICIZED_EXECUTION_INSIGHT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.ITALIC));
            case OUTPUT_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.BOLD));
            case ERROR -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_RED, null);
            case WARNING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.ORANGE, null);
            case null, default -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.NEUTRAL, null);
        };*/
    }

}
