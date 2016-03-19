package com.blountmarquis.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by MLBlount on 2/7/2016.
 */
public class Timer {
    long startTime;
    long endTime;

    public void setStartTime() {
        this.startTime = System.nanoTime();
    }

    public void setEndTime() {
        this.endTime = System.nanoTime();
    }

    public String getElapsedHMS(){
        long elapsedTime = endTime - startTime;
        long hour = TimeUnit.HOURS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        long min = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);
        long remainingMin = min - (hour * 60);
        long sec = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        long remainingSeconds = sec - (remainingMin * 60);
        return hour + ":" +remainingMin + ":" + remainingSeconds;
    }

    public String getElapsedSeconds(){
        double elapsedTime = (endTime - startTime)/1000000000.0;
        return elapsedTime + "";
    }

    public String getElapsedNanoSeconds(){
        double elapsedTime = endTime - startTime;
        return elapsedTime + "";
    }
}
