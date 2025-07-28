package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stage){
      /*  System.out.println("transition not implemented on " + getClass().getSimpleName());
        return null;*/
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }

}
