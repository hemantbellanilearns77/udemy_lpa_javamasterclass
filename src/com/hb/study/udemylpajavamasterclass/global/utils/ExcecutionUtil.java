package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Duration;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ExcecutionUtil {
    private Duration duration;

    public void setUp() {
        duration = new Duration();
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmarkInfo() {
        ConsoleStyler.startSection(CommonConstants.BENCHMARKSECTIONHEADER);
        publishBenchmarkSummary();
        System.out.println((CommonConstants.INDENT + CommonConstants.ASTERISKSEPERATORLINESTRHALF + "\n" ));
        publishBenchMarkDetails();
        ConsoleStyler.endSection(CommonConstants.BENCHMARKSECTIONHEADER);
    }

    private void publishBenchmarkSummary() {
        System.out.println(CommonConstants.BENCHMARKINSUMMARYSTR);
        if (duration.getDays() > 0) {
            System.out.println(CommonConstants.INDENT + "🕒 Days: " + duration.getDays() + " day(s)");
            System.out.println(CommonConstants.INDENT + "🕒 Hours: " + duration.getHours() + " hour(s)");
            return;
        }
        if (duration.getHours() > 0) {
            System.out.println(CommonConstants.INDENT + "🕒 Hours: " + duration.getHours() + " hour(s)");
            System.out.println(CommonConstants.INDENT + "🕒 Minutes: " + duration.getMinutes() + " minute(s)");
            return;
        }
        if (duration.getMinutes() > 0) {
            System.out.println(CommonConstants.INDENT + "🕒 Minutes: " + duration.getMinutes() + " minute(s)");
            System.out.println(CommonConstants.INDENT + "🕒 Second: " + duration.getSeconds() + " second(s)");
            return;
        }
        if (duration.getSeconds() > 0) {
            System.out.println(CommonConstants.INDENT + "🕒 Second: " + duration.getSeconds() + " second(s)");
            System.out.println(CommonConstants.INDENT + "🕒 Millis: " + duration.getMilliseconds() + " ms");
            System.out.println(CommonConstants.INDENT + "⏱️ Nano  : " + duration.getNanoseconds() + " ns");
            return;
        }
        System.out.println(CommonConstants.INDENT + "🕒 Millis: " + duration.getMilliseconds() + " ms");
        System.out.println(CommonConstants.INDENT + "⏱️ Nano  : " + duration.getNanoseconds() + " ns");

    }

    private void publishBenchMarkDetails() {
        System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR);       System.out.println(duration);
        DateTimeFormatter benchmarkDTFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(CommonConstants.INDENT + "The execution started at: " + duration.getStartZoneDateTime().
                format(benchmarkDTFormatter) + ".");
        System.out.println(CommonConstants.INDENT + "The execution ended at: " + duration.getEndZonedDateTime().
                format(benchmarkDTFormatter) + ".");
        ConsoleStyler.divider();
    }

    public void windDown() {
        duration.updateDurationFields();
        publishBenchmarkInfo();
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONENDEDSTR);
    }
}
