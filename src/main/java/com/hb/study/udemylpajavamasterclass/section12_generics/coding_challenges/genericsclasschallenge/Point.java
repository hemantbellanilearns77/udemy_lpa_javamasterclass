package com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.genericsclasschallenge;

import java.util.Arrays;

abstract class Point implements Mappable {

    private double[] location; //= new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {

        System.out.println("Render " + this + " as " +
                getClass().getSuperclass().getSimpleName().toUpperCase() +
                " (" + printLocation() + ")");
    }

    private String printLocation() {
        return Arrays.toString(location);
    }
}



