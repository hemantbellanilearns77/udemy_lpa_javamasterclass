package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise8;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class TeenNumberChecker {
        public static void main(String[] ignoredUnusedArgs) {
        //
        ConsoleStyler.styleOutput(Boolean.toString(hasTeen(9, 99, 19)));
        ConsoleStyler.styleOutput(Boolean.toString(hasTeen(23, 15, 42)));
        ConsoleStyler.styleOutput(Boolean.toString(hasTeen(22, 23, 34)));

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
