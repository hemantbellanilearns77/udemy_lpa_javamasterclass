package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise46;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class Exercise46_BankTestClass {

    private static final String ADELAIDE = "Adelaide";
    private static final String TIM = "Tim";
    private static final String MIKE = "Mike";

        public static void main(String[] ignoredUnusedArgs) {
        //
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch(ADELAIDE);

        bank.addCustomer(ADELAIDE, TIM, 50.05);
        bank.addCustomer(ADELAIDE, MIKE, 175.34);
        bank.addCustomer(ADELAIDE, "Percy", 220.12);

        bank.addCustomerTransaction(ADELAIDE, TIM, 44.22);
        bank.addCustomerTransaction(ADELAIDE, TIM, 12.44);
        bank.addCustomerTransaction(ADELAIDE, MIKE, 1.65);

        //bank.listCustomers("Adelaide", true);
        bank.listCustomers(ADELAIDE, false);

    }
}
