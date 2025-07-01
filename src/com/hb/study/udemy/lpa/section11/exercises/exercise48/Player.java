package com.hb.study.udemy.lpa.section11.exercises.exercise48;

import java.util.ArrayList;
import java.util.List;
public class Player implements ISaveable{

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> fieldsToWrite = new ArrayList<>();
        fieldsToWrite.add("name='%s'".formatted(getName()));
        fieldsToWrite.add("hitPoints=%d".formatted(getHitPoints()));
        fieldsToWrite.add("strength=%d".formatted(getStrength()));
        fieldsToWrite.add("weapon='%s'".formatted(getWeapon()));
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
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
