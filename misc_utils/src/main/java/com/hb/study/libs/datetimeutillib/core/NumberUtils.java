package com.hb.study.libs.datetimeutillib.core;

/**
 * created by : heman on 14-07-2025, 06:40 pm, in the "udemy_lpa_javamasterclass" project
 **/
import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {

    public static String formatCurrency(double value, Locale locale) {
        try {
            return NumberFormat.getCurrencyInstance(locale).format(value);
        } catch (Exception e) {
            return "[⚠️ Currency formatting failed]";
        }
    }

    public static String formatNumber(double value, Locale locale) {
        try {
            return NumberFormat.getNumberInstance(locale).format(value);
        } catch (Exception e) {
            return "[⚠️ Number formatting failed]";
        }
    }

    public static String formatPercent(double value, Locale locale) {
        try {
            return NumberFormat.getPercentInstance(locale).format(value);
        } catch (Exception e) {
            return "[⚠️ Percent formatting failed]";
        }
    }

    public static String formatScientific(double value, Locale locale) {
        try {
            // Not all locales support scientific format cleanly
            return String.format(locale, "%e", value);
        } catch (Exception e) {
            return "[⚠️ Scientific formatting failed]";
        }
    }
    public static void runGlobalCurrencyAndNumber() {
        ConsoleStyler.styleOutput("💱 CURRENCY & NUMBER FORMAT — Global Round");
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");

        double sample = 1234567.89;

        for (Locale locale : LocaleLibrary.getGlobalLocales()) {
            String currency = formatCurrency(sample, locale);
            String number = formatNumber(sample, locale);

            System.out.printf("🌍 %s\n💰 Currency: %s\n🔢 Number: %s\n\n",
                    locale.getDisplayName(), currency, number);

            FormatterExportUtil.logEntry("Currency", locale.toString(), currency);
            FormatterExportUtil.logEntry("Number", locale.toString(), number);
        }
    }
}