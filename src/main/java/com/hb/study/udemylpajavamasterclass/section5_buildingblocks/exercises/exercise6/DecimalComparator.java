package com.hb.study.udemylpajavamasterclass.section5_buildingblocks.exercises.exercise6;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class DecimalComparator {
    public static void main(String[] args) {

        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(3.175, 3.176) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(3.0, 3.0)+ CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(-3.123, 3.123)+ CommonConstants.EMPTYSTRING);
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
