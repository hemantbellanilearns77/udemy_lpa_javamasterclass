package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.oopmasterchallenge_billburgerchallenge;

import com.hb.study.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront.Topping;

public class Main {

    public static void main(String[] args) {

//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();
//
//        Item avocado = new Item("Topping", "avocado", 1.50);
//        avocado.printItem();

//        Burger burger = new Burger("regular", 4.00);
//        burger.addToppings("BACON", "CHEESE", "MAYO");
//        burger.printItem();

        MealOrder regularMeal = new MealOrder();
        regularMeal.addBurgerToppings(Topping.BACON.name(),Topping.CHEESE.name(), Topping.MAYO.name());
        regularMeal.setDrinkSize("LARGE");
        regularMeal.printItemizedList();

        MealOrder secondMeal = new MealOrder("turkey", "7-up",
                "chili");
        secondMeal.addBurgerToppings(Topping.LETTUCE.name(), Topping.CHEESE.name(), Topping.MAYO.name());
        secondMeal.setDrinkSize("SMALL");
        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "7-up",
                "chili");
        deluxeMeal.addBurgerToppings(Topping.AVACADO.name(), Topping.BACON.name(),Topping.LETTUCE.name(),
                Topping.CHEESE.name(), Topping.MAYO.name());
        //deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();
    }
}