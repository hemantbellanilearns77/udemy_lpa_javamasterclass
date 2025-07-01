package com.hb.study.udemy.lpa.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

public class Refrigerator {

    private boolean hasWorkToDo;

    public Refrigerator() {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void orderFood(){
        if(hasWorkToDo) {
            System.out.println("Ordering food.....");
            this.setHasWorkToDo(false);
        }
    }
}
