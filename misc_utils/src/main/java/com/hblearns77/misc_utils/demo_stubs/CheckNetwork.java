package com.hblearns77.misc_utils.demo_stubs;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.net.*;
import java.io.*;

import java.util.Arrays;

/**
 * created by : heman on 04-10-2025, 07:20 am, in the "UDEMY_LPA_JAVAMASTERCLASS" project
 **/
public class CheckNetwork {//Object level or Static declarations here...
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);

        try {
            ConsoleStyler.styleOutput("Attempting to connect to Oracle Home Page");
            URL url = URI.create("https://www.oracle.com").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            ConsoleStyler.styleOutput("Response Code: " + responseCode);

            if (responseCode == 200) {
                ConsoleStyler.styleOutput("Connection successful! Downloading content...");
                try (InputStream is = conn.getInputStream();
                     BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    ConsoleStyler.styleOutput(stringBuilder.toString());
                }
            } else {
                ConsoleStyler.styleOutput("Failed to connect. Response code: " + responseCode);
            }
        } catch (Exception e) {
            ConsoleStyler.styleError(Arrays.stream(e.getStackTrace()).toList().toString());
        }

        execution.finalizeExecution();
    }
}
