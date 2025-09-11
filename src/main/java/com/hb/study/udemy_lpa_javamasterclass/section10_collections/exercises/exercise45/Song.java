package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise45;

public class Song {
    private final String title;
    private final double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }



    @Override
    public String toString() {
        return  getTitle() + ": " + duration;
    }
}

