package com.hb.study.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stage){
      ConsoleStyler.styleOutput("transition not implemented on " + getClass().getSimpleName());
        FlightStages nextStage = stage.getNextStage();
        ConsoleStyler.styleOutput("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }

}
