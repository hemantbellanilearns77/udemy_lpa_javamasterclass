package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise25;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class FlourPacker {

    // write code here
        public static void main(String[] unusedArgs) {
        //
        ConsoleStyler.styleOutput(canPack(1, 0, 4) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack (1, 0, 5) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack (0, 5, 4) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack (2, 2, 11) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack (-3, 2, 12) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack(5, 3, 24) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack(2, 1, 5) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(canPack(4, 18, 19) + CommonConstants.EMPTYSTRING);
    }

    public static boolean canPack (int bigCount, int smallCount, int goal){
        int availableTotalCapacity = (bigCount*5) + (smallCount);
        boolean canPackStatus = false;

        if(shouldCheck(bigCount, smallCount, goal)){

            if(goal == availableTotalCapacity) {
                canPackStatus = true;
            } else if( goal < availableTotalCapacity){
                if((bigCount == 0) || (smallCount == 0)) {
                    canPackStatus = checkConditionOne(bigCount, smallCount, goal);
                } else {
                    canPackStatus = checkConditionTwo(bigCount, smallCount, goal);
                }
            }
        }
        return canPackStatus;
    }

    private static boolean shouldCheck(int bigCount, int smallCount, int goal) {
        return !(smallCount < 0 || bigCount < 0 || goal < 0);
    }

    private static boolean checkConditionOne(int bigCount, int smallCount, int goal) {
        boolean condtionOneSatisfied = false;
            if(bigCount == 0) {
                if(goal <= smallCount){
                    condtionOneSatisfied = true;
                }
            } else if( goal == (bigCount * 5)){
                condtionOneSatisfied = true;
            }
        return condtionOneSatisfied;
    }
    private static boolean checkConditionTwo(int bigCount, int smallCount, int goal) {
        boolean condtionTwoSatisfied = false;
        if (((goal - smallCount) <= (bigCount * 5)) && (((goal - smallCount) % 5) == 0)) {
            condtionTwoSatisfied = true;
        } else if ((((goal - (bigCount * 5))) > 0) && (((goal - (bigCount * 5))) <= smallCount)) {
            condtionTwoSatisfied = true;
        } else if ((goal < (bigCount * 5)) && ((goal % 5) == 0)) {
            condtionTwoSatisfied = true;
        } else if (((bigCount * 5) - (goal % 5)) <= smallCount) {
            condtionTwoSatisfied = true;
        }
        return condtionTwoSatisfied;
    }
}