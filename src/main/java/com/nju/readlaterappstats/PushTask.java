package com.nju.readlaterappstats;

import com.nju.readlaterappstats.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by yanjunjie
 */

public class PushTask extends TimerTask {
    @Autowired
    RestTemplate restTemplate;

    @Inject
    private User user = new User();

    @Override
    public void run() {
        User user = new User();
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("ssss");

//        restTemplate.postForEntity("http://RL-MESSAGEPUSH/sendMessagePush",user, User.class);

//        restTemplate.getForEntity("http://RL-BACKEND/hello", String.class).getBody();

    }
}

