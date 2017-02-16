package com.xiaosky.bstar.webmvc.application;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xiaob on 2017/2/12.
 */
@Aspect
public class PermissCheck {
    @Pointcut("execution(* com.xiaosky.bstar.webmvc.controller.TestController.hello(..))")
    public void ponintcutPermiss(){

    }

    @Before("ponintcutPermiss()")
    public void sayHello(){
        System.out.println("hello,我是切面");
    }
}
