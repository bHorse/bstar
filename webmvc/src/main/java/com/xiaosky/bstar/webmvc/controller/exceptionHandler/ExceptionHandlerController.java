package com.xiaosky.bstar.webmvc.controller.exceptionHandler;

import com.xiaosky.bstar.auth.exception.PermissionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xiaob on 2017/2/16.
 */
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = PermissionException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "没有权限访问")
    @ResponseBody
    public String permissionAdvice(PermissionException exception){
        exception.printStackTrace();
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String errorAdvice(Exception exception){
        exception.printStackTrace();
        return "error";
    }
}
