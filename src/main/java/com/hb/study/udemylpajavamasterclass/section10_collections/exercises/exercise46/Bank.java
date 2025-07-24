package com.hb.study.udemylpajavamasterclass.section10_collections.exercises.exercise46;


import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        boolean branchAdded = false;
        Branch newBranch;
        if (findBranch(branchName) == null) {
            newBranch = new Branch(branchName);
            branchAdded = branches.add(newBranch);
        }

        return branchAdded;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        boolean customerAdded = false;
        Branch branch = findBranch(branchName);
        if (branch != null) {
            customerAdded = branch.newCustomer(customerName, initialTransaction);
        }

        return customerAdded;
    }

    private Branch findBranch(String branchName) {
        Branch foundBranch = null;
        if (branches.size() > 0) {
            for (var nextBranch : branches) {
                if (nextBranch.getName().equalsIgnoreCase(branchName)) {
                    foundBranch = nextBranch;
                    break;
                }
            }
        }

        return foundBranch;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        boolean customerTransactionAdded = false;
        Branch branch = findBranch(branchName);
        if (branch != null && branch.getCustomers().size() > 0) {
            for (var nextCustomer : branch.getCustomers()) {
                if (nextCustomer.getName().equalsIgnoreCase(customerName)) {
                    nextCustomer.addTransaction(transaction);
                    customerTransactionAdded = true;
                }
            }
        }
        return customerTransactionAdded;
    }


    public boolean listCustomers(String branchName, boolean printTransactions) {
        //System.out.println("\n\t\t"+name+"\n");
        boolean branchExists = false;
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branchExists = true;
            int customerCounter = 1;
            System.out.println("Customer details for branch " + branch.getName() + " ("+name+")");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (var customer : branch.getCustomers()) {
                //System.out.println("Customer: " + customer.getName() + "[" + (customerCounter) + "]");
                System.out.printf("Customer: %s[%d]%n", customer.getName(), customerCounter);
                customerCounter++;
                if (printTransactions) {
                    System.out.println("Transactions");
                    int transactionCounter = 1;
                    for (var transaction : customer.getTransactions()) {
                        //System.out.println("[" + (transactionCounter) + "] Amount " + transaction);
                        System.out.printf("[%d] Amount %4.2f", transactionCounter, transaction);
                        transactionCounter++;
                    }
                }
            }
            return branchExists;
        }
        return branchExists;
    }

}


