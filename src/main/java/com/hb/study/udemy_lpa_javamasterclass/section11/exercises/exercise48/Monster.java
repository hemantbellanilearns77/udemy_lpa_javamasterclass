package com.hb.study.udemy_lpa_javamasterclass.section11.exercises.exercise48;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {

    private final String name;
    private final int hitPoints;
    private final int strength;

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
        if(stringList!=null && !stringList.isEmpty()) {
            List<String> fieldsToWrite = new ArrayList<>(stringList);
            ConsoleStyler.styleOutput(fieldsToWrite + CommonConstants.EMPTYSTRING);
        }
    }

    @Override
    public String toString(){
        return """
                %s{name='%s', hitPoints=%d, strength=%d'}
                """.formatted(this.getClass().getSimpleName(), getName(),getHitPoints(),getStrength());
    }
}
