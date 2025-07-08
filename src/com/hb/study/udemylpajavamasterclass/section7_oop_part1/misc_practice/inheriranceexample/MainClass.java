package com.hb.study.udemylpajavamasterclass.section7_oop_part1.misc_practice.inheriranceexample;

public class MainClass extends Object{
    public static void main(String[] args)  {
        Animal firstGenericAnimal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(firstGenericAnimal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        yorkie.move("fast");
        yorkie.makeNoise();
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog retriever = new Dog("Labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");
        retriever.makeNoise();
        retriever.move("slow");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

        Fish goldie = new Fish("GoldFish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");



    }

    private static void doAnimalStuff( Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
    }
}
