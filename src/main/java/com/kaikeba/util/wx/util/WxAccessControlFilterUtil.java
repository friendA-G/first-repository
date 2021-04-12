package com.kaikeba.util.wx.util;

import com.kaikeba.util.GetUserInfoUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Gyx
 * @Date: 2021/3/1 19:05
 */


@WebFilter({
        "/index.html",
        "/addExpress.html",
        "/expressAssist.html",
        "/expressList.html",
        "/lazyboard.html",
        "/personQRcode.html",
        "/pickExpress.html",
        "/userCheckStart.html",
        "/wxIdCardUserInfoModify.html",
        "/wxUserhome.html"
})
public class WxAccessControlFilterUtil implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("微信权限过滤器初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String id = request.getSession().getId();
        Object userInfo = request.getSession().getAttribute(id);
        System.out.println("微信权限过滤器开启");
        if(userInfo!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect("/login.html");
        }
        System.out.println("微信权限过滤器结束");
    }

    @Override
    public void destroy() {
        System.out.println("微信权限过滤器销毁");
    }
}

