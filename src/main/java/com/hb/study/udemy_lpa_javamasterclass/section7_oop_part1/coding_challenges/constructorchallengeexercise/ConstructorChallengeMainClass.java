package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class ConstructorChallengeMainClass {
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);        //Test 1: Calling Constructor with 3 arguments

        Customer firstCustomer = new Customer("Tim", 20000000.00, "tim@gmail.com");
        ConsoleStyler.styleOutput("First Customer's details are: CommonConstants.NEWLINE" + firstCustomer);
        ConsoleStyler.styleOutput(firstCustomer.getName());
        ConsoleStyler.styleOutput(firstCustomer.getCreditLimit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(firstCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(firstCustomer.toString());
        ConsoleStyler.divider();
        //Test 2: Calling Empty Constructor
        Customer secondCustomer = new Customer();
        ConsoleStyler.styleOutput("Second Customer's details are:  CommonConstants.NEWLINE" + secondCustomer);
        ConsoleStyler.styleOutput(secondCustomer.getName());
        ConsoleStyler.styleOutput(secondCustomer.getCreditLimit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(secondCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(secondCustomer.toString());
        ConsoleStyler.divider();
        //Test 3: Calling Constructor with 2 arguments
        Customer thirdCustomer = new Customer("Hemant", "hemantbellani@gmail.com");
        ConsoleStyler.styleOutput("Third Customer's details are:  CommonConstants.NEWLINE" + thirdCustomer);
        ConsoleStyler.styleOutput(thirdCustomer.getName());
        ConsoleStyler.styleOutput(thirdCustomer.getCreditLimit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(thirdCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(thirdCustomer.toString());
        ConsoleStyler.divider();
        execution.finalizeExecution();
    }
}
