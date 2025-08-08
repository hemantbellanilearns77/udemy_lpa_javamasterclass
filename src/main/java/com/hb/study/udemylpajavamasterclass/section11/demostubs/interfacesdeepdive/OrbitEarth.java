package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    private static void log(String description) {

        var today = new java.util.Date();
        ConsoleStyler.styleOutput(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {

        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {

        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}