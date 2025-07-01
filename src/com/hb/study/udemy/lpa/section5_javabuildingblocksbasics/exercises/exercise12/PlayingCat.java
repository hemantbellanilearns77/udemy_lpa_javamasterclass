package com.hb.study.udemy.lpa.section5_javabuildingblocksbasics.exercises.exercise12;

public class PlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean catPlayingStatus = false;
        //if its summer i.e. if temp is between 25 and 45 (inclusive) - return true
        // if winter i.e. its NOT summer and temp is between 25 and 35 (inclusive) - return true
        // return false in all other cases

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