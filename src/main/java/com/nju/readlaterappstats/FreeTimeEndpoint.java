package com.nju.readlaterappstats;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nju.readlaterappstats.data.AppStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;


    Gson gson = new Gson();


    @POST
    @RequestMapping("addAppStats")
    public String addShareContent(@RequestBody String request) {
        List<AppStatus> appList = gson.fromJson(request, new TypeToken<List<AppStatus>>() {
        }.getType());
        String result = freeTimeManagement.addAppStatus(appList);
        return result;
    }

    @GET
    @RequestMapping("getFreeTime")
    public String getFreeTime() {

        return "";
    }
}

