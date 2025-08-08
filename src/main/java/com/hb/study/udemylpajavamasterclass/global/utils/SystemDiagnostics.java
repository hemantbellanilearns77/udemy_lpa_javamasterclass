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
        ConsoleStyler.styleOutput("=== 🌍 System Properties ===");

        Properties props = System.getProperties();
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.printf("%-40s : %s%n", entry.getKey(), entry.getValue());
        }
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);
        ConsoleStyler.styleOutput("\n=== 🌐 Environment Variables ===");
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.printf("%-30s : %s%n", entry.getKey(), entry.getValue());
        }

        ConsoleStyler.styleOutput("\n✅ Diagnostics Complete.");
    }
    //
}
