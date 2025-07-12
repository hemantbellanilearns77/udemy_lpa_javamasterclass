package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * created by : heman on 08-07-2025, 09:27 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class CommonUtils {
    private static final int nameMaxLength = new Random().nextInt(1, 19);


    public static Name generateRandomName(String[]... arrays) {

        Random random = new Random();
        //String[] fullNameArray = new String[2];
        String firstName;
        String lastName;
        Name generatedFullName;
        switch (arrays.length) {
            case 1 -> {
                firstName = arrays[0][random.nextInt(arrays[0].length)];
                lastName = CommonConstants.LAST_NAMES[random.nextInt(CommonConstants.LAST_NAMES.length)];

            }
            case 2 -> {
                firstName = arrays[0][random.nextInt(arrays[0].length)];
                lastName = arrays[1][random.nextInt(arrays[1].length)];
            }
            default -> {
                firstName = CommonConstants.FIRST_NAMES[random.nextInt(CommonConstants.FIRST_NAMES.length)];
                lastName = CommonConstants.LAST_NAMES[random.nextInt(CommonConstants.LAST_NAMES.length)];
            }
        }
        generatedFullName = new Name(firstName,lastName);
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
