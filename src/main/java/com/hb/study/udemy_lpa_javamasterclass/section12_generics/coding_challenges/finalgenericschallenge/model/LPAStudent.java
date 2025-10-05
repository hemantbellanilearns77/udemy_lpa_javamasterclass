package com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.model;

import java.util.Objects;

public class LPAStudent extends Student {

    private final double percentComplete;

    public LPAStudent() {
        percentComplete = secureRandom.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LPAStudent that = (LPAStudent) o;
        return Double.compare(percentComplete, that.percentComplete) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percentComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Integer.parseInt(value);
        }

        return super.matchFieldValue(fieldName, value);
    }
}

