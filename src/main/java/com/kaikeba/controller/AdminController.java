package com.kaikeba.controller;

import com.kaikeba.bean.Admin;
import com.kaikeba.bean.Message;
import com.kaikeba.service.AdminService;
import com.kaikeba.util.DateFormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 15:24
 */
@Controller("adminController")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private Admin admin;
    @Resource
    private Message message;

    @RequestMapping("/admin/login.do")
    public @ResponseBody Message login(String username,String password,HttpServletResponse response, HttpServletRequest request){
        admin.setAdminname(username);
        admin.setPassword(password);
        Integer id = adminService.findInfo(admin);
        if(id!=null){
            message.setStatus(0);
            message.setResult("登陆成功");
            request.getSession().setAttribute("adminName",username);
            admin.setAdminid(id);
            admin.setLoginip(request.getRemoteAddr());
            admin.setLogintime(DateFormatUtil.getDateFormat(new Date()));
            adminService.updateLoginInfo(admin);
        }else {
            message.setStatus(-1);
            message.setResult("登陆失败");
        }
        return message;
    }

    @RequestMapping("/admin/index.do")
    public void index(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("/admin/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/exit.do")
    public void exit(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        try {
            response.sendRedirect("/admin/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
