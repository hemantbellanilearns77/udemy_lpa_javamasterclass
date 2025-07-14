package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Duration;

public class ExcecutionUtil {
    private Duration duration;

    public void setUp(){
        duration = new Duration();
        System.out.println("\n" + CommonConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmarkingInfo() {
        duration.updateDurationFields();
        System.out.println(CommonConstants.BENCHMARKSECTIONHEADER + "\n");
        publishBenchmarkSummary();
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRHALF);
        publishBenchMarkDetails();
    }
    private void publishBenchmarkSummary() {
        System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR + "\n");
        System.out.println("🕒 Millis: " + duration.getMilliseconds() + " ms");
        System.out.println("⏱️ Nano  : " + duration.getNanoseconds() + " ns");
    }
    private void publishBenchMarkDetails() {
        System.out.println(CommonConstants.BENCHMARKINGDETAILSSTR + "\n");
        System.out.println(duration + "\n"); // can be improvised....
    }
    public void windDown() {
        publishBenchmarkingInfo();
        System.out.println(CommonConstants.EXECUTIONENDEDSTR + "\n");
    }
}

