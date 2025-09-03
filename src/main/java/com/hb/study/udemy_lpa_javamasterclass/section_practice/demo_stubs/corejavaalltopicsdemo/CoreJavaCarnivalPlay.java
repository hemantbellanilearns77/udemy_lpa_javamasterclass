package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 03:12 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnivalPlay {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

        public static void main(String[] ignoredUnusedArgs) {
        //
        execution.initialize();

        /*
         *****************************************************
         */
        // 🎪 Launch the full Core Java Carnival showcase
        CoreJavaCarnival.main(ignoredUnusedArgs);
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
}