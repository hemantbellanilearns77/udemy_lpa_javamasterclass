package com.hb.study.udemy_lpa_javamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.util.Arrays;
import java.util.List;

public class Store {
    public static ExcecutionUtil execution = new ExcecutionUtil();


        public static void main(String[] args) {

        execution.initialize();
        List<String> argsList = Arrays.stream(args).toList();
        ConsoleStyler.styleOutput(argsList.isEmpty()? "No Arguments", argsList);
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        ConsoleStyler.styleOutput(regularMeal.toString());
        ConsoleStyler.divider();

        Meal USRegularMeal = new Meal(0.68);
        ConsoleStyler.styleOutput(USRegularMeal.toString());

        execution.finalizeExecution();
    }
}
