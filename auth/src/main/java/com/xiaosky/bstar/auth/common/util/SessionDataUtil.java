package com.xiaosky.bstar.auth.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用该工具类,必须确保登录的时候,将userId信息存放进了session中
 * 如果将整个User都放入session中,当user信息发生变更的时候,会不方便更新
 * Created by xiaob on 2017/2/22.
 */
public class SessionDataUtil {
    private static final String USER = "userId";
    private static ThreadLocal<String> sessionData = new ThreadLocal<>();

    public static void init(HttpServletRequest httpServletRequest) {
        Object userId = httpServletRequest.getSession().getAttribute(USER);
        if (userId != null) {
            sessionData.set((String) userId);
        } else {//还未登录,不做任何操作
        }
    }

    public static void destroy() {
        sessionData.remove();
    }

    public static String getCurrentUserId() {
        return sessionData.get();
    }
}
