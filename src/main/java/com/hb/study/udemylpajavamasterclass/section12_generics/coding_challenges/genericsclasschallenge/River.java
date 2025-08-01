package com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.genericsclasschallenge;


public class River extends Line {

    private String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " River";
    }
}
