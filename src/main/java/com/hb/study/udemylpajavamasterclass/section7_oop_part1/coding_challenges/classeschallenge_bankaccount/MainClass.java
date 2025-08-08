package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.classeschallenge_bankaccount;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args) {
        Account myAccount = new Account();
        //myAccount.setNumber("12345");
        myAccount.setCustomerName("Hemant Bellani");
        myAccount.setCustomerEmail("hemantbellani@gmail.com");
        myAccount.setCustomerPhoneNumber("9811786080");
        myAccount.withdrawFunds(100.0);
        myAccount.depositFunds(250.0);
        myAccount.withdrawFunds(50.0);
        myAccount.withdrawFunds(200.0);
        myAccount.depositFunds(100.0);
        myAccount.withdrawFunds(45.55);
        myAccount.withdrawFunds(54.46);
        myAccount.withdrawFunds(54.45);

        ConsoleStyler.styleOutput("Details of Account : \n");
        ConsoleStyler.styleOutput("Customer Name : " + myAccount.getCustomerName());
        ConsoleStyler.styleOutput("Customer Account Number : " + myAccount.getAccountNumber());
        ConsoleStyler.styleOutput("Customer Name : " + myAccount.getCustomerEmail());
        ConsoleStyler.styleOutput("Customer Name : " + myAccount.getCustomerPhoneNumber());

        Account anotherAccount = new Account(
                900000000,
                "Hemant Bellani",
                "hemantbellani@gmail.com",
                "98117860808");
        ConsoleStyler.styleOutput("Details of Another Account : \n");
        ConsoleStyler.styleOutput("Customer Name : " + anotherAccount.getCustomerName());
        ConsoleStyler.styleOutput("Customer Account Number : " + anotherAccount.getAccountNumber());
        ConsoleStyler.styleOutput("Customer Name : " + anotherAccount.getCustomerEmail());
        ConsoleStyler.styleOutput("Customer Name : " + anotherAccount.getCustomerPhoneNumber());
    }
}
