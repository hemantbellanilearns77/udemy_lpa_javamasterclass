package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

public class HourlyEmployee extends Employee{

    private double hourlyPayRate;
    public HourlyEmployee(String name, String birthDate, String endDate,
                          long ignoredEmployeeID, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        setHourlyPayRate(hourlyPayRate);
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
                "hourlyPayRate=" + getHourlyPayRate() +
                '}';
    }
}
