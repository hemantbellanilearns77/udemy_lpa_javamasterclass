package com.hb.study.javamasterclasscourse.section12_generics.coding_challenges.genericsclasschallenge;

import java.util.Arrays;

abstract class Line implements Mappable {

    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as "+
                          getClass().getSuperclass().getSimpleName().toUpperCase() +
                          " (" + printLocation() + ")");
    }

    private String printLocation() {
        return Arrays.deepToString(locations);
    }
}

