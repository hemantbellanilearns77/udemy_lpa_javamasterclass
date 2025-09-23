package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise46;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String name;
    private final ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction){
        boolean customerAdded = false;
        if(findCustomer(name) == null) {
            Customer newCustomer = new Customer(name, initialTransaction);
            customerAdded = this.customers.add(newCustomer);
        }
        return customerAdded;
    }
    public boolean addCustomerTransaction(String name, double transaction) {
        boolean transactionAdded = false;
        Customer customer = findCustomer(name);
        if(customer != null) {
            transactionAdded = customer.getTransactions().add(transaction);
        }
        return transactionAdded;
    }

    private Customer findCustomer(String name) {

        Customer customerAsFound = null;
        if(!this.customers.isEmpty()) {
            for(var nextCustomer : this.customers){
                if(nextCustomer.getName().equalsIgnoreCase(name)){
                    customerAsFound = nextCustomer;
                }
            }
        }
        return customerAsFound;
    }
}
