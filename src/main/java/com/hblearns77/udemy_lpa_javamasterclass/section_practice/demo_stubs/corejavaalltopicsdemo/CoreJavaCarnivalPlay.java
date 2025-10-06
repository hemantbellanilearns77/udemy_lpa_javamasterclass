package com.hblearns77.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

/**
 * created by : heman on 16-07-2025, 03:12 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnivalPlay {

    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

        public static void main(String[] args) {
        //
        execution.initialize(args);

        /*
         *****************************************************
         */
        // 🎪 Launch the full Core Java Carnival showcase
        CoreJavaCarnival.main(args);
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}