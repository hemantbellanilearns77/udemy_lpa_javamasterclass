package com.hb.study.udemy_lpa_javamasterclass.section11.coding_challenges.abstractclasschallenge_storefront;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.List;


public class Store {

    private static final List<ProductForSale> storeFrontInventory = new ArrayList<>();
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        storeFrontInventory.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeFrontInventory.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        storeFrontInventory.add(new Furniture("Desk", 500,
        "Mahogany Desk"));

        storeFrontInventory.add(new Furniture("Lamp", 200,
        "Tiffany Lamp with Hummingbirds"));

        listProducts();

        ConsoleStyler.styleOutput("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        ConsoleStyler.styleOutput("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
        execution.finalizeExecution();
    }

    public static void listProducts() {

        for (var item : storeFrontInventory) {
            ConsoleStyler.styleOutput("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex,
                                      int qty) {
        order.add(new OrderItem(qty, storeFrontInventory.get(orderIndex)));
    }

    public static void printOrder(List<OrderItem> order) {

        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        ConsoleStyler.styleOutput("Sales Total = $%6.2f %n".formatted(salesTotal));
    }
}
