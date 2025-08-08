package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Bird extends Animal implements FlightEnabled, Trackable {

    @Override
    public void move() {
        ConsoleStyler.styleOutput("Flaps wings");
    }

    @Override
    public void takeOff() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
