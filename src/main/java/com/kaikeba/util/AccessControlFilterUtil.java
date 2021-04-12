package com.kaikeba.util;

import com.kaikeba.util.GetUserInfoUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Gyx
 * @Date: 2021/2/26 19:53
 */

@WebFilter(value = {"/admin/index.html","/admin/views/*","/express/*"})
public class AccessControlFilterUtil implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("权限过滤器初始化");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("权限过滤器启动");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userName = GetUserInfoUtil.getUserName(request.getSession());
        if(userName!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect("/message.jsp");
        }
        System.out.println("权限过滤器结束");
    }

    @Override
    public void destroy() {
        System.out.println("权限过滤器销毁");
    }
}
