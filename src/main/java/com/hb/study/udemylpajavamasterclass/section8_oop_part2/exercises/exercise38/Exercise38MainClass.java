package com.hb.study.udemylpajavamasterclass.section8_oop_part2.exercises.exercise38;

public class Exercise38MainClass {

    public static void main(String[] args) {
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, 55);
        Bed bed = new Bed("Modern", 4, 3, 2, 1);
        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedRoom = new Bedroom("Room Name Here",
                wall1, wall2, wall3, wall4,
                ceiling,bed,
                lamp);

        bedRoom.makeBed();
        bedRoom.getLamp().turnOn();
    }
}
