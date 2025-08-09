package com.hb.study.udemy_lpa_javamasterclass.global.models;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BenchmarkModel {
    private long startTime;
    private ZonedDateTime startZoneDateTime;
    private ZonedDateTime endZonedDateTime;
    private long endTime;
    private long totalExecutionTime;
    private long seconds;
    private long milliseconds;
    private long microSeconds;
    private long nanoseconds;
    private long minutes;
    private long hours;
    private long days;

    public BenchmarkModel() {
        setStartTime(System.currentTimeMillis());
        Instant startInstant = Instant.ofEpochMilli(this.getStartTime());
        this.setStartZoneDateTime(ZonedDateTime.ofInstant(startInstant, ZoneId.systemDefault()));
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getStartZoneDateTime() {
        return startZoneDateTime;
    }

    public void setStartZoneDateTime(ZonedDateTime startZoneDateTime) {
        this.startZoneDateTime = startZoneDateTime;
    }

    public ZonedDateTime getEndZonedDateTime() {
        return endZonedDateTime;
    }

    public void setEndZonedDateTime(ZonedDateTime endZonedDateTime) {
        this.endZonedDateTime = endZonedDateTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(long totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
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

    public long getMicroSeconds() {
        return microSeconds;
    }

    public void setMicroSeconds(long microSeconds) {
        this.microSeconds = microSeconds;
    }

    public long getNanoseconds() {
        return nanoseconds;
    }

    public void setNanoseconds(long nanoseconds) {
        this.nanoseconds = nanoseconds;
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
    }

    public void update() {
        this.setEndTime(System.currentTimeMillis());
        Instant endInstant = Instant.ofEpochMilli(this.getEndTime());
        this.setEndZonedDateTime(ZonedDateTime.ofInstant(endInstant, ZoneId.systemDefault()));
        this.setTotalExecutionTime(this.getEndTime() - this.getStartTime());
        // Convert duration to milliseconds
        this.setMilliseconds(this.getTotalExecutionTime() % 1_000);
        // Convert milliseconds to seconds
        this.setSeconds(this.getTotalExecutionTime() / 1000);
        this.setNanoseconds(this.getTotalExecutionTime() * 1_000_000);
        this.setMicroSeconds(this.getTotalExecutionTime() * 1_000);
        // Convert seconds to hours, days and minutes
        this.setMinutes(this.getSeconds() / 60);
        this.setHours(this.getMinutes() / 60);
        this.setDays(this.getHours() / 24);

        // Remaining seconds, minutes, and hours
        this.setSeconds(this.getSeconds() % 60);
        this.setMinutes(this.getMinutes() % 60);
        this.setHours(this.getHours() % 24);
    }

    @Override
    public String toString() {
        /*      StringBuilder executionInfoPrintable = new StringBuilder(
                "The Time taken to execute program is:%n%d day(s), %d hour(s), %d minute(s), %d second(s), %d millisecond(s) %d microsecond(s) and %d nanosecond(s) %n"
                        .formatted(this.getDays(), this.getHours(),
                                this.getMinutes(), this.getSeconds(),
                                this.getMilliseconds(), this.getMicroSeconds(), this.getNanoseconds())
        );

        return executionInfoPrintable.toString();*/
        return CommonConstants.INDENT +
        "The Time taken to execute program is:%n%s%d day(s), %d hour(s), %d minute(s), %d second(s), %d millisecond(s) %d microsecond(s) and %d nanosecond(s) %n"
                        .formatted( CommonConstants.INDENT, this.getDays(), this.getHours(),
                                this.getMinutes(), this.getSeconds(),
                                this.getMilliseconds(), this.getMicroSeconds(), this.getNanoseconds());
    }
}