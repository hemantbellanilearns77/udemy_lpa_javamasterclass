package com.hb.study.udemylpajavamasterclass.section5_buildingblocks.exercises.exercise4;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class BarkingDog {
    public static void main(String[] args) {
        ConsoleStyler.styleOutput("shouldWakeUp (true, 1) : " + shouldWakeUp (true, 1) );
        ConsoleStyler.styleOutput("shouldWakeUp (false, 2) : " + shouldWakeUp (false, 2) );
        ConsoleStyler.styleOutput("shouldWakeUp (true, 8) : " + shouldWakeUp (true, 8) );
        ConsoleStyler.styleOutput("shouldWakeUp (true, -1) : " + shouldWakeUp (true, -1) );
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay ) {
        boolean needToWakeUp = false;
        if (!(hourOfDay <0 || hourOfDay > 23)) {
            if ( (barking) && (hourOfDay < 8 || hourOfDay > 22) ) {
                needToWakeUp = true;
            }
        }
        return needToWakeUp;
    }
}
