package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core;

/**
 * created by : heman on 14-07-2025, 06:40 pm, in the "udemy_lpa_javamasterclass" project
 **/

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {
    private NumberUtils() {
    }


    public static String formatCurrency(double value, Locale locale) {
        try {
            return NumberFormat.getCurrencyInstance(locale).format(value);
        } catch (Exception _) {
            return "[⚠️ Currency formatting failed]";
        }
    }

    public static String formatNumber(double value, Locale locale) {
        try {
            return NumberFormat.getNumberInstance(locale).format(value);
        } catch (Exception _) {
            return "[⚠️ Number formatting failed]";
        }
    }

    public static String formatPercent(double value, Locale locale) {
        try {
            return NumberFormat.getPercentInstance(locale).format(value);
        } catch (Exception _) {
            return "[⚠️ Percent formatting failed]";
        }
    }

    public static String formatScientific(double value, Locale locale) {
        try {
            // Not all locales support scientific format cleanly
            return String.format(locale, "%e", value);
        } catch (Exception _) {
            return "[⚠️ Scientific formatting failed]";
        }
    }

    public static void runGlobalCurrencyAndNumber() {
        ConsoleStyler.styleOutput("💱 CURRENCY & NUMBER FORMAT — Global Round");
        ConsoleStyler.divider();

        double sample = 1234567.89;

        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            String currency = formatCurrency(sample, locale);
            String number = formatNumber(sample, locale);


            ConsoleStyler.styleOutput(null, """
                    🌍 %s%n💰 Currency: %s%n🔢 Number: %s%n%n
                    """.formatted(locale.getDisplayName(), currency, number));
            ConsoleStyler.styleOutput(null, "Demo: Currency; Locale is: " + locale.getDisplayName() + "; Output is: " + currency);
            ConsoleStyler.styleOutput(null, "Demo: Number; Locale is: " + locale.getDisplayName() + "; Output is: " + number);
        }
    }
}