package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise9;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class AreaCalculator {

        public static void main(String[] ignoredUnusedArgs) {

        ConsoleStyler.styleOutput("area(5.0) : " + area(5.0));
        ConsoleStyler.styleOutput("area(-1) : " + area(-1));
        ConsoleStyler.styleOutput("area(5.0, 4.0) : " + area(5.0, 4.0));
        ConsoleStyler.styleOutput("area(-1.0.-4.0) : " + area(-1.0, 4.0));
    }
    public static double area(double radius) {
        double areaOfCircle = -1.0d;
        if(radius >= 0) {
            areaOfCircle = Math.PI * radius * radius;
        }

        return areaOfCircle;
    }

    public static double area(double x, double y) {
        double areaOfRectangle = -1.0d;
        if( (x>=0) && (y>= 0) ) {
            areaOfRectangle = x * y ;
        }

        return areaOfRectangle;
    }
}
