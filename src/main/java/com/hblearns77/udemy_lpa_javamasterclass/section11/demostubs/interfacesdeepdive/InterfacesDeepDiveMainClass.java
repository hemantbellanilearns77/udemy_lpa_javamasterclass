package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.LinkedList;
import java.util.List;

public class InterfacesDeepDiveMainClass {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {

        execution.initialize(args);
        Bird bird = new Bird();
        Animal animal;
        animal = bird;
        FlightEnabled flier;
        flier = bird;
        Trackable tracked;
        tracked = bird;

        animal.move();

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();

        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        ConsoleStyler.styleOutput("The truck traveled %.2f miles which equals ".formatted(milesTraveled));
        kmsTraveled = milesTraveled * FlightEnabled.MILES_TO_KM;
        ConsoleStyler.styleOutput("%.2f kms%n".formatted(kmsTraveled));

        ConsoleStyler.divider();
        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
        ConsoleStyler.divider();

        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

    //

    private static void inFlight(FlightEnabled flier) {

        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.land();
        }
    }
}
