package com.xiaosky.bstar.auth.service.impl;

import com.sun.istack.internal.NotNull;
import com.xiaosky.bstar.auth.domain.User;
import com.xiaosky.bstar.auth.repository.UserRespository;
import com.xiaosky.bstar.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaob on 2017/1/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRespository userRespository;
    public boolean restPwd( String id, String oldPwd, String newPwd) {
        User user = userRespository.get(id);
        return user.restPwd(oldPwd,newPwd);
    }
}
