package com.xiaosky.bstar.webmvc.test.repository;

import com.xiaosky.bstar.auth.domain.Role;
import com.xiaosky.bstar.auth.domain.User;
import com.xiaosky.bstar.auth.repository.RoleRespository;
import com.xiaosky.bstar.auth.repository.UserRespository;
import com.xiaosky.bstar.webmvc.test.common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaob on 2017/2/6.
 */
@Transactional
public class Demo02 extends BaseTest {
    @Autowired private UserRespository userRespository;
    @Autowired private RoleRespository roleRespository;
    @Test
    public void testAdd(){
        User user = userRespository.load("4028808559f9db7c0159f9db7ee90000");
        Role role=roleRespository.load("8a80828e5a116273015a11627bd60000");
        Set<Role>roles=new HashSet<>();
        roles.add(role);
        user.addRoles(roles);
    }
    @Test
    public void addRole(){
        Role role=new Role("大内总管2");
        User user = new User("123456","wangsan3","黑星");
        Set<Role>roles=new HashSet<>();
        roles.add(role);
        user.addRoles(roles);
        userRespository.add(user);
    }
    @Test
    //测试级联删除
    public void testDelUserCacse(){
        User user = userRespository.load("8a80828e5a12a1ae015a12a1b47c0000");
        userRespository.remove(user);

    }
    @Test
    public void testMerge(){
        Role role = roleRespository.get("8a80828e5a12cee1015a12cee6c80001");
        User user = userRespository.get("8a80828e5a12dd94015a12dd99b60000");
        Set<User>users=new HashSet<>();
        users.add(user);
        role.addUsers(users);
    }
}
