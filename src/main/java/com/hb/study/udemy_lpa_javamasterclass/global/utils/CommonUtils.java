package com.hb.study.udemy_lpa_javamasterclass.global.utils;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * created by : heman on 08-07-2025, 09:27 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class CommonUtils {


    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int NAME_MAX_LENGTH = secureRandom.nextInt(1, 19);

    // Fills an int array with random numbers
    public static int[] generateIntArray(int length, int bound) {
        return secureRandom.ints(length, 0, bound).toArray();
    }

    // Pretty-print array
    public static void printArray(String label, int[] array) {
        if(label!=null &&  !label.isEmpty()) {
            ConsoleStyler.styleEachAsIs(label, array);
        }  else {
            ConsoleStyler.styleEachAsIs(null, array);
        }
    }

    // Validate string is not empty or null
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Format double value to two decimals
    public static String formatDouble(double value) {
        return new DecimalFormat("#.00").format(value);
    }



    public static String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < NAME_MAX_LENGTH; i++) {
            int index = secureRandom.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }

    public static String getRandomDate(int fromDayOfMonth, int fromMonth, int fromYear, FormatStyle formatStyle) {
        long minDay;
        long maxDay;
        long randomDay;
        try {
            minDay = LocalDate.of(fromYear, fromMonth, fromDayOfMonth).toEpochDay();
        } catch (DateTimeException dateTimeException) {
            ConsoleStyler.styleOutput("Since the Random Date couldn't be formed from the range between today and date parameters supplied, due to: \n" +
                    dateTimeException.getMessage());
            ConsoleStyler.styleOutput("Therefore returning a default date: 15-Aug-1947");
            minDay = LocalDate.of(1947, 8, 15).toEpochDay();
        }
        maxDay = LocalDate.now().toEpochDay();
        randomDay = secureRandom.nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay).format(DateTimeFormatter.ofLocalizedDate(formatStyle));

    }
}
