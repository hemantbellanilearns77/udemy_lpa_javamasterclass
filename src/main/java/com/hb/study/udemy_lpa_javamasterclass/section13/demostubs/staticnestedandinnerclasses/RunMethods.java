package com.hb.study.udemy_lpa_javamasterclass.section13.demostubs.staticnestedandinnerclasses;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * created by : heman on 08-07-2025, 12:00 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class RunMethods {
    //Object level or Static declarations here...
  public static final ExecutionUtil execution = new ExecutionUtil();

        public static void main(String[] args) {

        execution.initialize(args);
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


        EmployeeComparator<StoreEmployee> c0 = new EmployeeComparator<>();
        Employee.EmployeeComparator c1 = new Employee.EmployeeComparator();
        StoreEmployee.StoreComparator<StoreEmployee> c2 =
                    new StoreEmployee().new StoreComparator<>();

        // Using local class
        class NameSort<T extends Employee> implements Comparator<T> {

            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        // Using anonymous class
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, c4);
        sortIt(storeEmployees, Comparator.comparing(Employee::getName));
        ConsoleStyler.styleExecutionInsight("""
                The above use of Comparing was earlier as below:
                (Modified to fix a sonar medium)
                sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
                """);

        execution.finalizeExecution();
    }


    public static <T> void sortIt(List<T> list,
                                  Comparator<? super T> comparator) {

        ConsoleStyler.styleOutput("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            ConsoleStyler.styleOutput(employee.toString());
        }
    }
}
