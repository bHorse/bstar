package com.xiaosky.bstar.webmvc.controller;

import com.xiaosky.bstar.auth.service.UserService;
import com.xiaosky.bstar.webmvc.application.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by xiaob on 2017/1/12.
 */
@Controller
public class TestController {
    @Autowired private UserService userService;
    @ResponseBody
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
       userService.restPwd("hah","123","321");
        return "hello111";
    }
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    int num=0;
    @Scheduled(initialDelay = 500,fixedDelay = 1000*5)
    public void testScude(){
        System.out.println("定时任务"+num++);
    }
}
