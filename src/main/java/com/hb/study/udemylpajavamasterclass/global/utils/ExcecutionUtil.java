package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.BenchmarkModel;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ExcecutionUtil {
    private BenchmarkModel benchmarkModel;

    public void initialize() {
        benchmarkModel = new BenchmarkModel();
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmark() {
        ConsoleStyler.startSection(CommonConstants.BENCHMARKSECTIONHEADER);
        publishBenchmarkSummary();
        ConsoleStyler.halfDivider();
        publishBenchmarkDetails();
        ConsoleStyler.endSection(CommonConstants.BENCHMARKSECTIONHEADER);
    }
    private void publishBenchmarkSummary() {
        //System.out.println(CommonConstants.BENCHMARKINSUMMARYSTR);
        ConsoleStyler.styleIntro(CommonConstants.BENCHMARKINSUMMARYSTR);
        if (benchmarkModel.getDays() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYDAYSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getDays()));
        }
        if (benchmarkModel.getHours() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYHOURSSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getHours()));

            //System.out.println(CommonConstants.INDENT + "🕒 Hours: " + duration.getHours() + " hour(s)");
        }
        if (benchmarkModel.getMinutes() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYMINUTESSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getMinutes()));
            //System.out.println(CommonConstants.INDENT + "🕒 Minutes: " + duration.getMinutes() + " minute(s)");
        }
        if (benchmarkModel.getSeconds() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYSECONDSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getSeconds()));
            //System.out.println(CommonConstants.INDENT + "🕒 Second: " + duration.getSeconds() + " second(s)");
        }
        System.out.printf(CommonConstants.BENCHMARKINSUMMARYMILLISSSTR.formatted(
                CommonConstants.INDENT, benchmarkModel.getMicroSeconds()));
        System.out.printf(CommonConstants.BENCHMARKINSUMMARYNANOSSSTR.formatted(
                CommonConstants.INDENT, benchmarkModel.getNanoseconds()));

        //System.out.println(CommonConstants.INDENT + "🕒 Milliseconds: " + duration.getMilliseconds() + " ms");
        //System.out.println(CommonConstants.INDENT + "⏱️ Nanoseconds  : " + duration.getNanoseconds() + " ns");

    }

    private void publishBenchmarkDetails() {
        //System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR);
        ConsoleStyler.styleIntro(CommonConstants.BENCHMARKINGDETAILSSTR);
        System.out.println(benchmarkModel);
        DateTimeFormatter benchmarkDTFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(CommonConstants.INDENT + "The execution started at: " + benchmarkModel.getStartZoneDateTime().
                format(benchmarkDTFormatter) + ".");
        System.out.println(CommonConstants.INDENT + "The execution ended at: " + benchmarkModel.getEndZonedDateTime().
                format(benchmarkDTFormatter) + ".");
        ConsoleStyler.divider();
    }

    public void finalizeExecution() {
        benchmarkModel.update();
        publishBenchmark();
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONENDEDSTR);
    }


}
