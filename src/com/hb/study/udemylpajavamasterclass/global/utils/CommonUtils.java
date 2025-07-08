package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * created by : heman on 08-07-2025, 09:27 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class CommonUtils {
    private static int nameMaxLength = new Random().nextInt(1, 19);
    private static final String[] FIRST_NAMES = {
            "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
    public static void main(String[] args) {

        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.programOutputBegins);
        /*
         *****************************************************
         */
        //your code comes in here
        /*

         ******************************************************
         */
        System.out.print(CommonConstants.asteriskSeparatorLine);
        executionUtil.updateExecutionStats();
        System.out.println(executionUtil);
        System.out.println(CommonConstants.programOutputEnds);
    }

    public static String[] generateRandomName() {
        String[] nameArray = new String[2];
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        nameArray[0] = firstName;
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        nameArray[1] = lastName;

        return nameArray;
    }
    public static String generateRandomName(int nameMaxLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
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

    public static String getRandomDate( int fromDayOfMonth, int fromMonth,int fromYear,FormatStyle formatStyle ) {
        //public static LocalDate getRandomDate() {
        long minDay = LocalDate.of(1947, 8, 15).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay).format(DateTimeFormatter.ofLocalizedDate(formatStyle));
        //return LocalDate.ofEpochDay(randomDay);
    }
}
