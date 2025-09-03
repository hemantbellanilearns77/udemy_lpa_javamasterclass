package com.hb.study.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class AnotherTestMainClass {

        public static void main(String[] ignoredUnusedArgs) {
        //

        inFlight(new Jet());
            ConsoleStyler.styleExecutionInsight("""
                    The below line would bring compile error as log method of OrbitEarth Object is declared private:
                    //       OrbitEarth.log("Testing " + new Satellite());
                    """);


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
