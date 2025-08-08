package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

enum FlightStages implements Trackable {GROUNDED, LAUNCH_OR_TAKEOFF, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if (this != GROUNDED) {
            ConsoleStyler.styleOutput("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return (allStages[(ordinal() + 1) % allStages.length] );
    }
}
