package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

public class Product {
    private String model;
    private String manufacturer;
    public Product (String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'';
    }
}
