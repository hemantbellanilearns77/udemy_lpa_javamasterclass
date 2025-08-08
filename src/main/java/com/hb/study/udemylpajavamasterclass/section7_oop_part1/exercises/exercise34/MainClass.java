package com.hb.study.udemylpajavamasterclass.section7_oop_part1.exercises.exercise34;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args) {
        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator = new Calculator(floor, carpet);
        ConsoleStyler.styleOutput("total= " + calculator.getTotalCost());
        carpet = new Carpet(1.5);
        floor = new Floor(5.4, 4.5);
        calculator = new Calculator(floor, carpet);
        ConsoleStyler.styleOutput("total= " + calculator.getTotalCost());
    }
}
