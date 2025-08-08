package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;

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


    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int NAME_MAX_LENGTH = SECURE_RANDOM.nextInt(1, 19);

    // Fills an int array with random numbers
    public static int[] generateIntArray(int length, int bound) {
        return SECURE_RANDOM.ints(length, 0, bound).toArray();
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

    public static Name generateRandomName(String[]... arrays) {
        //String[] fullNameArray = new String[2];
        String firstName;
        String lastName;
        Name generatedFullName;
        switch (arrays.length) {
            case 1 -> {
                firstName = arrays[0][SECURE_RANDOM.nextInt(arrays[0].length)];
                lastName = CommonConstants.LAST_NAMES[SECURE_RANDOM.nextInt(CommonConstants.LAST_NAMES.length)];

            }
            case 2 -> {
                firstName = arrays[0][SECURE_RANDOM.nextInt(arrays[0].length)];
                lastName = arrays[1][SECURE_RANDOM.nextInt(arrays[1].length)];
            }
            default -> {
                firstName = CommonConstants.FIRST_NAMES[SECURE_RANDOM.nextInt(CommonConstants.FIRST_NAMES.length)];
                lastName = CommonConstants.LAST_NAMES[SECURE_RANDOM.nextInt(CommonConstants.LAST_NAMES.length)];
            }
        }
        generatedFullName = new Name(firstName, lastName);
        return generatedFullName;
    }

    public static String generateRandomName(int nameMaxLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameMaxLength; i++) {
            int index = SECURE_RANDOM.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < NAME_MAX_LENGTH; i++) {
            int index = SECURE_RANDOM.nextInt(chars.length());
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
        randomDay = SECURE_RANDOM.nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay).format(DateTimeFormatter.ofLocalizedDate(formatStyle));

    }
}
