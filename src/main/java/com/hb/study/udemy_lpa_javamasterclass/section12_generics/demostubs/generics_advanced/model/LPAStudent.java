package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.model;

import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.util.*;

public class LPAStudent extends Student implements QueryItem {

    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
