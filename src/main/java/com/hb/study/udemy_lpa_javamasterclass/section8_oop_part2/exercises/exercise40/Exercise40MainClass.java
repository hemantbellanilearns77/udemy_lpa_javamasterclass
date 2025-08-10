package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise40;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Exercise40MainClass {
    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        ConsoleStyler.styleOutput(car.startEngine());
        ConsoleStyler.styleOutput(car.accelerate());
        ConsoleStyler.styleOutput(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Out-lander VRX 4WD");
        ConsoleStyler.styleOutput(mitsubishi.startEngine());
        ConsoleStyler.styleOutput(mitsubishi.accelerate());
        ConsoleStyler.styleOutput(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        ConsoleStyler.styleOutput(ford.startEngine());
        ConsoleStyler.styleOutput(ford.accelerate());
        ConsoleStyler.styleOutput(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        ConsoleStyler.styleOutput(holden.startEngine());
        ConsoleStyler.styleOutput(holden.accelerate());
        ConsoleStyler.styleOutput(holden.brake());
    }
}
class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                ", cylinders=" + cylinders +
                ", wheels=" + wheels +
                '}';
    }



    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine() ";

    }

    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        return getClass().getSimpleName() + "-> brake()";
    }
}
class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine() ";

    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}
class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine() ";

    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}
class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine() ";

    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}

