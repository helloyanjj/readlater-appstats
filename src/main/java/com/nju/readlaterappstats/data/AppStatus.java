package com.nju.readlaterappstats.data;

public class AppStatus {

    private long userId;
    private String packageName;
    private long firstTimeStamp;
    private long lastTimeStamp;
    private long lastTimeUsed;
    private long totalTimeInForeground;
    private long queryTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getFirstTimeStamp() {
        return firstTimeStamp;
    }

    public void setFirstTimeStamp(long firstTimeStamp) {
        this.firstTimeStamp = firstTimeStamp;
    }

    public long getLastTimeStamp() {
        return lastTimeStamp;
    }

    public void setLastTimeStamp(long lastTimeStamp) {
        this.lastTimeStamp = lastTimeStamp;
    }

    public long getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(long lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    public long getTotalTimeInForeground() {
        return totalTimeInForeground;
    }

    public void setTotalTimeInForeground(long totalTimeInForeground) {
        this.totalTimeInForeground = totalTimeInForeground;
    }

    public long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(long queryTime) {
        this.queryTime = queryTime;
    }

}
