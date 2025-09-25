package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo.topicwisedemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

/**
 * created by : heman on 16-07-2025, 07:49 pm, in the "udemy_lpa_javamasterclass" project
 **/

/**
 * Demonstrates Object-Oriented Programming concepts: classes, inheritance, polymorphism
 * Created by Hemant as part of the Java Carnival Topic-Wise Showcase
 */
public class DemoOOPConcepts {

    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

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
            ConsoleStyler.styleOutput("🐾 " + name + " makes a sound.");
        }
    }

    // Derived Class
    static class Lion extends Animal {

        public Lion(String name) {
            super(name);
        }

        @Override
        public void speak() {
            ConsoleStyler.styleOutput("🦁 " + name + " roars like royalty!");
        }
    }
}
