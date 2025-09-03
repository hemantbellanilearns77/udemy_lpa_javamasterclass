package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise6;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class DecimalComparator {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }

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
