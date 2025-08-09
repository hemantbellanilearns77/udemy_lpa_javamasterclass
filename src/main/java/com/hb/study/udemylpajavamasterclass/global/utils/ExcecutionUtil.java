package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.constants.ExecutionConstants;
import com.hb.study.udemylpajavamasterclass.global.models.BenchmarkModel;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ExcecutionUtil {
    private BenchmarkModel benchmarkModel;

    public void initialize() {
        benchmarkModel = new BenchmarkModel();
        ConsoleStyler.printBanner(ExecutionConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmark() {
        ConsoleStyler.startSection(ExecutionConstants.BENCHMARKSECTIONHEADER);
        publishBenchmarkSummary();
        ConsoleStyler.halfDivider();
        publishBenchmarkDetails();
        ConsoleStyler.endSection(ExecutionConstants.BENCHMARKSECTIONHEADER);
    }
    private void publishBenchmarkSummary() {
        ConsoleStyler.styleIntro(ExecutionConstants.BENCHMARKINSUMMARYSTR);
        if (benchmarkModel.getDays() > 0) {
            System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYDAYSSTR.formatted(
                    benchmarkModel.getDays()));
        }
        if (benchmarkModel.getHours() > 0) {
            System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYHOURSSSTR.formatted(
                    benchmarkModel.getHours()));

        }
        if (benchmarkModel.getMinutes() > 0) {
            System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYMINUTESSSTR.formatted(
                    benchmarkModel.getMinutes()));

        }
        if (benchmarkModel.getSeconds() > 0) {
            System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYSECONDSSTR.formatted(
                    benchmarkModel.getSeconds()));
        }
        System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYMILLISSSTR.formatted(
                benchmarkModel.getMicroSeconds()));
        System.out.printf(ExecutionConstants.BENCHMARKINSUMMARYNANOSSSTR.formatted(
                benchmarkModel.getNanoseconds()));

    }

    private void publishBenchmarkDetails() {
        ConsoleStyler.styleIntro(ExecutionConstants.BENCHMARKINGDETAILSSTR);
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
        ConsoleStyler.printBanner(ExecutionConstants.EXECUTIONENDEDSTR);
    }

}
