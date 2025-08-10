package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class Jeep extends Car{
    public Jeep(int cylinders, String name) {
        super(cylinders, name);
    }
    public void startEngine() {
        ConsoleStyler.styleOutput("startEngine() inside Jeep class invoked");
    }
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() inside Jeep class invoked");
    }
    public void brake(){
        ConsoleStyler.styleOutput("brake() inside Jeep class invoked");
    }
}