package com.hb.study.udemylpajavamasterclass.section7_oop_part1.demostubs.inheriranceexample;

public class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal() {
        System.out.println("No argument constructor in Animal class invoked....");
    }
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public void move(String speed) {
        System.out.println(type + " moves " + speed);
    }

    public void makeNoise() {
        System.out.println(type + " makes some kind of noise ");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}
