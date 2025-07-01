package com.hb.study.udemy.lpa.globalcommon.utils;

public class ExecutionTiming {
    private long startTime;
    private long endTime;
    private long duration;
    private long nanoseconds;
    private long seconds;
    private long milliseconds;
    private long minutes;
    private long hours;
    private long days;

    public ExecutionTiming(){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void printExecutionTime(){
        calculateExecutionTime();
        // Print the result
        // Print the result
        System.out.printf("Time taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n",
                days, hours, minutes, seconds, milliseconds, nanoseconds);
    }
    public void calculateExecutionTime(){
        // Calculate the duration in nanoseconds
        duration = endTime - startTime;

        // Convert duration to milliseconds
        milliseconds = duration / 1_000_000;
        nanoseconds = duration % 1_000_000;

        // Convert milliseconds to seconds
        seconds = milliseconds / 1000;
        milliseconds = milliseconds % 1000;

        // Convert seconds to hours, days and minutes
        minutes = seconds / 60;
        hours = minutes / 60;
        days = hours / 24;

        // Remaining seconds, minutes, and hours
        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;

 /*       // Print the result
        System.out.printf("Time taken: %d days, %d hours, %d minutes, %d seconds, %d milliseconds, %d nanoseconds%n",
                days, hours, minutes, seconds, milliseconds, nanoseconds);*/

}
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
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
}
