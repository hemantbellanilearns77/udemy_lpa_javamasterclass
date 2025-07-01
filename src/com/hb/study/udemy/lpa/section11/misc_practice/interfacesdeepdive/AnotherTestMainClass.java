package com.hb.study.udemy.lpa.section11.misc_practice.interfacesdeepdive;


public class AnotherTestMainClass {

    public static void main(String[] args) {

        inFlight(new Jet());

//        OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());
    }

    private static void inFlight(FlightEnabled flier) {

        flier.takeOff();
        flier.transition(FlightStages.LAUNCH_OR_TAKEOFF);
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {

        flier.takeOff();
        flier.fly();
        flier.land();
    }
}
