package com.hb.study.udemylpajavamasterclass.section11.misc_codedemo.interfacesdeepdive;

enum FlightStages implements Trackable {GROUNDED, LAUNCH_OR_TAKEOFF, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return (allStages[(ordinal() + 1) % allStages.length] );
    }
}
