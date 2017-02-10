package com.xiaosky.bstar.webmvc.test.controller;

import com.xiaosky.bstar.auth.service.UserService;
import com.xiaosky.bstar.webmvc.application.TestService;
import com.xiaosky.bstar.webmvc.test.common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by xiaob on 2017/1/12.
 */
public class TestTest extends BaseTest {
    @Resource
    UserService userService;
    @Test
    public void test1(){
        Assert.assertNotNull(userService);
    }
}
