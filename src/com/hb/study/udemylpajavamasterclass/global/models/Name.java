package com.hb.study.udemylpajavamasterclass.global.models;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 12-07-2025, 12:02 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class Name {

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
        System.out.println(CommonConstants.PROGRAMOUTPUTBEGINSSTR);
        /*
         *****************************************************
         */
        //your code comes in here
        /*

         ******************************************************
         */
        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTR);
        System.out.println(CommonConstants.EXECUTIONSTATSINTROSTR);
        executionUtil.updateExecutionStats();
        System.out.println(executionUtil);
        System.out.println(CommonConstants.PROGRAMOUTPUTENDSSTR);
    }
}
