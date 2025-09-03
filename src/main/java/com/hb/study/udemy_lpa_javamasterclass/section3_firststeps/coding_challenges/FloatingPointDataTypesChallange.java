package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * PrimitiveTypesChallange2
 */
public class FloatingPointDataTypesChallange {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        double kilograms = 0.00, pounds = 36.00;
        kilograms = 0.45359237 * 36.00;

        ConsoleStyler.styleOutput(pounds + " pounds when converted to Kilograms is: " + kilograms);
    }
}
