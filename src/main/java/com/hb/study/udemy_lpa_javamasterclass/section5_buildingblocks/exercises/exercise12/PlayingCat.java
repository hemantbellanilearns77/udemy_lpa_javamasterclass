package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise12;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class PlayingCat {
    public static void main(String[] args) {
        ConsoleStyler.styleOutput(isCatPlaying(true, 10) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(isCatPlaying(false, 36) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(isCatPlaying(false, 35) + CommonConstants.EMPTYSTRING);
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean catPlayingStatus = false;
        //if its summer i.e. if temp is between 25 and 45 (inclusive) - return true
        // if winter i.e. it's NOT summer and temp is between 25 and 35 (inclusive) - return true
        // return false in rest of the  scenarios

        if(temperature >= 25) {
            if(summer && temperature <= 45 ) {
                catPlayingStatus = true;
            } else if (!summer && temperature <= 35){
                catPlayingStatus = true;
            }
        }

        return catPlayingStatus;
    }
}