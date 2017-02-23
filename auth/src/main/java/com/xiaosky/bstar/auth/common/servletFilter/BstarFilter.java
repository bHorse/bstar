package com.xiaosky.bstar.auth.common.servletFilter;

import com.xiaosky.bstar.auth.common.util.SessionDataUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xiaob on 2017/2/22.
 */
@WebFilter(urlPatterns = "/*")
public class BstarFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        SessionDataUtil.init(httpServletRequest);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        SessionDataUtil.destroy();
    }
}
