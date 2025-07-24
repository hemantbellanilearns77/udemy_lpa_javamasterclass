package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class Worker {
    private String name;
    private String birthDate;
    private String lwd_Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLwd_Date() {
        return lwd_Date;
    }

    public void setLwd_Date(String lwd_Date) {
        this.lwd_Date = lwd_Date;
    }

    public Worker(String name, String birthDate, String lwd_Date) {
        this.name = name;
        this.birthDate = birthDate;
        this.lwd_Date = lwd_Date;
    }

    public int getAge(){
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

        age = currentYear - currentYear;
        return age;
    }
    public double collectPay() {
        return 0.0;
    }

    public void terminate(String lwd_Date){
        this.lwd_Date = lwd_Date;
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", last working day='" + lwd_Date + '\'' +
                '}';
    }
}
