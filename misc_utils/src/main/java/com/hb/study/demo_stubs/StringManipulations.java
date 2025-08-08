package com.hb.study.demo_stubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
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
    public static final ExcecutionUtil execution = new ExcecutionUtil();
    public static void main(String[] args) {
        execution.initialize();
        /*
         *****************************************************
         */
        /*String testDateString = "06/07/2021";
        int yearsWorked = Year.now().getValue() - Integer.parseInt(testDateString.substring(testDateString.lastIndexOf('/')+1));
        ConsoleStyler.styleOutput(yearsWorked);*/
        LocalDate startDate = LocalDate.parse("06/07/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH));
        LocalDate today = LocalDate.now();

        Period period = Period.between(startDate, today);
        int yearsElapsed = period.getYears();

        ConsoleStyler.styleOutput("Years elapsed: " + yearsElapsed);

        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }
}
