package com.hb.study.javamasterclasscourse.section5_buildingblocks.exercises.exercise4;

public class BarkingDog {
    public static void main(String[] args) {
        System.out.println("shouldWakeUp (true, 1) : " + shouldWakeUp (true, 1) );
        System.out.println("shouldWakeUp (false, 2) : " + shouldWakeUp (false, 2) );
        System.out.println("shouldWakeUp (true, 8) : " + shouldWakeUp (true, 8) );
        System.out.println("shouldWakeUp (true, -1) : " + shouldWakeUp (true, -1) );
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
