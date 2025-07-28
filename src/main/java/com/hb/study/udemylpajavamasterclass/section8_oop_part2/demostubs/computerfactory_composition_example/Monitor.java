package com.hb.study.udemylpajavamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

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
        System.out.println(String.format("Drawing Pixel at %d %d %s", x, y, color));
    }

}
