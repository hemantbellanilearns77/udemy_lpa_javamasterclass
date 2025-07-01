package com.hb.study.udemy.lpa.section7_oop_part1.coding_challenges.inheritancechallenge;

public class MainClass extends Object {

    public static void main(String[] args) {
        Employee employee = new Employee("Hemant (Employee)","16-11-1981", "27-06-2016",
                 "11-12-2011" );
        SalariedEmployee salariedEmployee = new SalariedEmployee("Hemant Bellani (Salaried)", "16-11-1981",
                "27-06-2016", "11-12-2011",1300000, false);

        HourlyEmployee hourlyWageEmployee = new HourlyEmployee("Hemant Bellani (Hourly Worker Employee)", "16-11-1981",
                "27-06-2016", 90816, "11-12-2011",350);
        System.out.println(employee);
        hourlyWageEmployee.terminate(hourlyWageEmployee.getLwd_Date());
        System.out.println(hourlyWageEmployee);
        salariedEmployee.collectPay();
        salariedEmployee.retire();
        System.out.println(salariedEmployee);
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
        System.out.println("birthDate is: " + birthDate);
        System.out.println("currentYear is: " + currentYear);
        System.out.println("currentYear is: " + currentYear);
        System.out.println("currentMonth is: " + currentMonth);
        System.out.println("monthOfBirth is: " + monthOfBirth);
        System.out.println("currentDate is: " + currentDate);
        System.out.println("dateOfBirth is: " + dateOfBirth);
        System.out.println("Calculated age is: " + age);*/
    }
}
