package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Jet implements FlightEnabled, Trackable {

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

    @Override
    public FlightStages transition(FlightStages stage) {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + " is transitioning between flight stages.. ");
        return FlightEnabled.super.transition(stage);
    }
}
