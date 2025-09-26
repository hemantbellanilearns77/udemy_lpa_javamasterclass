package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.oopmasterchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Item {

    private final String type;
    private final String name;
    private final double price;
    private String size = "MEDIUM";

    public Item(String type, String name, double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    public String getName() {

        if (type.equals("SIDE") || type.equals("DRINK")) {
            return size + " " + name;
        }

        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static void printItem(String name, double price) {
        ConsoleStyler.styleOutput( "%20s:%6.2f%n".formatted( name, price));
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }

}
