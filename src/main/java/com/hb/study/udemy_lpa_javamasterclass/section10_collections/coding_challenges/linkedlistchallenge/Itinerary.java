package com.hb.study.udemy_lpa_javamasterclass.section10_collections.coding_challenges.linkedlistchallenge;

public class Itinerary {
    private Town origin;

    public Town getOrigin() {
        return origin;
    }

    public Itinerary(Town origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "origin='" + origin + '\'' +
                '}';
    }
}
