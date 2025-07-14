package com.hb.study.udemylpajavamasterclass.global.models;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Duration {
    private long startTime;
    private long endTime;
    private long totalExecutionTime;
    private long seconds;
    private long milliseconds;
    private long microSeconds;
    private long nanoseconds;
    private long minutes;
    private long hours;
    private long days;

    public Duration(){
        setStartTime(System.currentTimeMillis());
    }
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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
    public void updateDurationFields() {
        this.setEndTime(System.currentTimeMillis());
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
        this.setHours(this.getHours() %24);
    }

    @Override
    public String toString() {
        StringBuilder executionInfoPrintable = new StringBuilder(
        "The Time taken to execute program is:%n%d day(s), %d hour(s), %d minute(s), %d second(s), %d millisecond(s) %d microsecond(s) and %d nanosecond(s) %n"
                .formatted(this.getDays(), this.getHours(),
                        this.getMinutes(),this.getSeconds(),
                        this.getMilliseconds(), this.getMicroSeconds(), this.getNanoseconds())
        );
        Instant startInstant = Instant.ofEpochMilli(this.getStartTime());
        Instant endInstant = Instant.ofEpochMilli(this.getEndTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM);
        //LocalDateTime dateTime = LocalDateTime.ofInstant(startInstant,ZoneId.systemDefault());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(startInstant, ZoneId.systemDefault());
        executionInfoPrintable.append("The Execution started at: " + zonedDateTime.format(formatter));
        //dateTime = LocalDateTime.ofInstant(endInstant, ZoneId.systemDefault());
        zonedDateTime = ZonedDateTime.ofInstant(startInstant,ZoneId.systemDefault());
        executionInfoPrintable.append("\nThe Execution ended at: " + zonedDateTime.format(formatter));

        return executionInfoPrintable.toString();

        /*System.out.printf("The Time taken to execute program is:%n%d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n",
                this.getDays(), this.getHours(),
                this.getMinutes(),this.getSeconds(),
                this.getMilliseconds(), this.getNanoseconds());
        */
        /*
        executionStatsStringBuilder.append("\nExecution started at: " + Instant.ofEpochMilli(duration.getStartTime()).atZone(ZoneId.systemDefault()));
        executionStatsStringBuilder.append("\nExecution ended at: " + Instant.ofEpochMilli(duration.getEndTime()).atZone(ZoneId.systemDefault()));
        *//*
        Instant startInstant = Instant.ofEpochMilli(duration.getStartTime()/1_000_000);
        Instant endInstant = Instant.ofEpochMilli(duration.getEndTime()/1_000_000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        LocalDateTime dateTime = LocalDateTime.ofInstant(startInstant,ZoneId.systemDefault());
        executionInfoPrintable.append("\nExecution started at: " + dateTime.format(formatter));
        dateTime = LocalDateTime.ofInstant(endInstant, ZoneId.systemDefault());
        executionInfoPrintable.append("\nExecution ended at: " + dateTime.format(formatter));
      */

        /*return "Duration{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalExecutionTime=" + totalExecutionTime +
                ", nanoseconds=" + nanoseconds +
                ", seconds=" + seconds +
                ", milliseconds=" + milliseconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                '}';*/
    }
}