package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.coding_challenges.genericsclasschallenge;

public interface Mappable {

    void render();

    static double[] stringToLatLon(String location) {

        var splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lng = Double.parseDouble(splits[1]);
        return new double[]{lat, lng};
    }
}

