package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.controller;

import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.DTFormatterUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by : heman on 14-07-2025, 08:39 pm, in the "udemy_lpa_javamasterclass" project
 **/

public class CUIModeOrchestrator {
    private CUIModeOrchestrator(){

    }

    public static void runMode(FormatterMode mode, Locale locale, ZoneId zone, String customPattern) {
        ConsoleStyler.styleInitializationInfo(
                "🎭 Terminal Mode Execution: " + mode.name() + "\n"
                + "🌐 Locale: " + locale.toString() + "\n"
                + "🕰️ Zone: " + zone + "\n"
        );

        switch (mode) {
            case MINIMAL_DEMO_MODE -> DTDemoExecutor.runMinimalDemo(locale, zone);
            case PATTERN_DEMO_FIESTA_MODE -> DTDemoExecutor.runPatternFiesta();
            case INDIAN_LANGUAGE_PATTERNS_MODE-> DTDemoExecutor.runIndianPatternsShowcase();
            case GLOBAL_LOCALES_PATTERNS_MODE -> DTDemoExecutor.runGlobalPatternsShowcase();
            case TRADITIONAL_CALENDARS_MODE -> DTDemoExecutor.runTraditionalCalendars();
            case CURRENCY_AND_NUMBERS_DEMO_MODE -> DTDemoExecutor.runCurrencyAndNumbers();
            case FORMAT_STYLES_COMBOS_DEMO_MODE -> DTDemoExecutor.runFormatStyleCombos(locale, zone);
            case VEDIC_MODE -> DTDemoExecutor.runVedicShowcase();
            case FULL_CARNIVAL_BLAST -> {
                DTDemoExecutor.runMinimalDemo(locale, zone);
                DTDemoExecutor.runPatternFiesta();
                DTDemoExecutor.runTraditionalCalendars();
                DTDemoExecutor.runCurrencyAndNumbers();
                DTDemoExecutor.runFormatStyleCombos(locale, zone);
                DTDemoExecutor.runVedicShowcase();
            }
        }
        if (customPattern != null) {
            ZonedDateTime now = ZonedDateTime.now(zone);
            String result = DTFormatterUtils.safeFormat(now, customPattern, locale);
            ConsoleStyler.styleOutput("🎨 Custom Pattern [ %-25s ] → %s".formatted(customPattern, result));
        }
    }
}