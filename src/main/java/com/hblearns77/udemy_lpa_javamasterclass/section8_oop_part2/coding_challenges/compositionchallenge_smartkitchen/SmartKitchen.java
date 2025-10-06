package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

public class SmartKitchen {
    private final CoffeeMaker brewMaster;
    private final DishWasher dishWasher;
    private final Refrigerator iceBox;


    public SmartKitchen(){
        brewMaster = new CoffeeMaker();
        iceBox = new Refrigerator();
        dishWasher = new DishWasher();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public void addWater() {
       brewMaster.setHasWorkToDo(true);

    }

    public void pourMilk(){
        iceBox.setHasWorkToDo(true);

    }
    public void loadDishWasher(){
        dishWasher.setHasWorkToDo(true);
    }
    public void doKitchenWork() {
        brewMaster.brewCoffee();
        iceBox.orderFood();
        dishWasher.doDishes();
        addWater();
        pourMilk();

    }
    public void setKitchenState(boolean coffeeMakerState,
                                boolean dishWasherState,
                                boolean refrigeratorState){

        brewMaster.setHasWorkToDo(coffeeMakerState);
        iceBox.setHasWorkToDo(refrigeratorState);
        dishWasher.setHasWorkToDo(dishWasherState);

    }
}
