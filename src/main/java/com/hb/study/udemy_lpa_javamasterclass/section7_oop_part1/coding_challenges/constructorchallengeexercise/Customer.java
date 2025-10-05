package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class Customer {

    private final String name;
    private final double creditLimit;
    private final String emailAddress;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", credit_limit=" + creditLimit +
                ", emailaddress='" + emailAddress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public String getEmailaddress() {
        return emailAddress;
    }

    public Customer() { // No args Constructor
        this("Default", 400000, "Default@email.com");
        ConsoleStyler.styleOutput("Empty Constructor invoked");
    }

    public Customer(String name, String emailaddress) {
        this(name, 400000, emailaddress);
        ConsoleStyler.styleOutput("Constructor with 2 arguments invoked");
    }

    public Customer(String name, double ceditLimit, String emailaddress) { // All args constructor
        ConsoleStyler.styleOutput("All-args constructor with all 3 arguments invoked");
        this.name = name;
        this.creditLimit = ceditLimit;
        this.emailAddress = emailaddress;
    }
}
