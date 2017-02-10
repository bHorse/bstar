package com.xiaosky.bstar.webmvc.test.repository;

import com.xiaosky.bstar.auth.domain.test.Address;
import com.xiaosky.bstar.auth.domain.test.City;
import com.xiaosky.bstar.auth.domain.test.TestUser;
import com.xiaosky.bstar.auth.repository.TestUserRespository;
import com.xiaosky.bstar.webmvc.test.common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * 联系hibernate的一个demo
 * Created by xiaob on 2017/2/1.
 */
@Transactional
public class Demo01 extends BaseTest{
    @Autowired TestUserRespository testUserRespository;

    /**
     * 对值类型的添加操作
     */
    @Test
    public void testVal(){
        TestUser testUser=testUserRespository.get(3);
        Address address=new Address("北京");
        Address address2=new Address("南京");
        testUser.addAddress(address);
        testUser.addAddress(address2);
    }
    @Test
    public void testDelVal(){
        TestUser testUser=testUserRespository.get(3);
        Address address=new Address("南京");
        testUser.delAddress(address);
    }

    /**
     * 获取值对象所关联的实体对象
     */
    @Test
    public void loadVal(){
        TestUser testUser=testUserRespository.get(3);
        Set<Address> addresses = testUser.getAddresses();
        addresses.stream().forEach(x->{
            City city = x.getCity();
            System.out.println(city.getName());});
    }


}
