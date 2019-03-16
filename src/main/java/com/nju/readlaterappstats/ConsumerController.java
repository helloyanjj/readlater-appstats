package com.nju.readlaterappstats;

import com.nju.readlaterappstats.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

/**
 * created by yanjunjie
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GET
    @RequestMapping("ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://RL-BACKEND/hello", String.class).getBody();
    }

    @POST
    @RequestMapping("sendPush")
    public String sendPush() {
        User user = new User();
//        return restTemplate.getForEntity("http://RL-BACKEND/hello", String.class).getBody();
        restTemplate.postForEntity("http://RL-MESSAGEPUSH/sendMessagePush",user, String.class);
        return "success";
    }
}

