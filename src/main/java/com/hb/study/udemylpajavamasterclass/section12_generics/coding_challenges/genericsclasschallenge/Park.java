package com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.genericsclasschallenge;


public class Park extends Point {

    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " National Park";
    }
}
