package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

public class Store {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] args) {
        execution.initialize();
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        System.out.println(regularMeal);
        ConsoleStyler.divider();

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);


        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }
}
  //}
