package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise7;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class EqualSumChecker {
        public static void main(String[] ignoredUnusedArgs) {
        //
        ConsoleStyler.styleOutput(Boolean.toString(hasEqualSum(1, 1, 1)));
        ConsoleStyler.styleOutput(Boolean.toString(hasEqualSum(1, 1, 2)));
        ConsoleStyler.styleOutput(Boolean.toString(hasEqualSum(1, -1, 0)));


    }
    public static boolean hasEqualSum(int firstNumber, int secondNumber, int thirdNumber ) {
        boolean equalSumStatus = false;
        if( (firstNumber + secondNumber) == thirdNumber) {
            equalSumStatus = true;
        }
        return equalSumStatus;
    }
}
