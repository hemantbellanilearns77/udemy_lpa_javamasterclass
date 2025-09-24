package com.hb.study.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import java.util.Comparator;

public class Employee {
    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public static class EmployeeComparator
            implements Comparator<Employee> {

        private final String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }

            return o1.name.compareTo(o2.name);
        }
    }



    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
