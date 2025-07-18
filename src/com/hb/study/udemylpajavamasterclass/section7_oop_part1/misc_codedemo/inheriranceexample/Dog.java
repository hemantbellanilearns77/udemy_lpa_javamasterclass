package com.hb.study.udemylpajavamasterclass.section7_oop_part1.misc_codedemo.inheriranceexample;

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
        System.out.println("move invoked on Dog Object!");

        if(speed.equalsIgnoreCase("slow")) {
            walk();
            wagTail();
       } else {
           run();
           bark();
       }
        System.out.println();
    }

    @Override
    public void makeNoise(){
        System.out.println("makeNoise invoked on Dog Object!");

        if(type == "Wolf" ) {
            System.out.println("ow woooo !");
        } else {
            bark();
        }
        System.out.println();
    }

    private void bark(){
        System.out.println("Woof! Woof! Woof! Woof! Woof! Woof!  ");
    }

    private void run(){
        System.out.println("Dog running!");
    }

    private void walk(){
        System.out.println("Dog walking!");
    }

    private void wagTail(){
        System.out.println("Tail Wagging!");
    }


}
