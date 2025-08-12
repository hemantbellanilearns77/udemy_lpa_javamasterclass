package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

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
