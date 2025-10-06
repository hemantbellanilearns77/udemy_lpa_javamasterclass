package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

public class Employee extends Worker{
    private static long employeeID = 1;
    private final String hireDate;

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
                ", birthdate='" + this.getBirthDate() + '\'' +
                "} " + super.toString();
    }
}
