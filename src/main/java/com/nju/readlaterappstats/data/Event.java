package com.nju.readlaterappstats.data;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * created by yanjunjie
 */
@Component
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String userId;
    private String packageName;
    private String timeStamp;
    private long duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", userId=" + userId +
                ", packageName='" + packageName + '\'' +
                ", timeStamp=" + timeStamp +
                ", duration=" + duration +
                '}';
    }
}

