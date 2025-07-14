package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Duration;

public class ExcecutionUtil {
    private Duration duration;

    public void setUp(){
        duration = new Duration();
        System.out.println("\n" + CommonConstants.EXECUTIONSETUPSSTR);
    }

    public void publishBenchmarkingSummary() {
        System.out.println("\n" + CommonConstants.BENCHMARKINGINTROSTR);
        duration.updateDurationFields();
        System.out.println(duration);
    }
    public void windDown() {
        publishBenchmarkingSummary();
        System.out.println("\n" + CommonConstants.EXECUTIONENDEDSTR);
    }
}

 /*       // Print the result
        System.out.printf("Time taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n",
                days, hours, minutes, seconds, milliseconds, nanoseconds);*/


  /*  public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }*/
   /* public long getStartTime() {
        return startTime;
    }



    public long getEndTime() {
        return endTime;
    }



    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }*/

