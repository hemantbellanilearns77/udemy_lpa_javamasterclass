package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.libs.ui.FormatterLogBuffer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by : heman on 14-07-2025, 08:39 pm, in the "udemy_lpa_javamasterclass" project
 **/

public class CUIModeOrchestrator {

    public static void runMode(FormatterMode mode, Locale locale, ZoneId zone, String customPattern) {
        FormatterLogBuffer.append("🎭 Terminal Mode Execution: " + mode.name());
        FormatterLogBuffer.append("🌐 Locale: " + locale);
        FormatterLogBuffer.append("🕰️ Zone: " + zone + "\n");

        switch (mode) {

            case MINIMAL_DEMO_MODE -> DTFormatterUtils.runMinimalDemo(locale, zone);
            case PATTERN_DEMO_FIESTA_MODE -> DTFormatterUtils.runPatternFiesta();
            case INDIAN_LANGUAGE_PATTERNS_MODE-> DTFormatterUtils.runIndianPatternsShowcase();
            case GLOBAL_LOCALES_PATTERNS_MODE -> DTFormatterUtils.runGlobalPatternsShowcase();
            case TRADITIONAL_CALENDARS_MODE -> DTFormatterUtils.runTraditionalCalendars();
            case CURRENCY_AND_NUMBERS_DEMO_MODE -> DTFormatterUtils.runCurrencyAndNumbers();
            case FORMAT_STYLES_COMBOS_DEMO_MODE -> DTFormatterUtils.runFormatStyleCombos(locale, zone);
            case VEDIC_MODE -> DTFormatterUtils.runVedicShowcase();//FormatterGUI.showVedicPlaceholder();
            case FULL_CARNIVAL_BLAST -> {
                DTFormatterUtils.runMinimalDemo(locale, zone);
                DTFormatterUtils.runPatternFiesta();
                DTFormatterUtils.runTraditionalCalendars();
                DTFormatterUtils.runCurrencyAndNumbers();
                DTFormatterUtils.runFormatStyleCombos(locale, zone);
                DTFormatterUtils.runVedicShowcase();
                //FormatterGUI.showVedicPlaceholder();
            }
        }
        if (customPattern != null) {
            ZonedDateTime now = ZonedDateTime.now(zone);
            String result = DTFormatterUtils.safeFormat(now, customPattern, locale);
            System.out.printf("🎨 Custom Pattern [ %-25s ] → %s\n",customPattern, result);
            FormatterLogBuffer.append("🎨 Custom Pattern [" + customPattern + "] → " + result);
        }

        FormatterLogBuffer.append("\n" + CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
    }
}