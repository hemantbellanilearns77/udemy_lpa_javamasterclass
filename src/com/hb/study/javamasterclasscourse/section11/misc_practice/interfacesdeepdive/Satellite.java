package com.hb.study.javamasterclasscourse.section11.misc_practice.interfacesdeepdive;

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

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}