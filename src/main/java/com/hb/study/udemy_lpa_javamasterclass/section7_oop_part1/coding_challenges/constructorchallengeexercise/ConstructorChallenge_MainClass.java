package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ConstructorChallenge_MainClass {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }

        //Test 1: Calling Constructor with 3 arguments

        Customer firstCustomer = new Customer("Tim", 20000000.00, "tim@gmail.com");
        ConsoleStyler.styleOutput("First Customer's details are: \n" + firstCustomer);
        ConsoleStyler.styleOutput(firstCustomer.getName());
        ConsoleStyler.styleOutput(firstCustomer.getCredit_limit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(firstCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(firstCustomer.toString());
        ConsoleStyler.divider();
        //Test 2: Calling Empty Constructor
        Customer secondCustomer = new Customer();
        ConsoleStyler.styleOutput("Second Customer's details are:  \n" + secondCustomer);
        ConsoleStyler.styleOutput(secondCustomer.getName());
        ConsoleStyler.styleOutput(secondCustomer.getCredit_limit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(secondCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(secondCustomer.toString());
        ConsoleStyler.divider();
        //Test 3: Calling Constructor with 2 arguments
        Customer thirdCustomer = new Customer("Hemant", "hemantbellani@gmail.com");
        ConsoleStyler.styleOutput("Third Customer's details are:  \n" + thirdCustomer);
        ConsoleStyler.styleOutput(thirdCustomer.getName());
        ConsoleStyler.styleOutput(thirdCustomer.getCredit_limit() + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput(thirdCustomer.getEmailaddress());
        ConsoleStyler.styleOutput(thirdCustomer.toString());
        ConsoleStyler.divider();
    }
}
