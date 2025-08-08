package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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