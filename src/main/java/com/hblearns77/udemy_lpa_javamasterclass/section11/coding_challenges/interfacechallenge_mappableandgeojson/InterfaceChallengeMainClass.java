package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.List;

public class InterfaceChallengeMainClass {

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        List<Mappable> mappableList = new ArrayList<>();

        mappableList.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappableList.add(new Building("Sydney Opera House",
                UsageType.ENTERTAINMENT));
        mappableList.add(new Building("Stadium Australia", UsageType.SPORTS));

        mappableList.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappableList.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for (var m : mappableList) {
            Mappable.mapIt(m);
        }
        execution.finalizeExecution();
    }
}