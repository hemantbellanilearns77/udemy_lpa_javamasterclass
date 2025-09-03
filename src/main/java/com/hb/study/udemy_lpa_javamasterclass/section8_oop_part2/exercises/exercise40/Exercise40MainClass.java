package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise40;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Exercise40MainClass {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
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
    private static final String ACCELERATE = " -> accelerate()";
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private static final String START_ENGINE = " -> startEngine() ";
    private static final String BRAKE = " -> brake()";


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
        return getClass().getSimpleName() + START_ENGINE;

    }

    public String accelerate() {
        return getClass().getSimpleName() + ACCELERATE;
    }

    public String brake() {
        return getClass().getSimpleName() + BRAKE;
    }
}
class Mitsubishi extends Car {

    private static final String START_ENGINE = " -> startEngine() ";
    private static final String ACCELERATE = " -> accelerate()";
    private static final String BRAKE = " -> brake()";

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + START_ENGINE;
    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + ACCELERATE;
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + BRAKE;
    }
}
class Holden extends Car {
    private static final String START_ENGINE = " -> startEngine() ";
    private static final String ACCELERATE = " -> accelerate()";
    private static final String BRAKE = " -> brake()";

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + START_ENGINE;

    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + ACCELERATE;
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + BRAKE;
    }
}
class Ford extends Car {
    private static final String START_ENGINE = " -> startEngine() ";
    private static final String ACCELERATE = " -> accelerate()";
    private static final String BRAKE = " -> brake()";

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + START_ENGINE;

    }
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + ACCELERATE;
    }
    @Override
    public String brake() {
        return getClass().getSimpleName() + BRAKE;
    }
}

