package com.xiaosky.bstar.webmvc.service;

import com.xiaosky.bstar.auth.annotation.Permission;
import org.springframework.stereotype.Service;

/**
 * Created by xiaob on 2017/2/22.
 */
@Service
public class TestService {
    @Permission(module = "ddd",privilege = 0x01010101)
    public void testAccess(int abc){
        System.out.println("参数为:"+abc);
    }
}
