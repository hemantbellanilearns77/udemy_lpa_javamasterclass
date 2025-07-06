package com.hb.study.javamasterclasscourse.section5_buildingblocks.exercises.exercise7;

public class EqualSumChecker {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));

    }
    public static boolean hasEqualSum(int firstNumber, int secondNumber, int thirdNumber ) {
        boolean equalSumStatus = false;
        if( (firstNumber + secondNumber) == thirdNumber) {
            equalSumStatus = true;
        }
        return equalSumStatus;
    }
}
