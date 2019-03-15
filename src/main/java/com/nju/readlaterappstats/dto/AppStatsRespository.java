package com.nju.readlaterappstats.dto;

import com.nju.readlaterappstats.data.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AppStatsRespository extends JpaRepository<Event, Long> {

//    @Query("SELECT ev.duration FROM Event ev " +
//            "WHERE ev.timeStamp>=beginTime AND ev.timeStamp<=endTime")
//    List<Long> findEventsByTimeStamp(@Param("userId") long beginTime,long endTime);
}
