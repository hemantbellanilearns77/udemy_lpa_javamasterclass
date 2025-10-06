package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.coding_challenges.genericsclasschallenge;


import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class GenericClassChallengeMain {
    //Object level or Static declarations here...
  public static final ExecutionUtil execution = new ExecutionUtil();

        public static void main(String[] args) {

        execution.initialize(args);
        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.1085, -112.0965"),
                new Park("Yosemite", "37.8855, -119.5360")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        ConsoleStyler.styleOutput(Park.class.getSimpleName() + " " + parkLayer.getClass().getSimpleName() + " has: ");
        parkLayer.renderLayer();
        ConsoleStyler.divider();
        var majorUSRivers = new River[]{
                new River("Mississippi",
                        "47.2160, -95.2348", "29.1566, -89.2495",
                        "35.1556, -90.0659"),
                new River("Missouri",
                        "45.9239, -111.4983", "38.8146, -90.1218")
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);

        riverLayer.addElements(
                new River("Colorado",
                        "40.4708, -105.8286", "31.7811, -114.7724"),
                new River("Delaware",
                        "42.2026, -75.00836", "39.4955, -75.5592"));
        ConsoleStyler.styleOutput(River.class.getSimpleName() + " " + riverLayer.getClass().getSimpleName() + " has: ");
        riverLayer.renderLayer();

        execution.finalizeExecution();
    }
}
