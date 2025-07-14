package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

public class Store {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] args) {
        execution.setUp();
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        System.out.println(regularMeal);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);


        /*

         ******************************************************
         */
        execution.windDown();
    }
}
  //}
