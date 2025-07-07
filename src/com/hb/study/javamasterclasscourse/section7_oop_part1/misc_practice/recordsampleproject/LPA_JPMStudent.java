package com.hb.study.javamasterclasscourse.section7_oop_part1.misc_practice.recordsampleproject;

public record LPA_JPMStudent(String id, String name, String dateOfBirth, String classList) {
    @Override
    public String toString() {
        return "Another Record of JPMStudent is: {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", classList='" + classList + '\'' +
                '}';
    }
}
