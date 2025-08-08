package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class MainClass extends Object {

    public static void main(String[] args) {
        Employee employee = new Employee("Hemant (Employee)","16-11-1981", "27-06-2016",
                 "11-12-2011" );
        SalariedEmployee salariedEmployee = new SalariedEmployee("Hemant Bellani (Salaried)", "16-11-1981",
                "27-06-2016", "11-12-2011",1300000, false);

        HourlyEmployee hourlyWageEmployee = new HourlyEmployee("Hemant Bellani (Hourly Worker Employee)", "16-11-1981",
                "27-06-2016", 90816, "11-12-2011",350);
        ConsoleStyler.styleOutput(employee  + CommonConstants.EMPTYSTRING);
        hourlyWageEmployee.terminate(hourlyWageEmployee.getLwd_Date());
        ConsoleStyler.styleOutput(hourlyWageEmployee  + CommonConstants.EMPTYSTRING);
        salariedEmployee.collectPay();
        salariedEmployee.retire();
        ConsoleStyler.styleOutput(salariedEmployee  + CommonConstants.EMPTYSTRING);
      /* String birthDate = "16-11-1981";
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
        ConsoleStyler.styleOutput("Calculated age is: " + age);*/
    }
}
