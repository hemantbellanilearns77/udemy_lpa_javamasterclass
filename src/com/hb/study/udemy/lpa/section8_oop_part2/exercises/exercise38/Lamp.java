package com.hb.study.udemy.lpa.section8_oop_part2.exercises.exercise38;

public class Lamp {
    private String style;
    private boolean battery;
    private int globRating;

    public Lamp(String style, boolean battery, int globRating) {
        this.style = style;
        this.battery = battery;
        this.globRating = globRating;
    }
    public void turnOn(){
        System.out.println("Lamp is being turned on.......");
    }
    public int getGlobRating() {
        return this.globRating;
    }
    public String getStyle() {
        return style;
    }
    public boolean isBattery() {
        return battery;
    }
}
