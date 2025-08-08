package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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
            ConsoleStyler.styleOutput("Washing Dishes now.. ");
            this.setHasWorkToDo(false);
        }
    }
}
