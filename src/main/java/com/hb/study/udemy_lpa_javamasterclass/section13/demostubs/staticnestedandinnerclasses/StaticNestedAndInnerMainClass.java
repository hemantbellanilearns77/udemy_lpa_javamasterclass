package com.hb.study.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.List;

public class StaticNestedAndInnerMainClass {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();

        public static void main(String[] unusedArgs) {
        //
        execution.initialize();
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("yearStarted")
                .reversed());

        for (Employee e : employees) {
            ConsoleStyler.styleOutput(e  + CommonConstants.EMPTYSTRING);
        }
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("Store Members");
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

        for (StoreEmployee e : storeEmployees) {
            ConsoleStyler.styleOutput(e  + CommonConstants.EMPTYSTRING);
        }
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("With Pig Latin NamesUtil");
        addPigLatinName(storeEmployees);
        ConsoleStyler.divider();


        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

  //

    // method to demonstrate local inner/nested class
    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee> {

            private String pigLatinName;
            private Employee originalInstance;

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


