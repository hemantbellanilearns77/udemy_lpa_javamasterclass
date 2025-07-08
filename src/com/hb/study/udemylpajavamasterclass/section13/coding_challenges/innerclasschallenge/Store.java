package com.hb.study.udemylpajavamasterclass.section13.coding_challenges.innerclasschallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

public class Store {

    public static void main(String[] args) {
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.programOutputBegins);
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        System.out.println(regularMeal);
        System.out.println(CommonConstants.asteriskSeparatorLine);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        System.out.println(CommonConstants.asteriskSeparatorLine);
        excecutionUtil.updateExecutionStats();
        System.out.println(excecutionUtil);
        System.out.println(CommonConstants.programOutputEnds);


    }
}
