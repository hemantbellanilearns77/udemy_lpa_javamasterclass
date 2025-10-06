package com.hblearns77.udemy_lpa_javamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class Store {
    public static final ExecutionUtil execution = new ExecutionUtil();


    public static void main(String[] args) {

        execution.initialize(args);

        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        ConsoleStyler.styleOutput(regularMeal.toString());
        ConsoleStyler.divider();

        Meal regularMeanUSA = new Meal(0.68);
        ConsoleStyler.styleOutput(regularMeanUSA.toString());

        execution.finalizeExecution();
    }
}
