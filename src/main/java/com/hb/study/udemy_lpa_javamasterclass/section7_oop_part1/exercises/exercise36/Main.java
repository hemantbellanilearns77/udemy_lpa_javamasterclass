package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise36;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Main {


        public static void main(String[] ignoredUnusedArgs) {
        //
/*        Circle circle = new Circle(3.75);
        ConsoleStyler.styleOutput("circle.radius= " + circle.getRadius());
        ConsoleStyler.styleOutput("circle.area= " + circle.getArea());
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        ConsoleStyler.styleOutput("cylinder.radius= " + cylinder.getRadius());
        ConsoleStyler.styleOutput("cylinder.height= " + cylinder.getHeight());
        ConsoleStyler.styleOutput("cylinder.area= " + cylinder.getArea());
        ConsoleStyler.styleOutput("cylinder.volume= " + cylinder.getVolume());*/

        Cylinder cylinder = new Cylinder(5.0, 1.0);
        ConsoleStyler.styleOutput("cylinder.radius= " + cylinder.getRadius());
        ConsoleStyler.styleOutput("cylinder.height= " + cylinder.getHeight());
        ConsoleStyler.styleOutput("cylinder.area= " + cylinder.getArea());
        ConsoleStyler.styleOutput("cylinder.volume= " + cylinder.getVolume());
    }


}
