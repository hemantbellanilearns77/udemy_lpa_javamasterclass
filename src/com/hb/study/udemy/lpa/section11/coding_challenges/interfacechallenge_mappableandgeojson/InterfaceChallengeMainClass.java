package com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson;

import java.util.ArrayList;
import java.util.List;

public class InterfaceChallengeMainClass {

    public static void main(String[] args) {

        List<Mappable> mappableList = new ArrayList<>();

        mappableList.add(new Building("Sydney Town Hall", com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UsageType.GOVERNMENT));
        mappableList.add(new Building("Sydney Opera House",
                com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UsageType.ENTERTAINMENT));
        mappableList.add(new Building("Stadium Australia", com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UsageType.SPORTS));

        mappableList.add(new com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UtilityLine("College St", com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UtilityType.FIBER_OPTIC));
        mappableList.add(new com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UtilityLine("Olympic Blvd", com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.UtilityType.WATER));

        for (var m : mappableList) {
            com.hb.study.udemy.lpa.section11.coding_challenges.interfacechallenge_mappableandgeojson.Mappable.mapIt(m);
        }
    }
}