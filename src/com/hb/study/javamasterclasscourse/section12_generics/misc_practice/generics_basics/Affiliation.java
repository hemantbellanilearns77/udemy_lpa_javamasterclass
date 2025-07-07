package com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_basics;

record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
