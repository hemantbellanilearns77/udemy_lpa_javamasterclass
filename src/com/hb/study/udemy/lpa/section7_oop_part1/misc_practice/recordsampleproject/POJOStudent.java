package com.hb.study.udemy.lpa.section7_oop_part1.misc_practice.recordsampleproject;

public class POJOStudent {
    private String id;
    private String name;
    private String dateOfBirth;
    private String classList;



    public String getNam() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassList() {
        return classList;
    }

    public void setClassList(String classList) {
        this.classList = classList;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public POJOStudent(String id, String name, String dateOfBirth, String classList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + getId() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", classList='" + getClassList() + '\'' +
                '}';
    }
}
