package com.hb.study.udemylpajavamasterclass.global.libs.ui;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

/**
 * created by : heman on 14-07-2025, 08:50 pm, in the "udemy_lpa_javamasterclass" project
 **/


import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class ModeExecutor {

    public static void runMode(FormatterMode mode, Locale locale, String zoneId, String customPattern) {
        FormatterLogBuffer.append("🎭 Running Mode: " + mode.name());
        FormatterLogBuffer.append("🌐 Locale: " + locale.toString());
        FormatterLogBuffer.append("🕰️ Zone: " + zoneId + "\n");

        ZoneId zone = ZoneId.of(zoneId);

        switch (mode) {
            case MINIMAL_MODE -> DTFormatterUtils.runMinimalDemo(locale, zone);
            case LANGUAGE_DEMO -> PatternLibrary.runLanguagePatterns();
            case VEDIC_MODE -> FormatterGUI.showVedicPlaceholder();
            case FULL_CARNIVAL_BLAST -> {
                DTFormatterUtils.runMinimalDemo(locale, zone);
                PatternLibrary.runLanguagePatterns();
                FormatterGUI.showVedicPlaceholder();
                NumberUtils.runGlobalCurrencyAndNumber();
                PatternLibrary.runGlobalPatterns();
                DTFormatterUtils.runFormatStyleCombos(locale, zone);
            }
        }

        if (customPattern != null) {
            ZonedDateTime now = ZonedDateTime.now();
            String formatted = DTFormatterUtils.safeFormat(now, customPattern, locale);
            FormatterLogBuffer.append("🎨 Custom Pattern [" + customPattern + "] → " + formatted);
        }

        FormatterLogBuffer.append("\n" + CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
    }
}