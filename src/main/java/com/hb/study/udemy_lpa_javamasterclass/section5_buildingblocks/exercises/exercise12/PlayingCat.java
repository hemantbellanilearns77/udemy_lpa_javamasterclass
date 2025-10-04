package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise12;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class PlayingCat {
    public static final ExecutionUtil execution = new ExecutionUtil();
    public static final String CAT_PLAYING_STATUS = "Cat is playing? : ";
    public static void main(String[] args) {

        execution.initialize(args);
        ConsoleStyler.styleOutput(CAT_PLAYING_STATUS + isCatPlaying(true, 10) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(CAT_PLAYING_STATUS + isCatPlaying(false, 36) + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(CAT_PLAYING_STATUS + isCatPlaying(false, 35) + CommonConstants.EMPTYSTRING);
        execution.finalizeExecution();
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (summer) {
            return temperature >= 25 && temperature <= 45;
        } else {
            return temperature >= 25 && temperature <= 35;
        }
    }
}