package com.xiaosky.bstar.auth.service;


/**
 * Created by xiaob on 2017/1/12.
 */

public interface UserService {
    /**
     * 重置密码
     * @param id 待修改的人员id
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return true 表示修改成功,false表示修改失败
     */
    boolean restPwd(String id,String oldPwd,String newPwd);
}
