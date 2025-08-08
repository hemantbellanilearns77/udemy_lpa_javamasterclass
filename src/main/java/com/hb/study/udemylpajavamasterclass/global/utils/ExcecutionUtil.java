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
        //ConsoleStyler.styleOutput(CommonConstants.BENCHMARKINSUMMARYSTR);
        ConsoleStyler.styleIntro(CommonConstants.BENCHMARKINSUMMARYSTR);
        if (benchmarkModel.getDays() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYDAYSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getDays()));
        }
        if (benchmarkModel.getHours() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYHOURSSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getHours()));

            //ConsoleStyler.styleOutput(CommonConstants.INDENT + "🕒 Hours: " + duration.getHours() + " hour(s)");
        }
        if (benchmarkModel.getMinutes() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYMINUTESSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getMinutes()));
            //ConsoleStyler.styleOutput(CommonConstants.INDENT + "🕒 Minutes: " + duration.getMinutes() + " minute(s)");
        }
        if (benchmarkModel.getSeconds() > 0) {
            System.out.printf(CommonConstants.BENCHMARKINSUMMARYSECONDSSTR.formatted(
                    CommonConstants.INDENT, benchmarkModel.getSeconds()));
            //ConsoleStyler.styleOutput(CommonConstants.INDENT + "🕒 Second: " + duration.getSeconds() + " second(s)");
        }
        System.out.printf(CommonConstants.BENCHMARKINSUMMARYMILLISSSTR.formatted(
                CommonConstants.INDENT, benchmarkModel.getMicroSeconds()));
        System.out.printf(CommonConstants.BENCHMARKINSUMMARYNANOSSSTR.formatted(
                CommonConstants.INDENT, benchmarkModel.getNanoseconds()));

        //ConsoleStyler.styleOutput(CommonConstants.INDENT + "🕒 Milliseconds: " + duration.getMilliseconds() + " ms");
        //ConsoleStyler.styleOutput(CommonConstants.INDENT + "⏱️ Nanoseconds  : " + duration.getNanoseconds() + " ns");

    }

    private void publishBenchmarkDetails() {
        //ConsoleStyler.styleOutput(CommonConstants.BENCHMARKINGDETAILSSTR);
        ConsoleStyler.styleIntro(CommonConstants.BENCHMARKINGDETAILSSTR);
        ConsoleStyler.styleOutput(benchmarkModel.toString());
        DateTimeFormatter benchmarkDTFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        ConsoleStyler.styleOutput(CommonConstants.INDENT + "The execution started at: " + benchmarkModel.getStartZoneDateTime().
                format(benchmarkDTFormatter) + ".");
        ConsoleStyler.styleOutput(CommonConstants.INDENT + "The execution ended at: " + benchmarkModel.getEndZonedDateTime().
                format(benchmarkDTFormatter) + ".");
        ConsoleStyler.divider();
    }

    public void finalizeExecution() {
        benchmarkModel.update();
        publishBenchmark();
        ConsoleStyler.printBanner(CommonConstants.EXECUTIONENDEDSTR);
    }


    public void windDown() {

    }
}
