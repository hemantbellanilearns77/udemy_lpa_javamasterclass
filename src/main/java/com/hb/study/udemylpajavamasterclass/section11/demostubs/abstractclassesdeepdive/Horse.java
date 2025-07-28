package com.hb.study.udemylpajavamasterclass.section11.demostubs.abstractclassesdeepdive;

public class Horse extends Mammal{
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.printf("Neigh!");

    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds in the spring");
    }
}
