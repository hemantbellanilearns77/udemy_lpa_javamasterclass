package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class DishWasher {
    private boolean hasWorkToDo;

    public DishWasher() {
        ConsoleStyler.styleInitializationInfo("DishWasher initialized");
    }
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void doDishes(){
        if(hasWorkToDo) {
            ConsoleStyler.styleOutput("Washing Dishes now.. ");
            this.setHasWorkToDo(false);
        }
    }
}
