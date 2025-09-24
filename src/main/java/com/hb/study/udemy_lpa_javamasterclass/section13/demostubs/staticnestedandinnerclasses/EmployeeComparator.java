package com.hb.study.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {

        return o1.getName().compareTo(o2.getName());
    }



}
