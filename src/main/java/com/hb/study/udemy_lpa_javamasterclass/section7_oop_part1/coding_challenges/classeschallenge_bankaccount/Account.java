package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.classeschallenge_bankaccount;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.UUID;

/**
 *
 */
public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    public Account() { // Default Constructor
        this(0.00,"Unknown Customer","Unknown Customer Email Address","Unknown Customer Phone Number");
        ConsoleStyler.styleOutput(null,"Empty constructor called!" );
    }


    public Account(double balance, String customerName,
                   String customerEmail, String customerPhoneNumber) { // All Field  initializations Constructor
        setAccountNumber(UUID.randomUUID().toString().replace("-",""));
        setBalance(balance);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setCustomerPhoneNumber(customerPhoneNumber);
        ConsoleStyler.styleOutput(null,"Account constructor with 4 arguments called");
    }
    public Account(String customerName,
                   String customerEmail, String customerPhoneNumber) {
        this(0.00, customerName, customerEmail, customerPhoneNumber);
        ConsoleStyler.styleOutput(null,"Account constructor with 3 arguments called");

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String number) {
        this.accountNumber = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void withdrawFunds(double withdrawAmount){
        if( (this.getBalance() - withdrawAmount) < 0) {
            ConsoleStyler.styleOutput(null,"Insufficient Balance to support withdrawal.... ");
            ConsoleStyler.styleOutput(null,"You only have Rs. " + balance + " in your account");
        } else {
            this.setBalance(this.getBalance() - withdrawAmount);
            ConsoleStyler.styleOutput(null,"Amount successfully withdrawn: Rs. " + withdrawAmount +
                    "; The account balance after withdrawal is: Rs. " + balance);
        }
    }

    public void depositFunds(double depositAmount) {
        this.balance = this.balance + depositAmount;
        ConsoleStyler.styleOutput(null,"Amount successfully deposited: Rs. " + depositAmount +
                "; The account balance after deposit is: Rs. " + balance);
    }
}
