package com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.model;

import com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.util.*;

import java.util.Random;

public class Student implements QueryItem, com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.finalgenericschallenge.util.QueryItem {

    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
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
