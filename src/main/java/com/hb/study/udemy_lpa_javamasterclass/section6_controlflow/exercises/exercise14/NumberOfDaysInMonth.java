package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise14;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.CommonUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class NumberOfDaysInMonth {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleOutput(getDaysInMonth(1, 2020) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(getDaysInMonth(2, 2020)  + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(getDaysInMonth(2, 2018)  + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(getDaysInMonth(-1, 2020)  + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(getDaysInMonth(1, -2020)  + CommonConstants.EMPTYSTRING);
        execution.finalizeExecution();
    }
    public static int getDaysInMonth(int month, int year) {
        int monthDays = -1;
        if(!((month < 1) || (month > 12) || (year < 1) || (year > 9999)) ) {
            return switch(month) {
                case 1, 3, 5, 7, 8, 10, 12 -> { monthDays = 31; yield monthDays; }
                case 2 -> {
                    if(CommonUtils.isLeapYear(year)) {
                        monthDays = 29;
                    }
                    else {
                        monthDays = 28;
                    }
                    yield monthDays;
                }
                case 4, 6, 9, 11 -> { monthDays = 30; yield monthDays; }
                default -> monthDays;
            };
        }
        return monthDays;

    }
}
