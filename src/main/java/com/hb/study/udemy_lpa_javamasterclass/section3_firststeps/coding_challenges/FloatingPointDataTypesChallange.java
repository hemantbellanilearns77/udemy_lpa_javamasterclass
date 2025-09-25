package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * PrimitiveTypesChallenge2
 */
public class FloatingPointDataTypesChallange {
    public static final ExcecutionUtil execution = new ExcecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        double kilograms;
        double pounds = 36.00;
        kilograms = 0.45359237 * 36.00;

        ConsoleStyler.styleOutput(pounds + " pounds when converted to Kilograms is: " + kilograms);
        execution.finalizeExecution();
    }
}
