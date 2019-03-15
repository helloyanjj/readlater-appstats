package com.nju.readlaterappstats;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.nju.readlaterappstats.data.AppStatsRequest;
import com.nju.readlaterappstats.data.AppStatus;
import org.codehaus.jettison.json.JSONArray;
import org.hibernate.Incubating;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

/**
 * created by yanjunjie
 */
@RestController
public class FreeTimeEndpoint {

    @Inject
    private FreeTimeManagement freeTimeManagement;

    Gson gson=new Gson();

    @POST
    @RequestMapping("addAppSatas2")
    public String addShareContent2(@RequestBody AppStatsRequest request) {
        String result = freeTimeManagement.addAppStatus(request);
        return result;
    }

    @POST
    @RequestMapping("addAppSatas")
    public String addShareContent(@RequestBody String request) {
//        System.out.println("========="+request);
        List<AppStatus> appList = gson.fromJson(request, new TypeToken<List<AppStatus>>()
        {}.getType());
        String result = freeTimeManagement.addAppStatus(appList);
        return result;
    }

    @GET
    @RequestMapping("getFreeTime")
    public String getFreeTime() {

        return "";
    }
}

