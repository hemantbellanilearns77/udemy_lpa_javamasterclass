package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson;

public class Building implements Mappable {

    private final String name;
    private final UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarker.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointMarker.PUSH_PIN;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + "name: %s ; usage: %s" .formatted(name, usage);
    }
}
