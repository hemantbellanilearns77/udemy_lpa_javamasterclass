package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.constructorchallengeexercise;

public class MainClass {
    public static void main(String[] args) {

        //Test 1: Calling Constructor with 3 arguments

        Customer firstCustomer = new Customer("Tim", 20000000.00, "tim@gmail.com");
        System.out.println("First Customer's details are: \n" + firstCustomer +
                "\n******************************************************************************************************************************************************");
        /*System.out.println(customer.getName());
        System.out.println(customer.getCredit_limit());
        System.out.println(customer.getEmailaddress());*/
        //System.out.println(firstCustomer);

        //Test 2: Calling Empty Constructor
        Customer secondCustomer = new Customer();
        System.out.println("Second Customer's details are:  \n" + secondCustomer +
                "\n******************************************************************************************************************************************************");
/*        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getCredit_limit());
        System.out.println(secondCustomer.getEmailaddress());*/
        //System.out.println(secondCustomer);

        //Test 3: Calling Constructor with 2 arguments
        Customer thirdCustomer = new Customer("Hemant", "hemantbellani@gmail.com");
        System.out.println("Third Customer's details are:  \n" + thirdCustomer +
                "\n******************************************************************************************************************************************************");
     /*   System.out.println(thirdCustomer.getName());
        System.out.println(thirdCustomer.getCredit_limit());
        System.out.println(thirdCustomer.getEmailaddress());*/
        //System.out.println(thirdCustomer);
    }
}
