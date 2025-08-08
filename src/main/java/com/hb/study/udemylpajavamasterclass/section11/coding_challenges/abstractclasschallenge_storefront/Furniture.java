package com.hb.study.udemylpajavamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Furniture extends ProductForSale {

    public Furniture(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {

        ConsoleStyler.styleOutput("This " + type + " was manufactured in North Carolina");
        System.out.printf("The price of the piece is $%6.2f %n", price);
        ConsoleStyler.styleOutput(description);
    }
}
