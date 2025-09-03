package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * PrimitiveTypesChallange1
 */
public class IntegerDataTypesChallenge {
        public static void main(String[] ignoredUnusedArgs) {
        //
        byte byteVar = 77;
        short shortVar = 777;
        int intVar = 7777;

        long longVar = (50000L + (10L * (byteVar + shortVar + intVar)));
        ConsoleStyler.styleOutput("Sum of " + 50000 + " with " + 10 + " times sum of byteVar, shortVar and intVar is: " + longVar);
    }
}
