package com.hb.study.udemylpajavamasterclass.global.misc_codedemo.topicwisedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:49 pm, in the "udemy_lpa_javamasterclass" project
 **/

/**
 * Demonstrates Object-Oriented Programming concepts: classes, inheritance, polymorphism
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */
public class DemoOOPConcepts {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */

        ConsoleStyler.printBanner("OBJECT-ORIENTED PROGRAMMING");

        ConsoleStyler.startSection("Basic Class Instantiation");
        Animal generic = new Animal("Creature");
        generic.speak();
        ConsoleStyler.endSection("Basic Class Instantiation");

        ConsoleStyler.startSection("Inheritance & Method Overriding");
        Animal lion = new Lion("Simba");
        lion.speak();
        ConsoleStyler.endSection("Inheritance & Method Overriding");

        ConsoleStyler.startSection("Polymorphism");
        Animal polyAnimal = new Lion("Nala");
        polyAnimal.speak(); // Should still call Lion's speak()
        ConsoleStyler.endSection("Polymorphism");

        ConsoleStyler.printBanner("DEMO COMPLETE");
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    // Base Class
    static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void speak() {
            System.out.println("🐾 " + name + " makes a sound.");
        }
    }

    // Derived Class
    static class Lion extends Animal {

        public Lion(String name) {
            super(name);
        }

        @Override
        public void speak() {
            System.out.println("🦁 " + name + " roars like royalty!");
        }
    }
}
