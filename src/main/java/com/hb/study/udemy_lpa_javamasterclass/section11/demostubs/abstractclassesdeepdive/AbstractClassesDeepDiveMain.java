package com.hb.study.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import java.util.ArrayList;

public class AbstractClassesDeepDiveMain {

        public static void main(String[] ignoredUnusedArgs) {

        Dog dog = new Dog("Wolf" );
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard"));
        animals.add(new Fish("Goldfish"));
        animals.add(new Fish("Barracuda"));
        animals.add(new Dog("Pug"));

        animals.add(new Horse("Clydesdale"));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
        }

    }

    private static void doAnimalStuff(Animal animal) {

        animal.makeNoise();
        animal.move("slow");
    }

}