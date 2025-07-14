package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.libs.ui.FormatterLogBuffer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by : heman on 14-07-2025, 08:39 pm, in the "udemy_lpa_javamasterclass" project
 **/

public class FormatterOrchestrator {

    public static void runMode(FormatterMode mode, Locale locale, ZoneId zone, String customPattern) {
        FormatterLogBuffer.append("🎭 Terminal Mode Execution: " + mode.name());
        FormatterLogBuffer.append("🌐 Locale: " + locale);
        FormatterLogBuffer.append("🕰️ Zone: " + zone + "\n");

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
            ZonedDateTime now = ZonedDateTime.now(zone);
            String result = DTFormatterUtils.safeFormat(now, customPattern, locale);
            FormatterLogBuffer.append("🎨 Custom Pattern [" + customPattern + "] → " + result);
        }

        FormatterLogBuffer.append("\n" + CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
    }
}