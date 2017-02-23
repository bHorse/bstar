package com.xiaosky.bstar.auth.common.util;

import com.xiaosky.bstar.auth.annotation.Permission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * Created by xiaob on 2017/2/16.
 */
public class AopHandlerReflUtil {
    /**
     * 获取被通知的切点的方法
     * @param joinPoint
     * @return
     */
    public static Method getMethod(ProceedingJoinPoint joinPoint){
        Signature sig = joinPoint.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = joinPoint.getTarget();
        try {
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            return currentMethod;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }return null;
    }

    /**
     * 找到注解
     * @param joinPoint
     * @return
     */
    public static Permission getPermissionAnnotation(ProceedingJoinPoint joinPoint){
        Method method = getMethod(joinPoint);
        Permission permission = method.getAnnotation(Permission.class);
        if (permission==null) throw new NullPointerException("没有权限注解");
        return permission;
    }
}
