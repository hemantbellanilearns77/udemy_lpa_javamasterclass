package com.hb.study.javamasterclasscourse.section7_oop_part1.coding_challenges.classeschallenge_bankaccount;

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

        System.out.println("Details of Account : \n");
        System.out.println("Customer Name : " + myAccount.getCustomerName());
        System.out.println("Customer Account Number : " + myAccount.getAccountNumber());
        System.out.println("Customer Name : " + myAccount.getCustomerEmail());
        System.out.println("Customer Name : " + myAccount.getCustomerPhoneNumber());

        Account anotherAccount = new Account(
                900000000,
                "Hemant Bellani",
                "hemantbellani@gmail.com",
                "98117860808");
        System.out.println("Details of Another Account : \n");
        System.out.println("Customer Name : " + anotherAccount.getCustomerName());
        System.out.println("Customer Account Number : " + anotherAccount.getAccountNumber());
        System.out.println("Customer Name : " + anotherAccount.getCustomerEmail());
        System.out.println("Customer Name : " + anotherAccount.getCustomerPhoneNumber());
    }
}
