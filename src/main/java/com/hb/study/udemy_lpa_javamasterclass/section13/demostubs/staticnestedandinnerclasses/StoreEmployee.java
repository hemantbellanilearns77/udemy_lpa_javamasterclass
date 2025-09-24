package com.hb.study.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }

    String getStore() {   // package-private getter
        return store;
    }
    public class StoreComparator<T extends StoreEmployee>
            implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            int result = o1.getStore().compareTo(o2.getStore());
            if (result == 0) {
                return new Employee.EmployeeComparator("yearStarted").compare(o1, o2);
            }
            return result;
        }
    }

}
