package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise44;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;

/**
 * created by : heman on 01-09-2025, 05:21 pm, in the "run-pmd.bat" project
 **/
public class Exercise44MainClass {//Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final NamesUtil namesUtil = new NamesUtil(CommonConstants.MAX_ITERATION_COUNT);

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional

        demoFunction();

        execution.finalizeExecution();
    }

    public static void demoFunction() {
        ConsoleStyler.startSection("Welcome to Demo of Mobile Phone App"); // required
        ConsoleStyler.styleInitializationInfo("A Mobile Phone has been initialized");
        MobilePhone myPhone = new MobilePhone("9811000000");
        myPhone.addNewContact(new Contact("Bharati T Bellani", "9899000000"));
        myPhone.updateContact(Contact.createContact("Bharati T Bellani","9899000000"),
                Contact.createContact("Bharati T Bellani","9899101010"));
        myPhone.removeContact(Contact.createContact("XYZ BELLANI","9650101010"));
        ConsoleStyler.styleOutput("" + myPhone.queryContact("XYZ BELLANI"));
        myPhone.printContacts();

        ConsoleStyler.endSection("End of Section, Thanks for trying this out"); // required
    }
}
