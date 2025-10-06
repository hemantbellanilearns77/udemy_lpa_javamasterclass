package com.hblearns77.udemy_lpa_javamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private static final double BURGER_MEAL_BASE_PRICE = 5.0;
    private final Burger theBurgerInMeal;
    private final Item theDrinkInMeal;
    private final Item theSideInMeal;

    private final double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        theBurgerInMeal = new Burger("Regular");
        theDrinkInMeal = new Item("Coke", "DRINK", 1.5);
        ConsoleStyler.styleOutput(theDrinkInMeal.name);
        theSideInMeal = new Item("Fries", "SIDE", 2.0);
    }

    public double getTotal() {

        double total = theBurgerInMeal.getPrice() + theDrinkInMeal.price + theSideInMeal.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(theBurgerInMeal, theDrinkInMeal, theSideInMeal,
                "Total Due: ", getTotal());
    }

    public void addToppings(String... selectedToppings) {
        theBurgerInMeal.addToppings(selectedToppings);
    }

    private class Item {

        private final String name;
        private final String type;
        private final double price;

        public Item(String name, String type) {
            this(name, type, type.equals("BURGER") ? Meal.BURGER_MEAL_BASE_PRICE : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item {

        private enum Extra {
            KETCHUP,
            MUSTARD,
            PICKLES,
            BACON,
            CHEDDAR,
            CHEESE,
            AVOCADO,
            SALAMI,
            TOMATO,
            LETTUCE,
            MAYO;

            private double getPrice(){
                return switch(this){
                    case BACON, SALAMI, AVOCADO, LETTUCE -> 2.0;
                    case CHEDDAR, PICKLES, MUSTARD -> 1.5;
                    case CHEESE, MAYO -> 1.0;
                    default -> 0.5;
                };
            }

        }

        private final List<Item> toppings = new ArrayList<>();
        Burger(String name) {
            super(name, "BURGER");
        }

        public double getPrice() {

            double total = super.price;
            for (Item topping : toppings) {
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... selectedToppings) {

            for (String selectedTopping : selectedToppings) {
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "TOPPING",
                            topping.getPrice()));
                } catch (IllegalArgumentException _) {
                    ConsoleStyler.styleOutput("No topping found for " + selectedTopping);
                }
            }
        }

        @Override
        public String toString() {

            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings) {
                itemized.append(CommonConstants.NEWLINE);
                itemized.append(topping);
            }

            return itemized.toString();
        }

    }

}
