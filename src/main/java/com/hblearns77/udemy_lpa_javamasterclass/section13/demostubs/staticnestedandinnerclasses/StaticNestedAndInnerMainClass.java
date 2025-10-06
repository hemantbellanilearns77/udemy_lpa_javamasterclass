package com.hblearns77.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaticNestedAndInnerMainClass {
    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {

        execution.initialize(args);
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)));

        var anotherComparator = new EmployeeComparator<>();
        employees.sort(anotherComparator);

        employees.sort(new Employee.EmployeeComparator("yearStarted")
                .reversed());

        for (Employee e : employees) {
            ConsoleStyler.styleOutput(e + CommonConstants.EMPTYSTRING);
        }
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("Store Members");
        List<StoreEmployee> storeEmployees = getStoreEmployees();

        for (StoreEmployee e : storeEmployees) {
            ConsoleStyler.styleOutput(e + CommonConstants.EMPTYSTRING);
        }
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("With Pig Latin NamesUtil");
        addPigLatinName(storeEmployees);
        ConsoleStyler.divider();

        execution.finalizeExecution();
    }

    private static List<StoreEmployee> getStoreEmployees() {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,
                        "Target"),
                new StoreEmployee(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bud", 2016,
                        "Target")));

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);
        return storeEmployees;
    }

    // method to demonstrate local inner/nested class
    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee> {

            private final String pigLatinName;
            private final Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof DecoratedEmployee other)) return false;
                return Objects.equals(this.pigLatinName, other.pigLatinName);
            }

            @Override
            public int hashCode() {
                return pigLatinName.hashCode();
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            ConsoleStyler.styleOutput(dEmployee.originalInstance.getName() + " "
                    + dEmployee.pigLatinName);
        }
    }
}


