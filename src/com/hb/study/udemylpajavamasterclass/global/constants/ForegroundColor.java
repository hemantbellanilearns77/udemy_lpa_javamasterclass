package com.hb.study.udemylpajavamasterclass.global.constants;

/**
 * created by : heman on 21-07-2025, 05:43 pm, in the "udemy_lpa_javamasterclass" project
 **/
public enum ForegroundColor {
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    BRIGHT_BLACK("\u001B[90m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_BLUE("\u001B[94m"),
    BRIGHT_MAGENTA("\u001B[95m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_WHITE("\u001B[97m"),

    // Extended expressive tones
    GRAY("\u001B[38;2;128;128;128m"),
    ORANGE("\u001B[38;2;255;165;0m"),
    PINK("\u001B[38;2;255;192;203m"),
    TEAL("\u001B[38;2;0;128;128m"),
    INDIGO("\u001B[38;2;75;0;130m"),
    VIOLET("\u001B[38;2;238;130;238m"),
    GOLD("\u001B[38;2;255;215;0m"),
    SALMON("\u001B[38;2;250;128;114m"),
    SKY_BLUE("\u001B[38;2;135;206;235m"),
    LIME("\u001B[38;2;0;255;0m"),
    BROWN("\u001B[38;2;165;42;42m"),
    OLIVE("\u001B[38;2;128;128;0m"),
    MAROON("\u001B[38;2;128;0;0m"),
    NAVY("\u001B[38;2;0;0;128m"),
    TURQUOISE("\u001B[38;2;64;224;208m"),
    MINT("\u001B[38;2;189;252;201m"),
    CORAL("\u001B[38;2;255;127;80m"),
    ROSE("\u001B[38;2;255;102;204m"),
    LAVENDER("\u001B[38;2;230;230;250m"),
    APRICOT("\u001B[38;2;251;206;177m"),
    BEIGE("\u001B[38;2;245;245;220m"),
    WHEAT("\u001B[38;2;245;222;179m"),
    PEACH("\u001B[38;2;255;229;180m"),
    MUSTARD("\u001B[38;2;255;219;88m"),
    PERIWINKLE("\u001B[38;2;204;204;255m"),
    SLATE("\u001B[38;2;112;128;144m"),
    CHARCOAL("\u001B[38;2;54;69;79m"),
    SNOW("\u001B[38;2;255;250;250m"),
    CHOCOLATE("\u001B[38;2;210;105;30m"),
    EMERALD("\u001B[38;2;80;200;120m"),
    DENIM("\u001B[38;2;21;96;189m"),
    CERULEAN("\u001B[38;2;42;82;190m"),
    RUBY("\u001B[38;2;224;17;95m"),
    AMBER("\u001B[38;2;255;191;0m"),
    LEMON("\u001B[38;2;255;247;0m"),
    SAPPHIRE("\u001B[38;2;15;82;186m"),
    TAN("\u001B[38;2;210;180;140m"),
    PLUM("\u001B[38;2;142;69;133m"),
    MANGO("\u001B[38;2;255;130;67m"),
    ICE_BLUE("\u001B[38;2;173;216;230m"),
    NEUTRAL("");

    private final String ansiCode;

    ForegroundColor(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    public String getAnsiCode() { return ansiCode; }

}
