package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise46;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Branch> branches;

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
        if (!branches.isEmpty()) {
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
        if (branch != null && !branch.getCustomers().isEmpty()) {
            for (var nextCustomer : branch.getCustomers()) {
                if (nextCustomer.getName().equalsIgnoreCase(customerName)) {
                    nextCustomer.addTransaction(transaction);
                    branch.addCustomerTransaction(customerName, transaction);
                    customerTransactionAdded = true;
                }
            }
        }
        return customerTransactionAdded;
    }


    public boolean listCustomers(String branchName, boolean printTransactions) {
        boolean branchExists = false;
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branchExists = true;
            int customerCounter = 1;
            ConsoleStyler.styleOutput("Customer details for branch " + branch.getName() + " ("+name+")");
            for (var customer : branch.getCustomers()) {
                ConsoleStyler.styleOutput("""
                        Customer: %s[%d]
                        """.formatted(customer.getName(), customerCounter));
                customerCounter++;
                if (printTransactions) {
                    ConsoleStyler.styleOutput("Transactions");
                    int transactionCounter = 1;
                    for (var transaction : customer.getTransactions()) {
                        ConsoleStyler.styleOutput("""
                                [%d] Amount %4.2f
                                """.formatted(transactionCounter, transaction));
                        transactionCounter++;
                    }
                }
            }
        } else {
            ConsoleStyler.styleOutput("The Branch " + branchName + " doesn't really exist!");
        }
        return branchExists;
    }
}


