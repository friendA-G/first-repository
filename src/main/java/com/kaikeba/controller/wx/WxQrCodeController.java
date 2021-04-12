package com.kaikeba.controller.wx;

import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Message;
import com.kaikeba.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Gyx
 * @Date: 2021/4/4 15:22
 */
@Controller("wxQrCodeController")
public class WxQrCodeController {

    @Resource
    private Message message;

    @RequestMapping("/wx/setQrCode.do")
    public void setQrCode(String status,String code,HttpServletRequest req , HttpServletResponse resp){
        if(code!=null){
            req.getSession().setAttribute("qrCode",code);
        }else {
            String id = req.getSession().getId();
            try {
                User user = (User) req.getSession().getAttribute(id);
                if(user!=null){
                    String userPhone = user.getUserphone();
                    req.getSession().setAttribute("qrCode",userPhone);
                }
            } catch (Exception e) {
                Courier courier = (Courier) req.getSession().getAttribute(id);
                if(courier!=null){
                    String courierPhone = courier.getCourierphone();
                    req.getSession().setAttribute("qrCode",courierPhone);
                }
            }
        }
        try {
            if(status!=null){
                resp.sendRedirect("/personQRcode1.html");
            }else {
                resp.sendRedirect("/personQRcode.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/wx/getQrCode.do")
    public @ResponseBody Message getQrCode(HttpServletRequest request,HttpServletResponse response){
        Object qrCode = request.getSession().getAttribute("qrCode");
        if(qrCode!=null){
            message.setStatus(0);
            message.setData(qrCode);
        }else {
            message.setStatus(-1);
            message.setResult("请登录后再获取二维码");
        }
        return message;
    }
}
