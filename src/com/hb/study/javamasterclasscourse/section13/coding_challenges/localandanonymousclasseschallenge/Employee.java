package com.hb.study.javamasterclasscourse.section13.coding_challenges.localandanonymousclasseschallenge;

/**
 * created by : heman on 08-07-2025, 05:03 PM, in the "udemy_lpa_javamasterclass" project
 **/
public record Employee(String firstName, String lastName, String hireDate) {
    @Override
    public String toString() {
        return "%s %s was hired on %s".formatted(firstName,lastName,hireDate);
    }
}
