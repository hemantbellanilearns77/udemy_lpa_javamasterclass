package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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
            ConsoleStyler.styleOutput("Brewing Coffee..... ");
            this.setHasWorkToDo(false);
        }
    }
}
