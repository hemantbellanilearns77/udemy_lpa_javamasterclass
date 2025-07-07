package com.hb.study.javamasterclasscourse.section8_oop_part2.exercises.exercise40;

public class Exercise40MainClass {
    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Out-lander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
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

