package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.recordsampleproject;

public record LPAJPMStudent(String id, String name, String dateOfBirth, String classList) {
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
