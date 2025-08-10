package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class Monitor extends Product{
    private int size;
    private String resolution;

    public Monitor(String model, String manufacturer) {
        super(model,manufacturer);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                super.toString() +
                "size=" + size +
                "size=" + size +
                ", resolution='" + resolution + '\'' +
                "} ";
    }

    public Monitor(String model, String  manufacturer, int size, String resolution) {
        this(model, manufacturer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color){
        ConsoleStyler.styleOutput(String.format("Drawing Pixel at %d %d %s", x, y, color));
    }

}
