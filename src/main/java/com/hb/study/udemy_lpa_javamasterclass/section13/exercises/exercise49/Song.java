package com.hb.study.udemy_lpa_javamasterclass.section13.exercises.exercise49;

import java.util.Objects;

/**
 * created by : heman on 07-07-2025, 06:02 PM, in the "udemy_lpa_javamasterclass" project
 **/

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
    public boolean equals(Object obj) {
        if(obj instanceof Song toCompareSong) {
            return this.getTitle().equalsIgnoreCase(toCompareSong.getTitle());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, duration);
    }
    @Override
    public String toString() {
        return  getTitle() + ": " + duration;
    }
}