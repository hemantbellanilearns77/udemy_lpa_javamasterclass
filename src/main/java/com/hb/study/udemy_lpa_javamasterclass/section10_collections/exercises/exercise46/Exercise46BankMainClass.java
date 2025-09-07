package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise46;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

public class Exercise46BankMainClass {

    private static final String ADELAIDE = "Adelaide";
    private static final String TIM = "Tim";
    private static final String MIKE = "Mike";

    private static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch(ADELAIDE);
        boolean isCustomerAddSuccess;
        boolean customerTxnAddedSuccess;
        isCustomerAddSuccess = bank.addCustomer(ADELAIDE, TIM, 50.05);
        if (isCustomerAddSuccess)
            ConsoleStyler.styleExecutionInsight("Another bank customer added");
        isCustomerAddSuccess = bank.addCustomer(ADELAIDE, MIKE, 175.34);
        if (isCustomerAddSuccess)
            ConsoleStyler.styleExecutionInsight("Another bank customer added");

        isCustomerAddSuccess = bank.addCustomer(ADELAIDE, "Percy", 220.12);
        if (isCustomerAddSuccess)
            ConsoleStyler.styleExecutionInsight("Another bank customer added");

        customerTxnAddedSuccess = bank.addCustomerTransaction(ADELAIDE, TIM, 44.22);
        if (customerTxnAddedSuccess)
            ConsoleStyler.styleExecutionInsight("Customer Transaction Successful");
        customerTxnAddedSuccess = bank.addCustomerTransaction(ADELAIDE, TIM, 12.44);
        if (customerTxnAddedSuccess)
            ConsoleStyler.styleExecutionInsight("Customer Transaction Successful");
        customerTxnAddedSuccess = bank.addCustomerTransaction(ADELAIDE, MIKE, 1.65);
        if (customerTxnAddedSuccess)
            ConsoleStyler.styleExecutionInsight("Customer Transaction Successful");

        boolean customersListed = bank.listCustomers(ADELAIDE, false);
        if(customersListed)
            ConsoleStyler.styleExecutionInsight("Customers Listed Successfully above");
        execution.finalizeExecution();
    }
}