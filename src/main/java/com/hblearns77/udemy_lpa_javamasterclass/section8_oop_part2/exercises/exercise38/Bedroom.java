package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise38;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Bedroom {
    private final String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private final Ceiling ceiling;
    private final Bed bed;
    private final Lamp lamp;

    @Override
    public String toString() {
        return "Bedroom{" +
                "name='" + name + '\'' +
                ", wall1=" + wall1 +
                ", wall2=" + wall2 +
                ", wall3=" + wall3 +
                ", wall4=" + wall4 +
                ", ceiling=" + ceiling +
                ", bed=" + bed +
                ", lamp=" + lamp +
                '}';
    }

    public Bedroom(String name, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp(){
        return this.lamp;
    }

    public void makeBed(){
        ConsoleStyler.styleOutput("the bed is being made");
        this.bed.make();
    }

    public void setWalls(Wall wall1, Wall wall2, Wall wall3, Wall wall4) {
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
    }
}
