package com.hb.study.misc_utils.libs.datetimeutillib.controller;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

/**
 * created by : heman on 14-07-2025, 08:50 pm, in the "udemy_lpa_javamasterclass" project
 **/


import com.hb.study.misc_utils.libs.datetimeutillib.core.DTFormatterUtils;
import com.hb.study.misc_utils.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.misc_utils.libs.datetimeutillib.ui.FormatterGUI;
import com.hb.study.misc_utils.libs.datetimeutillib.ui.FormatterLogBuffer;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class GUIModeOrchestrator {

    public static void runMode(FormatterMode mode, Locale locale, String zoneId, String customPattern) {
        FormatterLogBuffer.append("🎭 Running Mode: " + mode.name());
        FormatterLogBuffer.append("🌐 Locale: " + locale.toString());
        FormatterLogBuffer.append("🕰️ Zone: " + zoneId + "\n");

        ZoneId zone = ZoneId.of(zoneId);

        switch (mode) {

            case MINIMAL_DEMO_MODE -> DTDemoExecutor.runMinimalDemo(locale, zone);
            case PATTERN_DEMO_FIESTA_MODE -> DTDemoExecutor.runPatternFiesta();
            case INDIAN_LANGUAGE_PATTERNS_MODE -> DTDemoExecutor.runIndianPatternsShowcase();
            case GLOBAL_LOCALES_PATTERNS_MODE -> DTDemoExecutor.runGlobalPatternsShowcase();
            case TRADITIONAL_CALENDARS_MODE -> DTDemoExecutor.runTraditionalCalendars();
            case CURRENCY_AND_NUMBERS_DEMO_MODE -> DTDemoExecutor.runCurrencyAndNumbers();
            case FORMAT_STYLES_COMBOS_DEMO_MODE -> DTDemoExecutor.runFormatStyleCombos(locale, zone);
            case VEDIC_MODE -> DTDemoExecutor.runVedicShowcase();//FormatterGUI.showVedicPlaceholder();
            case FULL_CARNIVAL_BLAST -> {
                DTDemoExecutor.runMinimalDemo(locale, zone);
                DTDemoExecutor.runPatternFiesta();
                DTDemoExecutor.runTraditionalCalendars();
                DTDemoExecutor.runCurrencyAndNumbers();
                DTDemoExecutor.runFormatStyleCombos(locale, zone);
                //DTFormatterUtils.runVedicShowcase();
                FormatterGUI.showVedicPlaceholder();
            }
        }

        if (customPattern != null) {
            ZonedDateTime now = ZonedDateTime.now();
            String formatted = DTFormatterUtils.safeFormat(now, customPattern, locale);
            ConsoleStyler.styleOutput("🎨 Custom Pattern [ %-25s ] → %s\n".formatted(customPattern, formatted));
            FormatterLogBuffer.append("🎨 Custom Pattern [" + customPattern + "] → " + formatted);
        }

        FormatterLogBuffer.append("\n" + CommonConstants.FULLLINEASTERISKSEPERATOR + "\n");

    }
}