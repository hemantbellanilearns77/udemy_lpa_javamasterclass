package com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.model;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}
