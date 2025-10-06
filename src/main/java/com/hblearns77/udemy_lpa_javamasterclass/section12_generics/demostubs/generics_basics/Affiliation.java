package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_basics;

public record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
