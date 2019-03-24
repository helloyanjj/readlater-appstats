package com.nju.readlaterappstats.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * created by yanjunjie
 */

@Entity
public class FreeTime {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String userId;
    private String dataTime;
    private List<String> pushHour;

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

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public List<String> getPushHour() {
        return pushHour;
    }

    public void setPushHour(List<String> pushHour) {
        this.pushHour = pushHour;
    }

    @Override
    public String toString() {
        return "FreeTime{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", pushHour=" + pushHour +
                '}';
    }
}

