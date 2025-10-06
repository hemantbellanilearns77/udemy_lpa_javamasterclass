package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

 import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
class Jeep extends Car{
    private static final String INSIDE_JEEP_CLASS_INVOKED = "inside Jeep class invoked";

    public Jeep(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public void startEngine() {
        ConsoleStyler.styleOutput("startEngine() " + INSIDE_JEEP_CLASS_INVOKED);
    }
    @Override
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() " + INSIDE_JEEP_CLASS_INVOKED);
    }
    @Override
    public void brake(){
        ConsoleStyler.styleOutput("brake() " + INSIDE_JEEP_CLASS_INVOKED);
    }
}