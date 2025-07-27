package com.hb.study.udemylpajavamasterclass.misc_practice.datetimepractice;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib.CUIModeOrchestrator;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib.FormatterMode;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutilLib.constants.DateTimeUtilLIbConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.time.ZoneId;
import java.util.Locale;

public class DateTimeCarnival_Copy {

    public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.setUp();

        /*System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        System.out.println("🪔  WELCOME TO DATE-TIME CARNIVAL — DIWALI EDITION 🪔");
        System.out.println("🌏  A FESTIVAL OF FORMATS · CELEBRATING CULTURES IN CODE  🎆");
        System.out.println("✨  Java Locale Magic · Traditional Calendars · Currency Flair ✨");
        System.out.println("🎉  Curated by Hemant, The Formatter Maestro 🧵");
        System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟\n");*/

        System.out.println(DateTimeUtilLIbConstants.CARNIVALDEMOBANNER);

        Locale defaultLocale = Locale.getDefault();
        ZoneId defaultZone = ZoneId.systemDefault();

        for (FormatterMode mode : FormatterMode.values()) {
            CUIModeOrchestrator.runMode(mode, defaultLocale, defaultZone, null);
            System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL + "\n");
        }
        execution.windDown();
    }

}