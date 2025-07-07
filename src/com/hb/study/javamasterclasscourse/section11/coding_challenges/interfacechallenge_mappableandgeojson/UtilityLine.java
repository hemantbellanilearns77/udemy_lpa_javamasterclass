package com.hb.study.javamasterclasscourse.section11.coding_challenges.interfacechallenge_mappableandgeojson;

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType utilityType;

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
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "utility": "%s" """.formatted(name, utilityType);
    }
}
