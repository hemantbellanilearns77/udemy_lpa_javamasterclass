package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public abstract class ProductForSale {

    protected double price;
    protected String type;
    protected String description;

    protected ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int qty) {
        return qty * price;
    }

    public void printPricedItem(int qty) {
        ConsoleStyler.styleOutput("%2d qty at $%8.2f each,  %-15s %-35s %n".formatted(qty, price, type, description));
    }

    public abstract void showDetails();
}
