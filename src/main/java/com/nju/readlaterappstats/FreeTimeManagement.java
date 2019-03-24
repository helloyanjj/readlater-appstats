package com.nju.readlaterappstats;

import com.nju.readlaterappstats.data.AppStatsRequest;
import com.nju.readlaterappstats.data.AppStatus;
import com.nju.readlaterappstats.data.Event;
import com.nju.readlaterappstats.dto.AppStatsRespository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by yanjunjie
 */
@Component
public class FreeTimeManagement {
    @Inject
    private Event event;

    @Inject
    private AppStatsRespository appStatsRespository;

    private static Timer timer=new Timer();

    public String addAppStatus(AppStatsRequest request) {
        event = new Event();

        try {
            event.setPackageName(request.getPackageName());
            event.setTimeStamp("");
            event.setDuration(request.getTotalTimeInForeground());
            appStatsRespository.save(event);
        } catch (Exception e) {
            return ReturnInfo.fail;
        }
        return ReturnInfo.success;
    }

    public String addAppStatus(List<AppStatus> appStatus) {
        List<String> time = new ArrayList<>();
        try {
            for (AppStatus a : appStatus) {
                event = new Event();
                event.setPackageName(a.getPackageName());
                event.setTimeStamp(stampToDate(a.getFirstTimeStamp()));
                event.setDuration(a.getTotalTimeInForeground());

                if (a.getTotalTimeInForeground()>= 30) {

                    String[] nowTime = stampToHour(a.getFirstTimeStamp()).split(" ");
                    time.add(nowTime[1]);
                }

                appStatsRespository.save(event);
            }

            String[] timeString=time.toArray(new String[time.size()]);
            List<String> pushTime = array(timeString);
            System.out.println(pushTime);
            pushMessage(pushTime);

        } catch (Exception e) {
            e.printStackTrace();
            return ReturnInfo.fail;
        }
        return ReturnInfo.success;
    }

    public static List<String> array(String[] array){
        List<String> pushTime = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer integer = map.get(array[i]);
            map.put(array[i], integer == null?1:integer+1);
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
            if (entry.getValue() >= 4) {
                pushTime.add(entry.getKey());
            }
        }
        return pushTime;
    }

    public String stampToDate(long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

    public String stampToHour(long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

    public String stampToYear(long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }



    public void pushMessage(List<String> pushTime) {
        long currentTime=System.currentTimeMillis();
        String currentYear = stampToYear(currentTime);
        List<String> pushTimes = new ArrayList<>();
        for (int i=0;i<pushTime.size();i++) {
            String time = currentYear+ " " + pushTime.get(i) + ":00:00" ;
            pushTimes.add(time);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();


        String string = "2019-3-23 16:53:06";
        SimpleDateFormat sdsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            timer.schedule(new PushTask(), sdsf.parse(string));
        } catch (Exception e) {

        }

//        for(int i = 0;i<pushTimes.size();i++){
//            try {
//                date = sdf.parse(pushTimes.get(i));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            timer.schedule(new PushTask(), date);
//        }

    }

//    public static void main(String[] args) {
//        Date date = new Date();
//        String string = "2019-3-23 16:43:06";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            timer.schedule(new PushTask(), sdf.parse(string));
//        } catch (Exception e) {
//
//        }
//    }

    public String freeTimeFromAppStats() {
        Map<String, Integer> timeQuantum = new HashMap<>();
        timeQuantum.put("",0);



        List<Long> freeTime = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        long endTime = calendar.getTimeInMillis();

        calendar.add(Calendar.DAY_OF_WEEK, -1);
        long beginTime = calendar.getTimeInMillis();
        return "";
    }

}

