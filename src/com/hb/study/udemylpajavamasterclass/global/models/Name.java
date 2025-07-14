package com.hb.study.udemylpajavamasterclass.global.models;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 12-07-2025, 12:02 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class Name {
    //Object level or Static declarations here...
    public static ExcecutionUtil execution = executionSetup();
    String firstName;
    String lastName;

    public Name(String fullName, String lastName) {
        this.firstName = fullName;
        this.lastName = lastName;
    }
    public Name(Name name) {
        this.firstName = name.firstName;
        this.lastName = name.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {

        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        /*
         *****************************************************
         */
        //your code comes in here
        /*

         ******************************************************
         */
        execution.executionWindDown();
    }

    public static ExcecutionUtil executionSetup() {
        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        return executionUtil;
    }
}
