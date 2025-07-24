package com.hb.study.udemylpajavamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

public enum Topping {
    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    CHEESE,
    AVACADO,
    SALAMI,
    TOMATO,
    LETTUCE,
    MAYO;

    public double getPrice(){
        return switch(this){
            case BACON, SALAMI, AVACADO -> 2.0;
            case CHEDDAR, PICKLES, TOMATO, LETTUCE -> 1.5;
            case CHEESE, MUSTARD, MAYO -> 1.0;
            default -> 0.0;
        };
    }
}
