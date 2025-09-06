package com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.genericsclasschallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;

abstract class Line implements Mappable {

    private final double[][] locations;

    protected Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        ConsoleStyler.styleOutput("Render " + this + " as "+
                          getClass().getSuperclass().getSimpleName().toUpperCase() +
                          " (" + printLocation() + ")");
    }

    private String printLocation() {
        return Arrays.deepToString(locations);
    }
}

