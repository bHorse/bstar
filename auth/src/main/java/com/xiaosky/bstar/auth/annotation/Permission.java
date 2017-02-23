package com.xiaosky.bstar.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiaob on 2017/2/16.
 */
@Retention(RetentionPolicy.RUNTIME)//代表Permission注解保留在的阶段
@Target(ElementType.METHOD)//标注在方法上面
public @interface Permission {

    /** 模块 */
    String module() ;
    /** 权限值 */
    int privilege() default 0;

}