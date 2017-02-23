package com.xiaosky.bstar.webmvc.test.repository;


import com.xiaosky.bstar.auth.domain.User;
import com.xiaosky.bstar.auth.repository.UserRespository;
import com.xiaosky.bstar.webmvc.test.common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaob on 2017/1/16.
 */


@Transactional
public class CommonTest extends BaseTest{
    @Autowired private UserRespository userRespository;
    @Test
    public void GenId(){
        User user=new User("123456","xiaosky","小王");
        userRespository.add(user);
    }
}
