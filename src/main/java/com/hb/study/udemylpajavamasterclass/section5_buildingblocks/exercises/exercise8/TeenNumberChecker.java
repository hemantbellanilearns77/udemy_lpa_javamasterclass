package com.hb.study.udemylpajavamasterclass.section5_buildingblocks.exercises.exercise8;

public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(23, 15, 42));
        System.out.println(hasTeen(22, 23, 34));

    }

    public static boolean hasTeen(int firstNumber, int secondNumber, int thirdNumber) {
        boolean hasTeenStatus = false;
        if ( isTeen(firstNumber) || isTeen(secondNumber)|| isTeen(thirdNumber) ) {
            hasTeenStatus = true;
        }
        return hasTeenStatus;
    }

    public static boolean isTeen(int numberToCheckForTeen) {
        boolean teenStatus = false;
        if( ((numberToCheckForTeen >= 13) && (numberToCheckForTeen <= 19)) ) {
            teenStatus = true;
        }
        return teenStatus;
    }
}
