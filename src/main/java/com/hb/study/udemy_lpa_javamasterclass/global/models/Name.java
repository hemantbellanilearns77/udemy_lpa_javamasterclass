package com.hb.study.udemy_lpa_javamasterclass.global.models;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 12-07-2025, 12:02 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class Name {
    //Object level or Static declarations here...

    final String firstName;
    final String lastName;

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


}
