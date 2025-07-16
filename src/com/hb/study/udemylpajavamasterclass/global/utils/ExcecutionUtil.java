package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Duration;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ExcecutionUtil {
    private Duration duration;

    public void setUp() {
        duration = new Duration();
        System.out.println("\n" + CommonConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmarkingInfo() {
        System.out.println(CommonConstants.BENCHMARKSECTIONHEADER);
        publishBenchmarkSummary();
        System.out.println((CommonConstants.INDENT + CommonConstants.ASTERISKSEPERATORLINESTRHALF + "\n" ));
        publishBenchMarkDetails();
    }

    private void publishBenchmarkSummary() {
        System.out.println(CommonConstants.BENCHMARKINSUMMARYSTR);
        if (duration.getDays() > 0) {
            System.out.println("🕒 Days: " + duration.getDays() + " day(s)");
            System.out.println("🕒 Hours: " + duration.getHours() + " hour(s)");
            return;
        }
        if (duration.getHours() > 0) {
            System.out.println("🕒 Hours: " + duration.getHours() + " hour(s)");
            System.out.println("🕒 Minutes: " + duration.getMinutes() + " minute(s)");
            return;
        }
        if (duration.getMinutes() > 0) {
            System.out.println("🕒 Minutes: " + duration.getMinutes() + " minute(s)");
            System.out.println("🕒 Second: " + duration.getSeconds() + " second(s)");
            return;
        }
        if (duration.getSeconds() > 0) {
            System.out.println("🕒 Second: " + duration.getSeconds() + " second(s)");
            System.out.println("🕒 Millis: " + duration.getMilliseconds() + " ms");
            System.out.println("⏱️ Nano  : " + duration.getNanoseconds() + " ns");
            return;
        }
        System.out.println(CommonConstants.INDENT + "🕒 Millis: " + duration.getMilliseconds() + " ms");
        System.out.println(CommonConstants.INDENT + "⏱️ Nano  : " + duration.getNanoseconds() + " ns");

    }

    private void publishBenchMarkDetails() {
        System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR);
        System.out.println(duration);
        DateTimeFormatter benchmarkDTFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(CommonConstants.INDENT + "The execution started at: " + duration.getStartZoneDateTime().
                format(benchmarkDTFormatter) + ".");
        System.out.println(CommonConstants.INDENT + "The execution ended at: " + duration.getEndZonedDateTime().
                format(benchmarkDTFormatter) + ".");
        ConsoleStyler.divider();
    }

    public void windDown() {
        duration.updateDurationFields();
        publishBenchmarkingInfo();
        System.out.println(CommonConstants.EXECUTIONENDEDSTR + "\n");
    }
}
