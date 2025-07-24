package com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson;

public class Building implements com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.Mappable {

    private String name;
    private com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.UsageType usage;

    public Building(String name, com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.Geometry getShape() {
        return com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.PointMarker.SQUARE;
            case SPORTS -> Color.ORANGE + " " + com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.PointMarker.PUSH_PIN;
            default -> Color.BLACK + " " + com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.PointMarker.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return com.hb.study.udemylpajavamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson.Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, usage);
    }
}
