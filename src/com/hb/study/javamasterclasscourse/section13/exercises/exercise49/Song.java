package com.hb.study.javamasterclasscourse.section13.exercises.exercise49;

/**
 * created by : heman on 07-07-2025, 06:02 PM, in the "udemy_lpa_javamasterclass" project
 **/

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
       Song toCompareSong  = (Song)obj;
        if(((Song) this).getTitle().equalsIgnoreCase(toCompareSong.getTitle())) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return  getTitle() + ": " + duration;
    }
}