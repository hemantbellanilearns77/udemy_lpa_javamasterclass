package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise32;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass {
        public static void main(String[] args) {

        Wall wall = new Wall(5,4);
        ConsoleStyler.styleOutput("area= " + wall.getArea());

        wall.setHeight(-1.5);
        ConsoleStyler.styleOutput("width= " + wall.getWidth());
        ConsoleStyler.styleOutput("height= " + wall.getHeight());
        ConsoleStyler.styleOutput("area= " + wall.getArea());
    }
}
