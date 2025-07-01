package com.hb.study.udemy.lpa.section3_firststeps.coding_challenges;

/**
 * PrimitiveTypesChallange1
 */
public class IntegerDataTypesChallenge {
    public static void main(String[] args) {
        byte byteVar = 77;
        short shortVar = 777;
        int intVar = 7777;

        long longVar = (50000L + (10L * (byteVar + shortVar + intVar)));
        System.out.println("Sum of " + 50000 + " with " + 10 + " times sum of byteVar, shortVar and intVar is: " + longVar);
    }
}
