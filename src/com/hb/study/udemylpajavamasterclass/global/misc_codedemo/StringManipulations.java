package com.hb.study.udemylpajavamasterclass.global.misc_codedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * created by : heman on 08-07-2025, 03:16 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class StringManipulations {
    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();
    public static void main(String[] args) {
        execution.setUp();
        /*
         *****************************************************
         */
        /*String testDateString = "06/07/2021";
        int yearsWorked = Year.now().getValue() - Integer.parseInt(testDateString.substring(testDateString.lastIndexOf('/')+1));
        System.out.println(yearsWorked);*/
        LocalDate startDate = LocalDate.parse("06/07/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH));
        LocalDate today = LocalDate.now();

        Period period = Period.between(startDate, today);
        int yearsElapsed = period.getYears();

        System.out.println("Years elapsed: " + yearsElapsed);

        /*

         ******************************************************
         */
        execution.windDown();
    }
}
