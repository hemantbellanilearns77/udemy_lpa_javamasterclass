package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;

public class UtilityLine implements Mappable {

    private final String name;
    private final UtilityType utilityType;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.utilityType = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + utilityType + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (utilityType) {
            case  ELECTRICAL-> Color.RED + CommonConstants.EMPTYSTRING + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + CommonConstants.EMPTYSTRING + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + CommonConstants.EMPTYSTRING + LineMarker.SOLID;
            case WATER -> Color.BLUE + CommonConstants.EMPTYSTRING + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + ", \"name\": \"%s\", \"utility\": \"%s\" ".formatted(name, utilityType);
    }
}
