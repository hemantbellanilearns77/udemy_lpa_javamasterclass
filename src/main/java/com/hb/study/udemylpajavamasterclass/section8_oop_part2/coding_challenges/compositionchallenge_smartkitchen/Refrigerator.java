package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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
            ConsoleStyler.styleOutput("Ordering food.....");
            this.setHasWorkToDo(false);
        }
    }
}
