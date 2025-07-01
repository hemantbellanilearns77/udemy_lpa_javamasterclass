package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise31;



public class Person {
    private String firstName;
    private String lastName;
    private int age;



    public boolean isTeen() {
       /* boolean isTeenAger = switch(getAge()) {
            case 13, 14, 15, 16, 17, 18, 19 ->  true;
            default -> false;
        };
        return isTeenAger;*/

        boolean isTeenAger = false;
        return switch(getAge()) {
            case 13, 14, 15, 16, 17, 18, 19 -> { isTeenAger = true;
                yield isTeenAger;}
            default -> {yield false;}
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