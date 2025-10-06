package com.hblearns77.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise5;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.CommonUtils;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class LeapYear {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        String emptyString = "";
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(1924) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(-1600) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(1600) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(2017) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(2000) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(1900) + emptyString);
        ConsoleStyler.styleOutput(CommonUtils.isLeapYear(-1200) + emptyString);

        execution.finalizeExecution();
    }
}

