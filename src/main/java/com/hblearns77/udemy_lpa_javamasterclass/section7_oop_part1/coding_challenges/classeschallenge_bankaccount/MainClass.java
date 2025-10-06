package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.classeschallenge_bankaccount;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass {

    private static final String CUSTOMER_NAME = "Customer Name : ";
    private static final String CUSTOMER_ACCOUNT_NUMBER = "Customer Account Number : ";

        public static void main(String[] args) {
        //
        Account myAccount = new Account();
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

        ConsoleStyler.styleOutput("Details of Account : CommonConstants.NEWLINE");
        ConsoleStyler.styleOutput(CUSTOMER_NAME + myAccount.getCustomerName());
        ConsoleStyler.styleOutput(CUSTOMER_ACCOUNT_NUMBER + myAccount.getAccountNumber());
        ConsoleStyler.styleOutput(CUSTOMER_NAME + myAccount.getCustomerEmail());
        ConsoleStyler.styleOutput(CUSTOMER_NAME + myAccount.getCustomerPhoneNumber());

        Account anotherAccount = new Account(
                900000000,
                "Hemant Bellani",
                "hemantbellani@gmail.com",
                "98117860808");
        ConsoleStyler.styleOutput("Details of Another Account : CommonConstants.NEWLINE");
        ConsoleStyler.styleOutput(CUSTOMER_NAME + anotherAccount.getCustomerName());
        ConsoleStyler.styleOutput(CUSTOMER_ACCOUNT_NUMBER + anotherAccount.getAccountNumber());
        ConsoleStyler.styleOutput(CUSTOMER_NAME + anotherAccount.getCustomerEmail());
        ConsoleStyler.styleOutput(CUSTOMER_NAME + anotherAccount.getCustomerPhoneNumber());
    }
}
