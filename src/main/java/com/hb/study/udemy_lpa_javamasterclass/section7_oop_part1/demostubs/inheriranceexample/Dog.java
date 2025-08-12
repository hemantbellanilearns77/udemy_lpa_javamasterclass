package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Dog extends Animal{
    private String earShape;
    private String tailShape;

    public Dog() {
        super("Mutt", "Big", 50 );
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    @Override
    public void move(String speed){
        ConsoleStyler.styleOutput("move invoked on Dog Object!");

        if(speed.equalsIgnoreCase("slow")) {
            walk();
            wagTail();
       } else {
           run();
           bark();
       }

    }

    @Override
    public void makeNoise(){
        ConsoleStyler.styleOutput("makeNoise invoked on Dog Object!");

        if(type == "Wolf" ) {
            ConsoleStyler.styleOutput("ow woooo !");
        } else {
            bark();
        }
    }

    private void bark(){
        ConsoleStyler.styleOutput("Woof! Woof! Woof! Woof! Woof! Woof!  ");
    }

    private void run(){
        ConsoleStyler.styleOutput("Dog running!");
    }

    private void walk(){
        ConsoleStyler.styleOutput("Dog walking!");
    }

    private void wagTail(){
        ConsoleStyler.styleOutput("Tail Wagging!");
    }


}
