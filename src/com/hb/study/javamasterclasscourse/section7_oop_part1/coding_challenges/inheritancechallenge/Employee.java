package com.hb.study.javamasterclasscourse.section7_oop_part1.coding_challenges.inheritancechallenge;

public class Employee extends Worker{
    private static long employeeID = 1;
    private String hireDate;

    public Employee(String name, String birthDate, String endDate, String hireDate) {
        super(name, birthDate, endDate);
        Employee.employeeID++;
        this.hireDate = hireDate;
    }
    @Override
    public String toString() {
        return "Employee Details for: " + getName() + " {" +
                "employeeID=" + employeeID +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
