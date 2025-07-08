package com.hb.study.udemylpajavamasterclass.section12_generics.misc_practice.generics_basics;

record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
