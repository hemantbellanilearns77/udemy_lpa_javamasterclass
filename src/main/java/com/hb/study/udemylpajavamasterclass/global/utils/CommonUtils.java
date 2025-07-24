package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * created by : heman on 08-07-2025, 09:27 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class CommonUtils {
    private static final int nameMaxLength = new Random().nextInt(1, 19);

    private static final Random RANDOM = new Random();



    // Fills an int array with random numbers
    public static int[] generateIntArray(int length, int bound) {
        return RANDOM.ints(length, 0, bound).toArray();
    }

    // Pretty-print array
    public static void printArray(String label, int[] array) {
        System.out.println(label + ": " + Arrays.toString(array));
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
                firstName = arrays[0][RANDOM.nextInt(arrays[0].length)];
                lastName = CommonConstants.LAST_NAMES[RANDOM.nextInt(CommonConstants.LAST_NAMES.length)];

            }
            case 2 -> {
                firstName = arrays[0][RANDOM.nextInt(arrays[0].length)];
                lastName = arrays[1][RANDOM.nextInt(arrays[1].length)];
            }
            default -> {
                firstName = CommonConstants.FIRST_NAMES[RANDOM.nextInt(CommonConstants.FIRST_NAMES.length)];
                lastName = CommonConstants.LAST_NAMES[RANDOM.nextInt(CommonConstants.LAST_NAMES.length)];
            }
        }
        generatedFullName = new Name(firstName, lastName);
        return generatedFullName;
    }

    public static String generateRandomName(int nameMaxLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < nameMaxLength; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < nameMaxLength; i++) {
            int index = random.nextInt(chars.length());
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
            System.out.println("Since the Random Date couldn't be formed from the range between today and date parameters supplied, due to: \n" +
                    dateTimeException.getMessage());
            System.out.println("Therefore returning a default date: 15-Aug-1947");
            minDay = LocalDate.of(1947, 8, 15).toEpochDay();
        }
        maxDay = LocalDate.now().toEpochDay();
        randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay).format(DateTimeFormatter.ofLocalizedDate(formatStyle));

    }
}
