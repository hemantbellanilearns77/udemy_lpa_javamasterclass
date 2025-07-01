package com.hb.study.udemy.lpa.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen.archived;

public class Room {
    private Bed bed;
    private Fan fan;
    private Door door;
    private Window window;

    public Bed getBed() {
        return bed;
    }
    public Fan getFan() {
        return fan;
    }
    public Door getDoor() {
        return door;
    }
    public Window getWindow() {
        return window;
    }

    public void openDoor() {
        System.out.println("Inside openDoor() of Room.....");
        getDoor().open();
    }
    public void lock() {
        System.out.println("Inside lock() of Room.....");
        door.lock();
    }
}
