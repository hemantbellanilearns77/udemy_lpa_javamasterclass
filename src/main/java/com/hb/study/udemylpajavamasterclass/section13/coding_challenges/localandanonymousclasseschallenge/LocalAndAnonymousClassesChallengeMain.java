package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.localandanonymousclasseschallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
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

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();
    private static final int maxEmployeeCount = new Random().nextInt(1, (3969 + 1));

    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh","Arijit","Aishwarya","Anamika","Amarjot","Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
    private static String[] args;

    public static void main(String[] args) {
        execution.initialize();
        LocalAndAnonymousClassesChallengeMain.args = args;
        ConsoleStyler.styleOutput("This program will generate " + maxEmployeeCount + " objects for Employees");
        List<Employee> employees = generateEmployeesList();

        ConsoleStyler.styleOutput("Default  listing of Employees (without Details) is: :  ");
        ConsoleStyler.styleOutput("S.No.\t\t\t\tEmployee Details");
        for (int i = 0; i < employees.size(); i++) {
            ConsoleStyler.styleOutput((i + 1) + ".\t\t" + employees.get(i).toString());
        }
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);

        ConsoleStyler.styleOutput("*".repeat(54) + "\tNow begins the sorting demo\t " + "*".repeat(54));
        String sortField;

        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                "default sort order" + " is:");
        printOrderedList(employees, null);
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);

        sortField = "fullName";
        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                sortField + " is:");
        printOrderedList(employees, sortField);
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);

        sortField = "yearsWorked";
        ConsoleStyler.styleOutput("Detailed listing of Employees (i.e. DetailedEmployee) sorted according to " +
                sortField + " is:");
        printOrderedList(employees, sortField);



        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

  //

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

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }



        List<DetailedEmployee> empDetails = new ArrayList<>();
        for (Employee emp : employeeList) {
            empDetails.add(new DetailedEmployee(emp));
        }
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
        //another anonymous class
        var detailedEmpComparatorMixed = new EnhancedComparator<DetailedEmployee>() {

            @Override
            public int compare(DetailedEmployee o1, DetailedEmployee o2) {
                if (!(sortField == null || sortField.isEmpty() || sortField.isBlank())) {
                    if (sortField.equalsIgnoreCase("fullName")) {
                        String o1FirstName = o1.fullName.split(" ")[0];
                        String o2FirstName =  o2.fullName.split(" ")[0];

                        int result = o1FirstName.compareTo(o2FirstName);
                        return (result == 0 ? secondLevel(o1, o2) : result);
                    } else if (sortField.equalsIgnoreCase("yearsWorked")) {
                        return Integer.compare(o1.yearsWorked, o2.yearsWorked);
                    }
                }
                return 0;
            }

            @Override
            public int secondLevel(DetailedEmployee o1, DetailedEmployee o2) {
                String o1Lastname = o1.fullName.split(" ")[1];
                String o2LastName =  o2.fullName.split(" ")[1];
                return o1Lastname.compareTo(o2LastName);
            }
        };
        empDetails.sort(detailedEmpComparatorMixed);

        ConsoleStyler.styleOutput("S.No.\t\t\t\t\tEmployee Details");
        for (int i = 0; i < empDetails.size(); i++) {
            System.out.print((i + 1) + "\t\t" + empDetails.get(i).toString());
        }



    }

    private static List<Employee> generateEmployeesList() {
        String[] fullName;
        List<Employee> generatedEmployeesList = new ArrayList<>(maxEmployeeCount);
        Name generatedFullName;

        for (int listElementCounter = 0; listElementCounter < maxEmployeeCount; listElementCounter++) {
            generatedFullName = new Name(CommonUtils.generateRandomName(FIRST_NAMES,LAST_NAMES));
            generatedEmployeesList.add(listElementCounter, new Employee(
                    generatedFullName.getFirstName(),
                    generatedFullName.getLastName(),
                    CommonUtils.getRandomDate(15,8, 1947,FormatStyle.LONG)));
        }
        return generatedEmployeesList;
    }


}
