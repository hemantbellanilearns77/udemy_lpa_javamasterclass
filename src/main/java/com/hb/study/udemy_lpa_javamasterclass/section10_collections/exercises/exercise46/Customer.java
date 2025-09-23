package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise46;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Double> transactions;

    public Customer(String name, double initialTransaction) {

        this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transactionAmount){
        transactions.add(transactionAmount);
    }
}

