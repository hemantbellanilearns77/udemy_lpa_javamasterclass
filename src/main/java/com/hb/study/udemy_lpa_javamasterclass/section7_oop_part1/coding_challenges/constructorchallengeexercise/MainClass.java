package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args) {

        //Test 1: Calling Constructor with 3 arguments

        Customer firstCustomer = new Customer("Tim", 20000000.00, "tim@gmail.com");
        ConsoleStyler.styleOutput("First Customer's details are: \n" + firstCustomer +
                "\n******************************************************************************************************************************************************");
        /*ConsoleStyler.styleOutput(customer.getName());
        ConsoleStyler.styleOutput(customer.getCredit_limit());
        ConsoleStyler.styleOutput(customer.getEmailaddress());*/
        //ConsoleStyler.styleOutput(firstCustomer);

        //Test 2: Calling Empty Constructor
        Customer secondCustomer = new Customer();
        ConsoleStyler.styleOutput("Second Customer's details are:  \n" + secondCustomer +
                "\n******************************************************************************************************************************************************");
/*        ConsoleStyler.styleOutput(secondCustomer.getName());
        ConsoleStyler.styleOutput(secondCustomer.getCredit_limit());
        ConsoleStyler.styleOutput(secondCustomer.getEmailaddress());*/
        //ConsoleStyler.styleOutput(secondCustomer);

        //Test 3: Calling Constructor with 2 arguments
        Customer thirdCustomer = new Customer("Hemant", "hemantbellani@gmail.com");
        ConsoleStyler.styleOutput("Third Customer's details are:  \n" + thirdCustomer +
                "\n******************************************************************************************************************************************************");
     /*   ConsoleStyler.styleOutput(thirdCustomer.getName());
        ConsoleStyler.styleOutput(thirdCustomer.getCredit_limit());
        ConsoleStyler.styleOutput(thirdCustomer.getEmailaddress());*/
        //ConsoleStyler.styleOutput(thirdCustomer);
    }
}
