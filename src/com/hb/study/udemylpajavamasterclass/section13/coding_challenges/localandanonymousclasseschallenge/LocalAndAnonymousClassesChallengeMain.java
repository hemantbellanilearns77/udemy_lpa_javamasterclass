package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.localandanonymousclasseschallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


/**
 * created by : heman on 08-07-2025, 02:50 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class LocalAndAnonymousClassesChallengeMain {

    private static int maxEmployeeCount = new Random().nextInt(1, (27_000_00 + 1));
    private static final String[] FIRST_NAMES = {
            "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    public static void main(String[] args) {

        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.programOutputBegins);
        List<Employee> employees = generateEmployeesList();

        System.out.println("Default  listing of Employees (without Details) is: :  ");
     /*   for (Employee emp : employees) {
            System.out.printf("%s%n", emp.toString());
        }*/
        System.out.println("S.No.\t\t\t\tEmployee Details");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + "\t\t" + employees.get(i).toString());
        }
        System.out.print(CommonConstants.asteriskSeparatorLine);

        System.out.println("*".repeat(54) + "\tNow begins the sorting demo\t " + "*".repeat(54));
        String sortField = null;

        System.out.println("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                ((sortField == null) ? "default sort order" : sortField) + " is:");
        printOrderedList(employees, sortField);
        System.out.print(CommonConstants.asteriskSeparatorLine);

        sortField = "fullName";
        System.out.println("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                ((sortField == null) ? "default sort order" : sortField) + " is:");
        printOrderedList(employees, sortField);
        System.out.print(CommonConstants.asteriskSeparatorLine);

        sortField = "yearsWorked";
        System.out.println("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                ((sortField == null) ? "default sort order" : sortField) + " is:");
        printOrderedList(employees, sortField);


        System.out.print(CommonConstants.asteriskSeparatorLine);
        executionUtil.updateExecutionStats();
        System.out.println(executionUtil);
        System.out.println(CommonConstants.programOutputEnds);
    }

    public static void printOrderedList(List<Employee> employeeList, String sortField) {
        //local class
        class DetailedEmployee {
            Employee currentEmployee;
            String fullName = null;
            int yearsWorked;
            LocalDate startDate;

            public DetailedEmployee(Employee employee) {
                currentEmployee = employee;
                fullName = String.join(" ", currentEmployee.firstName(), currentEmployee.lastName());
                //yearsWorked = getYearsWorked();
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
        List<DetailedEmployee> empDetails = new ArrayList<>();
        for (Employee emp : employeeList) {
            empDetails.add(new DetailedEmployee(emp));
        }
        //anonymous class
        var detailedEmpComparator = new Comparator<DetailedEmployee>() {

            @Override
            public int compare(DetailedEmployee o1, DetailedEmployee o2) {
                if (!(sortField == null || sortField.isEmpty() || sortField.isBlank())) {
                    if (sortField.equalsIgnoreCase("fullName")) {
                        return o1.fullName.compareTo(o2.fullName);
                    } else if (sortField.equalsIgnoreCase("yearsWorked")) {
                        return Integer.valueOf(o1.yearsWorked).compareTo(Integer.valueOf(o2.yearsWorked));
                    }
                }
                return 0;
            }
        };
        empDetails.sort(detailedEmpComparator);
        /*for (DetailedEmployee detailedEmployee : empDetails) {
            System.out.print(detailedEmployee.toString());
        }*/
        System.out.println("S.No.\t\t\t\t\tEmployee Details");
        for (int i = 0; i < empDetails.size(); i++) {
            System.out.print((i + 1) + "\t\t" + empDetails.get(i).toString());
        }
    }

    private static List<Employee> generateEmployeesList() {

        List<Employee> generatedEmployeesList = new ArrayList<>(maxEmployeeCount);
        for (int listElementCounter = 0; listElementCounter < maxEmployeeCount; listElementCounter++) {

            generatedEmployeesList.add(listElementCounter, new Employee(
                    CommonUtils.generateRandomName()[0],
                    CommonUtils.generateRandomName()[1],
                    CommonUtils.getRandomDate(15,8, 1947,FormatStyle.LONG)));
        }
        return generatedEmployeesList;
    }


}
