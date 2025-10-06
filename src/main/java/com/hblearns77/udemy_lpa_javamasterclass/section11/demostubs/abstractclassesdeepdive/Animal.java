package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

public abstract class Animal {

    protected String type;
    

    protected Animal(String type) {
        this.type = type;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }
}
