package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class InheritanceChallengeMainClass {

    private static final String BIRTH_DATE = "16-11-1981";
    private static final String END_DATE = "27-06-2016";
    private static final String HIRE_DATE = "11-12-2011";

        public static void main(String[] ignoredUnusedArgs) {
        //
        Employee employee = new Employee("Hemant (Employee)", BIRTH_DATE, END_DATE,
                HIRE_DATE);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Hemant Bellani (Salaried)", BIRTH_DATE,
                END_DATE, HIRE_DATE,1300000, false);

        HourlyEmployee hourlyWageEmployee = new HourlyEmployee("Hemant Bellani (Hourly Worker Employee)", BIRTH_DATE,
                END_DATE, 90816, HIRE_DATE,350);
        ConsoleStyler.styleOutput(employee  + CommonConstants.EMPTYSTRING);
        hourlyWageEmployee.terminate(hourlyWageEmployee.getLwd_Date());
        ConsoleStyler.styleOutput(hourlyWageEmployee  + CommonConstants.EMPTYSTRING);
        salariedEmployee.collectPay();
        salariedEmployee.retire();
        ConsoleStyler.styleOutput(salariedEmployee  + CommonConstants.EMPTYSTRING);
        String birthDate = BIRTH_DATE;
        int age = 0;
        int currentYear = Year.now().getValue();
        int currentMonth, monthOfBirth = 0;
        int currentDate, dateOfBirth = 0;
        int yearOfBirth = ((int) Integer.parseInt(
                birthDate.substring(birthDate.lastIndexOf('-') + 1, birthDate.length())));
        monthOfBirth =  Integer.parseInt(birthDate.substring(
                        birthDate.indexOf('-') + 1, birthDate.lastIndexOf('-') ));
        dateOfBirth =  Integer.parseInt(birthDate.substring(
                0,  birthDate.indexOf('-')  ));



        // calculate age
        age = currentYear - yearOfBirth;
        currentMonth = YearMonth.now().getMonthValue();
        currentDate = MonthDay.now().getDayOfMonth();

        if( (currentMonth < monthOfBirth)
                ||
                (currentDate < dateOfBirth )) {
            age = age - 1;
        }
        ConsoleStyler.styleOutput("birthDate is: " + birthDate);
        ConsoleStyler.styleOutput("currentYear is: " + currentYear);
        ConsoleStyler.styleOutput("currentYear is: " + currentYear);
        ConsoleStyler.styleOutput("currentMonth is: " + currentMonth);
        ConsoleStyler.styleOutput("monthOfBirth is: " + monthOfBirth);
        ConsoleStyler.styleOutput("currentDate is: " + currentDate);
        ConsoleStyler.styleOutput("dateOfBirth is: " + dateOfBirth);
        ConsoleStyler.styleOutput("Calculated age is: " + age);
    }
}
