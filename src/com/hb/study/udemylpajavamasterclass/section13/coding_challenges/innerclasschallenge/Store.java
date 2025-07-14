package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

public class Store {
    //Object level or Static declarations here...
    public static ExcecutionUtil execution = executionSetup();

    public static void main(String[] args) {
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        System.out.println(regularMeal);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);


        /*

         ******************************************************
         */
        execution.executionWindDown();
    }

    public static ExcecutionUtil executionSetup() {
        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        return executionUtil;
    }}
