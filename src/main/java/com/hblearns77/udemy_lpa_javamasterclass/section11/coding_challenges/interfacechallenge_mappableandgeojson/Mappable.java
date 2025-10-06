package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.interfacechallenge_mappableandgeojson;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public interface Mappable {

    String JSON_PROPERTY = "\"properties\": \"{%s}\"";

    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJSON() {

        return "\"type\": \"%s\", \"label\": \"%s\", \"marker\": \"%s\"".formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        ConsoleStyler.styleOutput(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
