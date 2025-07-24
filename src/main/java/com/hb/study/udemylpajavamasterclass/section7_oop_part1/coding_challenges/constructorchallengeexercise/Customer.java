package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

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
        System.out.println("Empty Constructor invoked");
    }

    public Customer(String name, String emailaddress) {
        this(name, 400000, emailaddress);
        System.out.println("Constructor with 2 arguments invoked");
    }

    public Customer(String name, double credit_limit, String emailaddress) { // All args constructor
        System.out.println("All-args constructor with all 3 arguments invoked");
        this.name = name;
        this.credit_limit = credit_limit;
        this.emailaddress = emailaddress;
    }
}
