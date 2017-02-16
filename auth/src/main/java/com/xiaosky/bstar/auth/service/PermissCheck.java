package com.xiaosky.bstar.auth.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xiaob on 2017/2/12.
 */
@Aspect
public class PermissCheck {
    /*@Pointcut("@annotation()")
    public void ponintcutPermiss(){

    }*/

    //@Before("ponintcutPermiss1()")
    public void sayHello(){
        System.out.println("hello,我是切面");
    }
}
