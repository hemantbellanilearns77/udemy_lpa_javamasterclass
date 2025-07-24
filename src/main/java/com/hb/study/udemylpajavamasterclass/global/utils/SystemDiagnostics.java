package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import java.util.Map;
import java.util.Properties;

/**
 * created by : heman on 12-07-2025, 08:40 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class SystemDiagnostics {

    //Object level or Static declarations here...
    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {

        execution.initialize();
        /*
         *****************************************************
         */

        demoSystemDiagnostics();
        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }
    public static void demoSystemDiagnostics(){
        System.out.println("=== 🌍 System Properties ===");

        Properties props = System.getProperties();
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.printf("%-40s : %s%n", entry.getKey(), entry.getValue());
        }
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);
        System.out.println("\n=== 🌐 Environment Variables ===");
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.printf("%-30s : %s%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n✅ Diagnostics Complete.");
    }
    //
}
