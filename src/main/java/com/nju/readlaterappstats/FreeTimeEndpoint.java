package com.nju.readlaterappstats;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;

/**
 * created by yanjunjie
 */
@RestController
public class FreeTimeEndpoint {

    @POST
    @RequestMapping("addContent")
    public String addShareContent() {

        return "result";
    }
}

