package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

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
