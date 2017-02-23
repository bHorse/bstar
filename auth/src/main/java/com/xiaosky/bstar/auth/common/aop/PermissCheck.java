package com.xiaosky.bstar.auth.common.aop;

import com.xiaosky.bstar.auth.annotation.Permission;
import com.xiaosky.bstar.auth.common.util.AopHandlerReflUtil;
import com.xiaosky.bstar.auth.common.util.SessionDataUtil;
import com.xiaosky.bstar.auth.domain.Module;
import com.xiaosky.bstar.auth.domain.User;
import com.xiaosky.bstar.auth.exception.PermissionException;
import com.xiaosky.bstar.auth.repository.ModuleRspository;
import com.xiaosky.bstar.auth.repository.UserRespository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiaob on 2017/2/21.
 */
@Aspect
@Component
public class PermissCheck {
    @Autowired private UserRespository userRespository;
    @Autowired private ModuleRspository moduleRspository;

    @Pointcut(value = "@annotation(com.xiaosky.bstar.auth.annotation.Permission)")
    public void pointcut(){}
    @Around("pointcut()")
    public void check(ProceedingJoinPoint joinPoint) throws Throwable {
        Permission permissionAnnotation = AopHandlerReflUtil.getPermissionAnnotation(joinPoint);
        String currentUserId = SessionDataUtil.getCurrentUserId();
        if (currentUserId==null) throw new PermissionException("你还未登录!");
        User user = userRespository.get(currentUserId);

        String moduleStr = permissionAnnotation.module();
        Module module = moduleRspository.load(moduleStr);


        boolean validated = user.isValidated(module, permissionAnnotation.privilege());
        if (validated){
            joinPoint.proceed();
        }throw new PermissionException("你不拥有此权限");



    }
}
