package com.hb.study.udemy_lpa_javamasterclass.global.utils;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;

import java.util.Map;
import java.util.Properties;

/**
 * created by : heman on 12-07-2025, 08:40 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class SystemDiagnostics {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();
        demoSystemDiagnostics();
        execution.finalizeExecution();
    }
    public static void demoSystemDiagnostics(){
        ConsoleStyler.styleOutput("=== 🌍 System Properties ===");
        Properties props = System.getProperties();
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            ConsoleStyler.styleOutput("%-40s : %s%n".formatted(entry.getKey(), entry.getValue()));
        }
        System.out.print(CommonConstants.FULLLINEASTERISKSEPERATOR);
        ConsoleStyler.styleOutput("\n=== 🌐 Environment Variables ===");
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            ConsoleStyler.styleOutput("%-30s : %s%n".formatted(entry.getKey(), entry.getValue()));
        }
        ConsoleStyler.styleOutput("✅ Diagnostics Complete.");
    }
}
