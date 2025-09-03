package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise38;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
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
        ConsoleStyler.styleOutput("Lamp is being turned on.......");
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
