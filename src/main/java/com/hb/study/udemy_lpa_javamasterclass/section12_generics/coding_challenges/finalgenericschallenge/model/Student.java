package com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.model;


import com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.util.*;

import java.security.SecureRandom;

public class Student implements QueryItem, Comparable<Student> {

    private static int lastID = 10_000;
    private final int studentId;

    private final String name;
    private final String course;
    private final int yearStarted;

    protected static SecureRandom secureRandom = new SecureRandom();

    private static final String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static final String[] courses = {"C++", "Java", "Python"};

    public Student() {
        studentId = lastID++;
        int lastNameIndex = secureRandom.nextInt(65, 91);
        name = firstNames[secureRandom.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[secureRandom.nextInt(3)];
        yearStarted = secureRandom.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, getYearStarted());
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(studentId, o.studentId);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student other)) return false;
        return this.studentId == other.studentId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(studentId);
    }
}

