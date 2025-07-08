package com.hb.study.javamasterclasscourse.globalcommon.misc_practice;

import com.hb.study.javamasterclasscourse.globalcommon.constants.GlobalCommonConstants;
import com.hb.study.javamasterclasscourse.globalcommon.utils.ExcecutionUtil;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * created by : heman on 08-07-2025, 03:16 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class StringManipulations {
    public static void main(String[] args) {

        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(GlobalCommonConstants.programOutputBegins);
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
        System.out.print(GlobalCommonConstants.asteriskSeparatorLine);
        executionUtil.updateExecutionStats();
        System.out.println(executionUtil);
        System.out.println(GlobalCommonConstants.programOutputEnds);
    }
}
