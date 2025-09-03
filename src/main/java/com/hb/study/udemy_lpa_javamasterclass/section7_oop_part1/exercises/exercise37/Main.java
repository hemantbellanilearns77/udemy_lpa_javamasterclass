package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise37;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Main {
        public static void main(String[] unusedArgs) {
        //
        Rectangle rectangle = new Rectangle(5, 10);
        ConsoleStyler.styleOutput("rectangle.width= " + rectangle.getWidth());
        ConsoleStyler.styleOutput("rectangle.length= " + rectangle.getLength());
        ConsoleStyler.styleOutput("rectangle.area= " + rectangle.getArea());
        Cuboid cuboid = new Cuboid(5,10,5);
        ConsoleStyler.styleOutput("cuboid.width= " + cuboid.getWidth());
        ConsoleStyler.styleOutput("cuboid.length= " + cuboid.getLength());
        ConsoleStyler.styleOutput("cuboid.area= " + cuboid.getArea());
        ConsoleStyler.styleOutput("cuboid.height= " + cuboid.getHeight());
        ConsoleStyler.styleOutput("cuboid.volume= " + cuboid.getVolume());
    }
}
