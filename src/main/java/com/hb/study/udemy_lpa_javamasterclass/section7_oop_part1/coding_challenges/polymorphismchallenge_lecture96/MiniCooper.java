package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


class MiniCooper extends Car{
    public MiniCooper(int cylinders, String name) {
        super(cylinders,name);
    }
    public void startEngine() {
        ConsoleStyler.styleOutput("startEngine() inside MiniCooper class invoked");
    }
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() inside MiniCooper class invoked");
    }
    public void brake(){
        ConsoleStyler.styleOutput("brake() inside MiniCooper class invoked");
    }
}