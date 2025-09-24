package com.hb.study.udemy_lpa_javamasterclass.section13.coding_challenges.lambdaclasseschallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.CommonUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * created by : heman on 08-07-2025, 02:50 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class ChallengeMainClass {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();
    public static final SecureRandom secureRandom = new SecureRandom();
    private static final int MAX_EMPLOYEE_COUNT = secureRandom.nextInt(1, (3969 + 1));



    public static void main(String[] args) {

        execution.initialize(args);
        ConsoleStyler.styleOutput("This program will generate " + MAX_EMPLOYEE_COUNT + " objects for Employees");
        List<Employee> employees = generateEmployeesList();

        ConsoleStyler.styleOutput("Default  listing of Employees (without Details) is: :  ");
        ConsoleStyler.styleOutput("S.No.\t\t\t\tEmployee Details");
        for (int i = 0; i < employees.size(); i++) {
            ConsoleStyler.styleOutput(i + 1 + ".\t\t" + employees.get(i).toString());
        }
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);

        ConsoleStyler.styleOutput("*".repeat(54) + "\tNow begins the sorting demo\t " + "*".repeat(54));
        String sortField;

        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                "default sort order" + " is:");
        printOrderedList(employees, null);
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);

        sortField = "fullName";
        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                sortField + " is:");
        printOrderedList(employees, sortField);
        ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);

        sortField = "yearsWorked";
        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                sortField + " is:");
        printOrderedList(employees, sortField);
        execution.finalizeExecution();
    }

    public static void printOrderedList(List<Employee> employeeList, String sortField) {
        //local class
        class DetailedEmployee {
            final Employee currentEmployee;
            final String fullName;
            int yearsWorked;
            LocalDate startDate;

            public DetailedEmployee(Employee employee) {
                currentEmployee = employee;
                fullName = String.join(" ", currentEmployee.firstName(), currentEmployee.lastName());

                initYearsWorked();
            }

            @Override
            public String toString() {
                return "%-18s (hired on: %tD) has worked for: %d year(s)%n".formatted(fullName, startDate, yearsWorked);
            }

            private void initYearsWorked() {
                startDate = LocalDate.parse(currentEmployee.hireDate(), DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
                yearsWorked = Period.between(startDate, LocalDate.now()).getYears();

            }
        }

        interface EnhancedComparator<T> extends Comparator<T> {
            default int secondLevel(T o1, T o2) {
                return 0;
            }
        }

        List<DetailedEmployee> empDetails = new ArrayList<>();
        for (Employee emp : employeeList) {
            empDetails.add(new DetailedEmployee(emp));
        }
        ConsoleStyler.styleExecutionInsight("""
                //anonymous class
                /*var detailedEmpComparator = new Comparator<DetailedEmployee>() {
                
                    @Override
                    public int compare(DetailedEmployee o1, DetailedEmployee o2) {
                        if (!(sortField == null || sortField.isEmpty() || sortField.isBlank())) {
                            if (sortField.equalsIgnoreCase("fullName")) {
                                return o1.fullName.compareTo(o2.fullName);
                            } else if (sortField.equalsIgnoreCase("yearsWorked")) {
                                return Integer.compare(o1.yearsWorked, o2.yearsWorked);
                            }
                        }
                        return 0;
                    }
                };*/
                """);
        var anotherDetailedEmpComparatorMixed = new EnhancedComparator<>() {

            @Override
            public int secondLevel(Object o1, Object o2) {
                return EnhancedComparator.super.secondLevel(o1, o2);
            }

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        empDetails.sort(anotherDetailedEmpComparatorMixed);
        //another anonymous class
        var detailedEmpComparatorMixed = new EnhancedComparator<DetailedEmployee>() {

            @Override
            public int compare(DetailedEmployee o1, DetailedEmployee o2) {
                if (!(sortField == null || sortField.isBlank())) {
                    if (sortField.equalsIgnoreCase("fullName")) {
                        String o1FirstName = o1.fullName.split(" ")[0];
                        String o2FirstName = o2.fullName.split(" ")[0];

                        int result = o1FirstName.compareTo(o2FirstName);
                        ConsoleStyler.styleOutput("First Level Comparison returned : " + result);
                        result = secondLevel(o1, o2);
                        return  result;
                    } else if (sortField.equalsIgnoreCase("yearsWorked")) {
                        return Integer.compare(o1.yearsWorked, o2.yearsWorked);
                    }
                }
                return 0;
            }

            @Override
            public int secondLevel(DetailedEmployee o1, DetailedEmployee o2) {
                String o1Lastname = o1.fullName.split(" ")[1];
                String o2LastName = o2.fullName.split(" ")[1];
                return o1Lastname.compareTo(o2LastName);
            }
        };
        empDetails.sort(detailedEmpComparatorMixed);

        ConsoleStyler.styleOutput("S.No.\t\t\t\t\tEmployee Details");
        for (int i = 0; i < empDetails.size(); i++) {
            ConsoleStyler.styleOutput((i + 1) + "\t\t" + empDetails.get(i).toString());
        }

    }

    private static List<Employee> generateEmployeesList() {
        List<Employee> generatedEmployeesList = new ArrayList<>(MAX_EMPLOYEE_COUNT);
        Name generatedFullName;

        for (int listElementCounter = 0; listElementCounter < MAX_EMPLOYEE_COUNT; listElementCounter++) {
            generatedFullName = new Name(NamesUtil.generateRandomName());
            generatedEmployeesList.add(listElementCounter, new Employee(
                    generatedFullName.getFirstName(),
                    generatedFullName.getLastName(),
                    CommonUtils.getRandomDate(15, 8, 1947, FormatStyle.LONG)));
        }
        return generatedEmployeesList;
    }

}
