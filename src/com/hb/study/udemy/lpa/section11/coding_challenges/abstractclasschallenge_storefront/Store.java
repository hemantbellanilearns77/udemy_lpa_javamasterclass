package com.hb.study.udemy.lpa.section11.coding_challenges.abstractclasschallenge_storefront;

import java.util.ArrayList;


public class Store {

    private static ArrayList<ProductForSale> storeFrontInventory = new ArrayList<>();

    public static void main(String[] args) {

        storeFrontInventory.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeFrontInventory.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        storeFrontInventory.add(new Furniture("Desk", 500,
        "Mahogany Desk"));

        storeFrontInventory.add(new Furniture("Lamp", 200,
        "Tiffany Lamp with Hummingbirds"));

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void listProducts() {

        for (var item : storeFrontInventory) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex,
                                      int qty) {
        order.add(new OrderItem(qty, storeFrontInventory.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {

        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
