package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.inheritancechallenge;

import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class Worker {
    private String name;
    private String birthDate;
    private String lwdDate;

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

    public String getLwdDate() {
        return lwdDate;
    }

    public void setLwdDate(String lwdDate) {
        this.lwdDate = lwdDate;
    }

    public Worker(String name, String birthDate, String lwdDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.lwdDate = lwdDate;
    }

    public int getAge(){
        int age;
        int currentYear = Year.now().getValue();
        int currentMonth;
        int monthOfBirth;
        int currentDate;
        int dateOfBirth;
        int yearOfBirth = Integer.parseInt(
                birthDate.substring(birthDate.lastIndexOf('-') + 1));
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
        return age;
    }
    public double collectPay() {
        return 0.0;
    }

    public void terminate(String lwd_Date){
        this.lwdDate = lwd_Date;
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", last working day='" + lwdDate + '\'' +
                '}';
    }
}
