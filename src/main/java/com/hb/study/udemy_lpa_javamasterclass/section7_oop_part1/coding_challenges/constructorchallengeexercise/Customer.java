package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Customer {

    private String name;
    private double credit_limit;
    private String emailaddress;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", credit_limit=" + credit_limit +
                ", emailaddress='" + emailaddress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public double getCredit_limit() {
        return credit_limit;
    }
    public String getEmailaddress() {
        return emailaddress;
    }

    public Customer() { // No Args Constructor
        this("Default", 400000, "Default@email.com");
        ConsoleStyler.styleOutput("Empty Constructor invoked");
    }

    public Customer(String name, String emailaddress) {
        this(name, 400000, emailaddress);
        ConsoleStyler.styleOutput("Constructor with 2 arguments invoked");
    }

    public Customer(String name, double credit_limit, String emailaddress) { // All args constructor
        ConsoleStyler.styleOutput("All-args constructor with all 3 arguments invoked");
        this.name = name;
        this.credit_limit = credit_limit;
        this.emailaddress = emailaddress;
    }
}
