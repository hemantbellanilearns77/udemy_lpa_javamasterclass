package com.hb.study.javamasterclasscourse.section5_buildingblocks.exercises.exercise6;

public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }

    public static boolean areEqualByThreeDecimalPlaces (double firstNumber, double secondNumber){
        boolean equalityStatus = false;
        long firstModifiedNumber =  (long) (firstNumber * 1000);
        long secondModifiedNumber =  (long) (secondNumber * 1000);
        if (firstModifiedNumber == secondModifiedNumber){
            equalityStatus = true;
        }
        return equalityStatus;
    }

}
