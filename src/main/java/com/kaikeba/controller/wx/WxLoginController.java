package com.kaikeba.controller.wx;

import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Message;
import com.kaikeba.bean.User;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.CourierService;
import com.kaikeba.service.UserService;
import com.kaikeba.util.RandomUtil;
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
 * @Date: 2021/4/4 13:36
 */
@Controller("wxLoginController")
public class WxLoginController {

    @Resource
    private Message message;
    @Resource
    private UserService userService;
    @Resource
    private CourierService courierService;
    @Resource
    private User user;
    @Resource
    private Courier courier;

    @RequestMapping("/wx/getCode.do")
    public @ResponseBody Message getCode(String userPhone, HttpServletRequest request, HttpServletResponse response){
        int code = RandomUtil.getCode();
        request.getSession().setAttribute(userPhone,code);
        message.setStatus(0);
        message.setResult("获取成功");
        message.setData(code);
        return message;
    }

    @RequestMapping("/wx/login.do")
    public @ResponseBody Message login(String userPhone,int code, HttpServletRequest request, HttpServletResponse response){
        Integer attribute = (Integer) request.getSession().getAttribute(userPhone);
        if(attribute==null){
            message.setStatus(-1);
            message.setResult("该电话号码未获取验证码");
        }else if(attribute!=code){
            message.setStatus(-1);
            message.setResult("验证码输入有误请检查");
        }else {
            Courier byCourierPhone = courierService.findByCourierPhone(userPhone);
            if(byCourierPhone!=null){
                courier.setId(byCourierPhone.getId());
                courier.setLogintime(new Date());
                try {
                    int update = courierService.update(courier);
                    if(update!=0){
                        String id = request.getSession().getId();
                        request.getSession().setAttribute(id,byCourierPhone);
                        message.setStatus(0);
                        message.setResult("登录成功");
                    }else {
                        message.setStatus(-1);
                        message.setResult("登录失败，请重新登录");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    message.setStatus(-1);
                    message.setResult("登录失败，请重新登录");
                }
                request.getSession().setAttribute("courier",request.getSession().getId());
            }else {
                User byPhone = userService.findByPhone(userPhone);
                if(byPhone!=null){
                    user.setId(byPhone.getId());
                    user.setLogintime(new Date());
                    try {
                        int i = userService.updateByPrimaryKey(user);
                        if(i!=0){
                            String id = request.getSession().getId();
                            request.getSession().setAttribute(id,byPhone);
                            message.setStatus(0);
                            message.setResult("登录成功");
                        }else {
                            message.setStatus(-1);
                            message.setResult("登录失败，请重新登录");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        message.setStatus(-1);
                        message.setResult("登录失败，请重新登录");
                    }
                }else {
                    user.setId(null);
                    user.setUserphone(userPhone);
                    user.setLogontime(new Date());
                    user.setLogintime(new Date());
                    try {
                        int insert = userService.insert(user);
                        if (insert!=0){
                            String id = request.getSession().getId();
                            request.getSession().setAttribute(id,user);
                            message.setStatus(0);
                            message.setResult("登录成功");
                        }else {
                            message.setStatus(-1);
                            message.setResult("登录失败，请重新登录");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        message.setStatus(-1);
                        message.setResult("登录失败，请重新登录");
                    }
                }
            }
        }
        return message;
    }

    @RequestMapping("/wx/index.do")
    public void index(String userPhone,HttpServletRequest request,HttpServletResponse response){
        try {
            response.sendRedirect("/index.html");
            request.getSession().removeAttribute(userPhone);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/wx/getStatus.do")
    public @ResponseBody Message getStatus(HttpServletRequest request,HttpServletResponse response){
        Object courier = request.getSession().getAttribute("courier");
        if(courier!=null&&request.getSession().getId().equals(courier)){
            message.setStatus(1);
        }else {
            message.setStatus(0);
        }
        return message;
    }

    @RequestMapping("/wx/exit.do")
    public void exit(HttpServletRequest request,HttpServletResponse response){
        request.getSession().invalidate();
        try {
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
