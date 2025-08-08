package com.hb.study.demo_stubs.corejavaalltopicsdemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

/**
 * created by : heman on 16-07-2025, 03:12 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnivalPlay {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

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