package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

public class HourlyEmployee extends Employee{

    private double hourlyPayRate;
    public HourlyEmployee(String name, String birthDate, String endDate,
                          long employeeID, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getDoublePay() {
        double doublePayAmount = 0.0;

        return doublePayAmount;
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
                "hourlyPayRate=" + hourlyPayRate +
                "} " + super.toString();
    }
}
