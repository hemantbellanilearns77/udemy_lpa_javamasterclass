package com.hblearns77.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise6;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class DecimalComparator {
    public static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(3.175, 3.176) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(3.0, 3.0)+ CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(areEqualByThreeDecimalPlaces(-3.123, 3.123)+ CommonConstants.EMPTYSTRING);
        execution.finalizeExecution();
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
