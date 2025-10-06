package com.hblearns77.udemy_lpa_javamasterclass.section_practice.demo_stubs;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * created by : heman on 08-07-2025, 03:16 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class StringManipulations {
    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {

        execution.initialize(args);

        String testDateString = "06/07/2021";
        int yearsWorked = Year.now().getValue() - Integer.parseInt(testDateString.substring(testDateString.lastIndexOf('/') + 1));
        ConsoleStyler.styleOutput(yearsWorked + CommonConstants.EMPTYSTRING);
        LocalDate startDate = LocalDate.parse(testDateString, DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_STANDARD, Locale.ENGLISH));
        LocalDate today = LocalDate.now();
        ConsoleStyler.styleOutput("Today: " + today.format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_STANDARD)));
        ConsoleStyler.styleOutput("Today: " + today.format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_VERBOSE)));

        Period period = Period.between(startDate, today);
        int yearsElapsed = period.getYears();

        ConsoleStyler.styleOutput("Years elapsed: " + yearsElapsed);
        execution.finalizeExecution();
    }
}
