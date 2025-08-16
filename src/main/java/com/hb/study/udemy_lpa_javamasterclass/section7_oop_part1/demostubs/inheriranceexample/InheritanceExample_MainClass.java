package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class InheritanceExample_MainClass {
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
        ConsoleStyler.divider();

        Dog retriever = new Dog("Labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");
        retriever.makeNoise();
        retriever.move("slow");
        ConsoleStyler.divider();

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");
        ConsoleStyler.divider();

        Fish goldie = new Fish("GoldFish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");
        ConsoleStyler.divider();




    }

    private static void doAnimalStuff( Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        ConsoleStyler.styleOutput(animal.toString());
    }
}
