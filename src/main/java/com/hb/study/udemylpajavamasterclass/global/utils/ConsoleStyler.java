package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.constants.BackgroundColor;
import com.hb.study.udemylpajavamasterclass.global.constants.ForegroundColor;
import com.hb.study.udemylpajavamasterclass.global.models.SemanticColorRole;
import com.hb.study.udemylpajavamasterclass.global.models.Theme;

import java.lang.reflect.Array;
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
        styleOutput(CommonConstants.SECTION_SEPARATOR);
        System.out.printf(applyStyling("📌 " + title.toUpperCase(), SemanticColorRole.PROGRAM_BANNER));
        styleOutput(CommonConstants.SECTION_SEPARATOR);
    }

    public static void startSection(String label) {
        divider();
        styleOutput(CommonConstants.SECTION_SEPARATOR);
        styleOutput(applyStyling("🔷 START: ", null, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD)) +
                applyStyling(label.toUpperCase(), SemanticColorRole.SECTION_HEADING));
        styleOutput(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        styleOutput(CommonConstants.DOTTED_LINE);
        styleOutput(applyStyling("🏁 END: ", null, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD)) +
                applyStyling(label.toUpperCase(), SemanticColorRole.SECTION_HEADING));
        styleOutput(CommonConstants.SECTION_SEPARATOR);
        divider();
    }

    public static void styleIntro(String outputText) {
        styleIt(outputText.toUpperCase(), SemanticColorRole.INTRO_TEXT,
                false, true, false);

    }

    public static void divider() {
        styleOutput(ForegroundColor.MUSTARD.getAnsiCode() + CommonConstants.FULLLINEASTERISKSEPERATOR + CommonConstants.RESET);
    }

    public static void halfDivider() {
        styleOutput(CommonConstants.INDENT + ForegroundColor.MUSTARD.getAnsiCode() + CommonConstants.HALFLINEASTERISKSEPERATOR + CommonConstants.RESET);
    }

    public static void styleInitializationInfo(String outputText) {
        styleIt((CommonConstants.INITIALIZATIONS_INFO + System.lineSeparator() + outputText),
                SemanticColorRole.INITIALIZATION_INFO, false, true, false);
    }

    public static void styleExecutionInsight(String outputText) {
        styleIt(outputText, SemanticColorRole.ITALICIZED_EXECUTION_INSIGHT);
    }
    public static void styleError(String outputText){
        styleIt(outputText, SemanticColorRole.ERROR);
    }

    public static void styleWarning(String outputText){
        styleIt(outputText, SemanticColorRole.WARNING);
    }
    private static void styleIt(String outputText, SemanticColorRole semanticColorRole) {
        styleIt(outputText, semanticColorRole, false, false, false);
    }

    public static void styleOutput(String outputHeading, String outputText) {
        if (outputHeading != null && !outputHeading.isBlank()) {
            styleIt(outputHeading, SemanticColorRole.OUTPUT_HEADING);
        }
        if (outputText != null && !outputText.isBlank()) {
            styleIt(outputText, null);
        }
    }
    public static void styleOutput(String outputText) {
        styleOutput(null, outputText);
    }

    public static void styleIt(String outputText, SemanticColorRole semanticRole, boolean showLineNumbers, boolean enableBorderColor, boolean showlinePrefix) {
        if (outputText == null || outputText.isBlank()) {
            styleOutput(CommonConstants.INDENT + "⚠️ [No output to display]");
            return;
        }

        String[] lines = outputText.split("\\R"); // Handles all newline types

        // Optional ANSI coloring
        String borderColor = enableBorderColor ? ForegroundColor.BRIGHT_MAGENTA.getAnsiCode() : ""; //
        String resetColor = enableBorderColor ? CommonConstants.RESET : "";

        styleOutput(CommonConstants.INDENT + borderColor + "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────" + resetColor);

        //StringBuilder linesToPrint = new StringBuilder();
        for (int lineCounter = 0; lineCounter < lines.length; lineCounter++) {
            String linePrefix = showLineNumbers ? String.format("[%02d]", (lineCounter + 1)) : String.format("%s", showlinePrefix ? ("» ") : "");
            String lineToPrint = linePrefix + lines[lineCounter];
            styleOutput(CommonConstants.INDENT + borderColor + "│ " + resetColor + applyStyling(lineToPrint, semanticRole));
        }
        styleOutput(CommonConstants.INDENT + borderColor + "│ ");
        styleOutput(CommonConstants.INDENT + borderColor + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────" + resetColor);
    }

    // Overloaded wrapper to just show line numbers, no uppercase, no sorting
    public static void styleEachAsIs(String labelPrefix, Object input) {
        styleEach(labelPrefix, input, false, false, false);
    }


    public static void styleEach(String labelPrefix, Object input, boolean sort, boolean formatNumbers, boolean uppercaseStrings) {
        if (input == null) { styleOutput(CommonConstants.INDENT + "⚠️ No items to display."); return; }
        labelPrefix = getLabelPrefix(labelPrefix);
        final List<Object> items = new ArrayList<>();
        boolean isTupleMode = false;
        int tupleSize = -1;

        switch (input) {
            case double[] arr      -> { tupleSize = arr.length; addArray(arr, items); isTupleMode = true; }
            case double[][] arr2   -> { tupleSize = arr2[0].length; for (double[] a : arr2) addArray(a, items); isTupleMode = true; }
            case double[][][] arr3 -> { tupleSize = arr3[0][0].length; for (double[][] g : arr3) for (double[] a : g) addArray(a, items); isTupleMode = true; }

            case int[] arr         -> addArray(arr, items);
            case long[] arr        -> addArray(arr, items);
            case boolean[] arr     -> addArray(arr, items);
            case char[] arr        -> addArray(arr, items);

            case Object[] objs     -> items.addAll(Arrays.asList(objs));
            case List<?> list      -> {
                tupleSize= handleList(list, items);
                isTupleMode = tupleSize >= 0;
            }
            case Set<?> set        -> items.addAll(set);
            case Stream<?> stream  -> stream.forEach(items::add);
            default -> { styleOutput(CommonConstants.INDENT + "⚠️ Unsupported input type: " + input.getClass().getSimpleName()); return; }
        }

        if (items.isEmpty()) { styleOutput(CommonConstants.INDENT + "⚠️ No items to display."); return; }
        final List<Object> formattedItems = getFormattedItems(formatNumbers, uppercaseStrings, items);

        if (sort) {
            try { Collections.sort((List) formattedItems); }
            catch (ClassCastException e) { styleOutput(CommonConstants.INDENT + "⚠️ Sorting skipped: non-comparable items"); }
        }

        styleOutput(null, getStyledInput(labelPrefix, formattedItems, isTupleMode, tupleSize));
    }

    private static String getLabelPrefix(String labelPrefix) {
        return (labelPrefix == null || labelPrefix.isBlank()) ? CommonConstants.EMPTYSTRING : (labelPrefix + ": ");
    }

    /* Helper: add any (primitive or object) array's elements to items */
    private static void addArray(Object array, List<Object> items) {
        int len = Array.getLength(array);
        for (int i = 0; i < len; i++) items.add(Array.get(array, i));
    }

    /*
     * Returns tupleSize >= 0 when the list is a list-of-arrays (double[] or Object[]),
     * or -1 when it's a normal list (in which case items are appended).
     */
    private static int handleList(List<?> list, List<Object> items) {
        if (list == null || list.isEmpty()) return -1;
        Object first = list.get(0);
        if (first instanceof double[]) {
            int size = ((double[]) first).length;
            for (Object o : list) addArray(o, items);   // each o is double[]
            return size;
        }
        if (first instanceof Object[]) {
            int size = ((Object[]) first).length;
            for (Object o : list) items.addAll(Arrays.asList((Object[]) o)); // each o is Object[]
            return size;
        }
        items.addAll(list);
        return -1;
    }

    private static String getStyledInput(String labelPrefix, List<Object> formattedItems, boolean isTupleMode, int tupleSize) {
        StringBuilder styledOutputBuilder = new StringBuilder();
        final AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < formattedItems.size(); i += (isTupleMode ? tupleSize : 1)) {
            final int tupleStart = i;
            if (isTupleMode && i + tupleSize <= formattedItems.size()) {
                final String tuple = IntStream.range(0, tupleSize)
                        .mapToObj(j -> formattedItems.get(tupleStart + j).toString())
                        .collect(Collectors.joining(", "));
                styledOutputBuilder.append("%s%s [%d] → (%s)%n".formatted(CommonConstants.INDENT, labelPrefix, counter.getAndIncrement(), tuple));
            } else {
                styledOutputBuilder.append("%s [%d] %s%s".formatted(labelPrefix, counter.getAndIncrement(), formattedItems.get(i), "\t"));
            }
        }
        return styledOutputBuilder.toString();
    }

    private static List<Object> getFormattedItems(boolean formatNumbers, boolean uppercaseStrings, List<Object> items) {
        return items.stream()
                .map(obj -> {
                    if (obj == null) return "null";
                    if (formatNumbers && obj instanceof Number) return String.format("%12s", obj);
                    if (uppercaseStrings && obj instanceof String) return ((String) obj).toUpperCase();
                    return obj;
                })
                .collect(Collectors.toList());
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
            case PROGRAM_BANNER, OUTPUT_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of(CommonConstants.BOLD));
            case INTRO_TEXT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_WHITE, List.of(CommonConstants.BOLD));
            case INITIALIZATION_INFO -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.BRIGHT_CYAN, List.of(CommonConstants.BOLD));
            case BENCHMARK_SECTION_HEADER, SECTION_HEADING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of(CommonConstants.BOLD, CommonConstants.UNDERLINE));
            case ITALICIZED_EXECUTION_INSIGHT -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), List.of(CommonConstants.ITALIC));
            case ERROR, WARNING -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.random(), null);
            case null, default -> new Theme(
                    BackgroundColor.NEUTRAL, ForegroundColor.NEUTRAL, null);
        };
    }

    /**
     * Optional visual preview in terminal.
     */
    public static void getFGColorPreview(String label, ForegroundColor foregroundColor) {
        if (foregroundColor.getAnsiCode() != null && !foregroundColor.getAnsiCode().isEmpty()) {
            styleOutput(foregroundColor.getAnsiCode() + "█ " + label + "\u001B[0m");
        } else {
            styleOutput("✳️ " + label + " (no ANSI code)");
        }
    }

    /**
     * Optional visual preview in terminal.
     */
    public static void getBGColorPreview(String label, BackgroundColor backgroundColor) {
        if (backgroundColor.getAnsiCode() != null && !backgroundColor.getAnsiCode().isEmpty()) {
            styleOutput(backgroundColor.getAnsiCode() + "█ " + label + "\u001B[0m");
        } else {
            styleOutput("✳️ " + label + " (no ANSI code)");
        }
    }
}
