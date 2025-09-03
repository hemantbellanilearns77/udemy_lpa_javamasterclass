package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class InheritanceExample_MainClass {

    private static final String SLOW = "slow";
    private static final String FAST = "fast";

    public static void main(String[] ignoredignoredUnusedArgs)  {
        Animal firstGenericAnimal = new Animal("Generic Animal");
        doAnimalStuff(firstGenericAnimal, SLOW);

        Dog dog = new Dog();
        doAnimalStuff(dog, FAST);
        ConsoleStyler.divider();

        Dog yorkie = new Dog("Yorkie");
        doAnimalStuff(yorkie, FAST);
        yorkie.move(FAST);
        yorkie.makeNoise();
        ConsoleStyler.divider();

        Dog retriever = new Dog("Labrador Retriever", "Floppy", "Swimmer");
        doAnimalStuff(retriever, SLOW);
        retriever.makeNoise();
        retriever.move(SLOW);
        ConsoleStyler.divider();

        Dog wolf = new Dog("Wolf");
        doAnimalStuff(wolf, SLOW);
        ConsoleStyler.divider();

        Fish goldie = new Fish("GoldFish", 2, 3);
        doAnimalStuff(goldie, FAST);
        ConsoleStyler.divider();




    }

    private static void doAnimalStuff( Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        ConsoleStyler.styleOutput(animal.toString());
    }
}
