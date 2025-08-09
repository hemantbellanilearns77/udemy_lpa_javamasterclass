package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args)  {
        Animal firstGenericAnimal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(firstGenericAnimal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");
        ConsoleStyler.styleOutput("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        yorkie.move("fast");
        yorkie.makeNoise();
        ConsoleStyler.styleOutput("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog retriever = new Dog("Labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");
        retriever.makeNoise();
        retriever.move("slow");
        ConsoleStyler.styleOutput("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");
        ConsoleStyler.styleOutput("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Fish goldie = new Fish("GoldFish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");
        ConsoleStyler.styleOutput("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");



    }

    private static void doAnimalStuff( Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        ConsoleStyler.styleOutput(animal.toString());
    }
}
