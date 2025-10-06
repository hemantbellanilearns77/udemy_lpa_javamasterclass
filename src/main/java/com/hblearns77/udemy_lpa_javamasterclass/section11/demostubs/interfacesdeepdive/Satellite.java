package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {

        transition("Taking Off");
    }

    @Override
    public void land() {

        transition("Landing");
    }

    @Override
    public void fly() {

        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description) {

        ConsoleStyler.styleOutput(description);
        stage = transition(stage);
        stage.track();
    }
}