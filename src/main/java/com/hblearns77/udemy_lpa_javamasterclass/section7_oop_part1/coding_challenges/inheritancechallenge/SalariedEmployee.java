package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class SalariedEmployee extends Employee {
    private final double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate,
                             String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
   public double collectPay() {

        return isRetired ?  (annualSalary / 12 ) / 2 : (annualSalary / 12 );
   }

    public void retire(){
        if(super.getAge() > 70) {
            this.isRetired = true;
            super.terminate(this.getLwdDate());
            ConsoleStyler.styleOutput(super.getName() + " is now retired! Wish you a healthy life ahead at " + super.getAge()
                    + " years of age");
        } else {
            ConsoleStyler.styleOutput("Not yet retirable age");
        }
    }

    @Override
    public String toString() {
        return  getName() + " is a Salaried Employee with" +
                "\nannualSalary: " + annualSalary +
                " and is " + (isRetired ? "now retired" : "not yet retired and still employed");
    }
}
