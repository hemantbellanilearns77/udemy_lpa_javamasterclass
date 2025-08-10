package com.hb.study.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ArtObject extends ProductForSale {

    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {

        ConsoleStyler.styleOutput("This " + type + " is a beautiful reproduction");
        System.out.printf("The price of the piece is $%6.2f %n", price);
        ConsoleStyler.styleOutput(description);
    }
}
