package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

public class HourlyEmployee extends Employee{

    private double hourlyPayRate;
    private String employeeID;
    public HourlyEmployee(String name, String birthDate, String endDate, String employeeID, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        setHourlyPayRate(hourlyPayRate);
        setEmployeeID(employeeID);

    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "employeeID=" + getEmployeeID() +
                "hourlyPayRate=" + getHourlyPayRate() +
                '}';
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
