package com.xiaosky.bstar.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xiaob on 2017/2/22.
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "没有权限访问")
public class PermissionException extends RuntimeException {
    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }
}
