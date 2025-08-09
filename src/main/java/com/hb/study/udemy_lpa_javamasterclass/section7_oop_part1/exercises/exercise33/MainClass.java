package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise33;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args) {
        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        ConsoleStyler.styleOutput("distance(0,0)= " + first.distance());
        ConsoleStyler.styleOutput("distance(second)= " + first.distance(second));
        ConsoleStyler.styleOutput("distance(2,2)= " + first.distance(2, 2));
        Point point = new Point();
        ConsoleStyler.styleOutput("distance()= " + point.distance());
    }
}
