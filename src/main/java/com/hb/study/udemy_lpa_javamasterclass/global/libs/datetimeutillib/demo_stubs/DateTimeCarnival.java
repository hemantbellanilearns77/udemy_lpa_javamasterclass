package com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.demo_stubs;

import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.controller.CUIModeOrchestrator;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.libs.datetimeutillib.common.constants.DateTimeUtilLIbConstants;

import java.time.*;
import java.util.*;

public class DateTimeCarnival {



    public static final  ExcecutionUtil execution = new ExcecutionUtil();

        public static void main(String[] args) {

        execution.initialize(args);

        ConsoleStyler.styleOutput("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        ConsoleStyler.styleOutput("🪔  WELCOME TO DATE-TIME CARNIVAL — DIWALI EDITION 🪔");
        ConsoleStyler.styleOutput("🌏  A FESTIVAL OF FORMATS · CELEBRATING CULTURES IN CODE  🎆");
        ConsoleStyler.styleOutput("✨  Java Locale Magic · Traditional Calendars · Currency Flair ✨");
        ConsoleStyler.styleOutput("🎉  Curated by Hemant, The Formatter Maestro 🧵");
        ConsoleStyler.styleOutput("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟\n");

        ConsoleStyler.styleOutput(DateTimeUtilLIbConstants.CARNIVALDEMOBANNER);

        Locale defaultLocale = Locale.getDefault();
        ZoneId defaultZone = ZoneId.systemDefault();

        for (FormatterMode mode : FormatterMode.values()) {
            CUIModeOrchestrator.runMode(mode, defaultLocale, defaultZone, null);
        }
        execution.finalizeExecution();
    }
}