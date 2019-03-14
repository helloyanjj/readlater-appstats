package com.nju.readlaterappstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;

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
}

