package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib;

/**
 * created by : heman on 14-07-2025, 06:36 pm, in the "udemy_lpa_javamasterclass" project
 **/

import java.util.Locale;

public class LocaleLibrary {

    public static Locale[] getIndianRegionalLocales() {
        return new Locale[] {
                Locale.of("hi", "IN"), // Hindi
                Locale.of("mr", "IN"), // Marathi
                Locale.of("ta", "IN"), // Tamil
                Locale.of("te", "IN"), // Telugu
                Locale.of("bn", "IN"), // Bengali
                Locale.of("gu", "IN"), // Gujarati
                Locale.of("kn", "IN"), // Kannada
                Locale.of("ml", "IN"), // Malayalam
                Locale.of("pa", "IN"), // Punjabi
                Locale.of("as", "IN"), // Assamese
                Locale.of("or", "IN"), // Odia
                Locale.of("ur", "IN")  // Urdu
        };
    }

    public static Locale[] getGlobalLocales() {
        return new Locale[] {
                Locale.UK,
                Locale.US,
                Locale.FRANCE,
                Locale.JAPAN,
                Locale.CHINA,
                Locale.of("de", "DE"),
                Locale.of("ar", "EG"),
                Locale.of("th", "TH"),
                Locale.of("en", "AU"),
                Locale.of("en", "ZA"),
                Locale.of("hi", "IN")
        };
    }
}
