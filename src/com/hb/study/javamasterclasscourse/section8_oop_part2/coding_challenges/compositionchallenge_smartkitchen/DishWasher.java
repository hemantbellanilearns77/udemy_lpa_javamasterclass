package com.hb.study.javamasterclasscourse.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

public class DishWasher {
    private boolean hasWorkToDo;

    public DishWasher() {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void doDishes(){
        if(hasWorkToDo) {
            System.out.println("Washing Dishes now.. ");
            this.setHasWorkToDo(false);
        }
    }
}
