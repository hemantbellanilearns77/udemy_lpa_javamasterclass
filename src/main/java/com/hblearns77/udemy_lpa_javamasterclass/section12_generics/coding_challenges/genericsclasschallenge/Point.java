package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.coding_challenges.genericsclasschallenge;

 import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import java.util.Arrays;

abstract class Point implements Mappable {

    private final double[] location;

    protected Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {

        ConsoleStyler.styleOutput("Render " + this + " as " +
                getClass().getSuperclass().getSimpleName().toUpperCase() +
                " (" + printLocation() + ")");
    }

    private String printLocation() {
        return Arrays.toString(location);
    }
}



