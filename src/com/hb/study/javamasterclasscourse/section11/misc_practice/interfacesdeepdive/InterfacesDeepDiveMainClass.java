package com.hb.study.javamasterclasscourse.section11.misc_practice.interfacesdeepdive;

import com.hb.study.javamasterclasscourse.globalcommon.constants.GlobalCommonConstants;
import com.hb.study.javamasterclasscourse.globalcommon.utils.ExcecutionUtil;

import java.util.LinkedList;
import java.util.List;

public class InterfacesDeepDiveMainClass {

    public static void main(String[] args) {
        System.out.println(GlobalCommonConstants.programOutputBegins);
        ExcecutionUtil executionUtil = new ExcecutionUtil();
        //executionTiming.setStartTime(System.nanoTime());
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f miles which equals ",
                milesTraveled);
        kmsTraveled = milesTraveled * FlightEnabled.MILES_TO_KM;
        System.out.printf("%.2f kms%n",
                kmsTraveled);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
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
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        executionUtil.updateExecutionStats();
        System.out.println(executionUtil);;
        System.out.println(GlobalCommonConstants.programOutputEnds);
    }

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
