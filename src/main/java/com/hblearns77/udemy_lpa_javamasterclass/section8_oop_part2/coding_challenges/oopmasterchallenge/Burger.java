package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.oopmasterchallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront.Topping;

public class Burger extends Item {

    private static final String TOPPING = "TOPPING";
    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingName) {
        return Topping.valueOf(toppingName.toUpperCase()).getPrice();
    }

    public void addToppings(String extra1, String extra2, String extra3) {

        this.extra1 = new Item(TOPPING, extra1,
                getExtraPrice(extra1));
        this.extra2 = new Item(TOPPING, extra2,
                getExtraPrice(extra2));
        this.extra3 = new Item(TOPPING, extra3,
                getExtraPrice(extra3));
    }

    public void printItemizedList() {

        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        ConsoleStyler.styleOutput("-".repeat(30));
        super.printItem();
    }
}
