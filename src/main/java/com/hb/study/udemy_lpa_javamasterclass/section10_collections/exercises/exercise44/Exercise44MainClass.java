package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise44;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * created by : heman on 01-09-2025, 05:21 pm, in the "run-pmd.bat" project
 **/
public class Exercise44MainClass {//Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String BHARATI_T_BELLANI = "Bharati T Bellani";
    private static final String BHARATI_TELNO = "9899000000";

    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional

        demoFunction();

        execution.finalizeExecution();
    }

    public static void demoFunction() {
        ConsoleStyler.startSection("Welcome to Demo of Mobile Phone App"); // required
        ConsoleStyler.styleInitializationInfo("A Mobile Phone has been initialized");
        MobilePhone myPhone = new MobilePhone("9811000000");
        boolean contactAdded = myPhone.addNewContact(new Contact(BHARATI_T_BELLANI, BHARATI_TELNO));
        if(contactAdded) ConsoleStyler.styleExecutionInsight("Contact successfully added");
        myPhone.addNewContact(new Contact(BHARATI_T_BELLANI, BHARATI_TELNO));
        boolean contactUpdated =myPhone.updateContact(Contact.createContact(BHARATI_T_BELLANI, BHARATI_TELNO),
                                Contact.createContact("Bharati Mata","9899101010"));
        if(contactUpdated) ConsoleStyler.styleExecutionInsight("Contact successfully updated");
        myPhone.removeContact(Contact.createContact("XYZ BELLANI","9650101010"));
        ConsoleStyler.styleOutput("" + myPhone.queryContact("XYZ BELLANI"));
        myPhone.printContacts();

        ConsoleStyler.endSection("End of Section, Thanks for trying this out"); // required
    }
}
