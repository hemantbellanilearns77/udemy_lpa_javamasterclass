package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise4;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class BarkingDog {
    public static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleOutput("shouldWakeUp (true, 1) : " + shouldWakeUp (true, 1) );
        ConsoleStyler.styleOutput("shouldWakeUp (false, 2) : " + shouldWakeUp (false, 2) );
        ConsoleStyler.styleOutput("shouldWakeUp (true, 8) : " + shouldWakeUp (true, 8) );
        ConsoleStyler.styleOutput("shouldWakeUp (true, -1) : " + shouldWakeUp (true, -1) );
        execution.finalizeExecution();
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        boolean validHour = hourOfDay >= 0 && hourOfDay <= 23;
        boolean oddHour   = hourOfDay < 8 || hourOfDay > 22;

        return validHour && barking && oddHour;
    }
}
