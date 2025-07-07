package com.hb.study.javamasterclasscourse.section11.exercises.exercise48;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }
    @Override
    public List<String> write() {
        List<String> fieldsToWrite = new ArrayList<>();
        fieldsToWrite.add("name='%s'".formatted(getName()));
        fieldsToWrite.add("hitPoints=%d".formatted(getHitPoints()));
        fieldsToWrite.add("strength=%d".formatted(getStrength()));
        return fieldsToWrite;
    }

    @Override
    public void read(List<String> stringList) {
        if(stringList!=null && stringList.size() > 0) {
            List<String> fieldsToWrite = new ArrayList<String>();
            for(String nextString : stringList) {
                fieldsToWrite.add(nextString);
            }
        }
    }

    @Override
    public String toString(){
        return """
                %s{name='%s', hitPoints=%d, strength=%d, weapon='%s'}
                """.formatted(this.getClass().getSimpleName(), getName(),getHitPoints(),getStrength());
    }
}
