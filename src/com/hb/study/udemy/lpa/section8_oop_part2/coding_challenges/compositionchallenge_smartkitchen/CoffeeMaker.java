package com.hb.study.udemy.lpa.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

public class CoffeeMaker {
    private boolean hasWorkToDo;

    public CoffeeMaker() {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void brewCoffee(){
        if(hasWorkToDo) {
            System.out.println("Brewing Coffee..... ");
            this.setHasWorkToDo(false);
        }
    }
}
