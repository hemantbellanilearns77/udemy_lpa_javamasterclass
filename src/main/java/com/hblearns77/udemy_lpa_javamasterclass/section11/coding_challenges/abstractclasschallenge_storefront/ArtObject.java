package com.hblearns77.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ArtObject extends ProductForSale {

    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {

        ConsoleStyler.styleOutput("This " + type + " is a beautiful reproduction");
        ConsoleStyler.styleOutput("The price of the piece is $%6.2f %n".formatted(price));
        ConsoleStyler.styleOutput(description);
    }
}
