package com.hb.study.udemylpajavamasterclass.section10_collections.exercises.exercise46;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {

        this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transactionAmount){
        transactions.add(transactionAmount);
    }
}

