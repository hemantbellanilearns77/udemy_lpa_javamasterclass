package com.hb.study.javamasterclasscourse.section13.coding_challenges.innerclasschallenge;

import com.hb.study.javamasterclasscourse.globalcommon.constants.GlobalCommonConstants;
import com.hb.study.javamasterclasscourse.globalcommon.utils.ExcecutionUtil;

import java.lang.reflect.Executable;

public class Store {

    public static void main(String[] args) {
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        System.out.println(GlobalCommonConstants.programOutputBegins);
        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar", "Cherries");
        System.out.println(regularMeal);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        excecutionUtil.updateExecutionStats();
        System.out.println(excecutionUtil);
        System.out.println(GlobalCommonConstants.programOutputEnds);


    }
}
