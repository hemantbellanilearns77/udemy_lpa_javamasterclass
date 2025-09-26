package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.model;

import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.util.*;

import java.security.SecureRandom;

public class Student implements QueryItem, com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.util.QueryItem {

    private final String name;
    private final String course;
    private final int yearStarted;

    protected static SecureRandom secureRandom = new SecureRandom();

    private static final String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static final String[] courses = {"C++", "Java", "Python"};

    public Student() {
        int lastNameIndex = secureRandom.nextInt(65, 91);
        name = firstNames[secureRandom.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[secureRandom.nextInt(3)];
        yearStarted = secureRandom.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fname = fieldName.toUpperCase();
        return switch(fname) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
