package com.hb.study.udemylpajavamasterclass.global.constants;

public class CommonConstants {
    public static String programOutputBegins = "\n" + "*".repeat(54) + " Beginning of Program Execution ond Output " + "*".repeat(54) + "\n";
    public static String programOutputEnds = "\n" + "*".repeat(54) + " End of Program Execution and Output " + "*".repeat(54) + "\n";
    public static String executionDurationStatsIntro = "The stats for \"duration\" of this program's execution are as below:\n";
    public static String asteriskSeparatorLine = "*".repeat(144) + "\n";
    public static String DDMMYYYPATTERN = "dd/MM/yyyy";


    public static void main(String[] args) {
        System.out.println(programOutputBegins);
        System.out.println(asteriskSeparatorLine);
    }
}
