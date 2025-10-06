package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise31;


import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean isTeen() {
        ConsoleStyler.styleExecutionInsight("""
                Could also have been:
               /* boolean isTeenAger = switch(getAge()) {
                    case 13, 14, 15, 16, 17, 18, 19 ->  true;
                    default -> false;
                };
                return isTeenAger;*/
               """);

        return switch(getAge()) {
            case 13, 14, 15, 16, 17, 18, 19 -> true;
            default -> false;
        };

    }

    public String getFullName() {
        if(firstName.isEmpty() || lastName.isEmpty()) {
            if(firstName.isEmpty() && lastName.isEmpty()) {
                return "";
            } else {
                if(firstName.isEmpty()) {
                    return lastName;
                } else {
                    return firstName;
                }
            }
        } else {
            return (firstName + " " + lastName);
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

}