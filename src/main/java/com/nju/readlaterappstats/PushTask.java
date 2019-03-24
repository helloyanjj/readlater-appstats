package com.nju.readlaterappstats;

import com.nju.readlaterappstats.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.util.TimerTask;

/**
 * created by yanjunjie
 */

public class PushTask extends TimerTask {
    @Autowired
    RestTemplate restTemplate;

    @Inject
    private User user = new User();

//    private ServletContext context = null;

//    public TaskOrderCancle(ServletContext context) {
//        this.context = context;
//        //取得上下文，然后从上下文中获得applicationcontext，之后可以获得想要的bean。
//        WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(context);
//        this.restTemplate = (RestTemplate) wc.getBean("restTemplate");
//    }


    @Override
    public void run() {
        User user = new User();

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("ssss");
        restTemplate.postForEntity("http://localhost:2223/sendMessagePush",user, String.class);
//        restTemplate.postForEntity("http://RL-MESSAGEPUSH/sendMessagePush",user, String.class);

//        restTemplate.getForEntity("http://RL-BACKEND/hello", String.class).getBody();

    }
}

