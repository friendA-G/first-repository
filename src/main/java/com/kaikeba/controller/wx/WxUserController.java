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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Gyx
 * @Date: 2021/4/4 19:47
 */
@Controller("wxUserController")
public class WxUserController {

    @Resource
    private Message message;
    @Resource
    private UserService userService;
    @Resource
    private CourierService courierService;

    @RequestMapping("/we/getName.do")
    public @ResponseBody Message getName(HttpServletRequest request, HttpServletResponse response){
        String id = request.getSession().getId();
        try {
            User user = (User) request.getSession().getAttribute(id);
            if(user!=null){
                String userName = user.getUsername();
                if(userName!=null){
                    message.setStatus(0);
                    message.setData(userName);
                    message.setResult("欢迎你："+userName);
                }else {
                    message.setStatus(-1);
                    message.setResult("请及时更新信息");
                }
            }else {
                message.setStatus(-2);
                message.setResult("请先登录");
            }
        } catch (Exception e) {
            Courier courier = (Courier) request.getSession().getAttribute(id);
            if(courier!=null){
                String courierName = courier.getCouriername();
                if(courierName!=null){
                    message.setStatus(0);
                    message.setData(courierName);
                    message.setResult("欢迎你："+courierName);
                }else {
                    message.setStatus(-1);
                    message.setResult("请及时更新信息");
                }
            }else {
                message.setStatus(-2);
                message.setResult("请先登录");
            }
        }
        return message;
    }

    @RequestMapping("/we/getState.do")
    public @ResponseBody Message getState(HttpServletRequest request, HttpServletResponse response){
        String id = request.getSession().getId();
        try {
            User user = (User) request.getSession().getAttribute(id);
            String userName = user.getUsername();
            String userPhone = user.getUserphone();
            String idNumber = user.getIdnumber();
            String passWord = user.getPassword();
            if (userName!=null&&userPhone!=null&&idNumber!=null&&passWord!=null){
                message.setStatus(0);
            }else {
                message.setStatus(-1);
            }
        } catch (Exception e) {
            Courier courier = (Courier) request.getSession().getAttribute(id);
            String courierName = courier.getCouriername();
            String courierPhone = courier.getCourierphone();
            String idNumber = courier.getIdnumber();
            String passWord = courier.getPassword();
            if (courierName!=null&&courierPhone!=null&&idNumber!=null&&passWord!=null){
                message.setStatus(0);
            }else {
                message.setStatus(-1);
            }
        }
        return message;
    }

    @RequestMapping("/wx/getUserInfo.do")
    public @ResponseBody Message getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String id = request.getSession().getId();
        try {
            User user = (User) request.getSession().getAttribute(id);
            if (user!=null){
                message.setStatus(0);
                message.setData(user);
            }else {
                message.setStatus(-1);
            }
        } catch (Exception e) {
            Courier courier = (Courier) request.getSession().getAttribute(id);
            if (courier!=null){
                message.setStatus(1);
                message.setData(courier);
            }else {
                message.setStatus(-1);
            }
        }
        return message;
    }

    @RequestMapping("/wx/userGetCode.do")
    public @ResponseBody Message userGetCode(String userPhone,HttpServletRequest request, HttpServletResponse response){
        int code = RandomUtil.getCode();
        request.getSession().setAttribute(userPhone,code);
        message.setStatus(0);
        message.setResult("验证码已发送，请查收");
        message.setData(code);
        return message;
    }

    @RequestMapping("/wx/updateUserInfo.do")
    public @ResponseBody Message updateUserInfo(String userPhone,String userName,String idNumber,String passWord,int code,HttpServletRequest request, HttpServletResponse response){
        Integer userCode = (Integer) request.getSession().getAttribute(userPhone);
        String id = request.getSession().getId();
        if (code!=userCode){
            message.setStatus(-1);
            message.setResult("验证码有误，请检查");
        }else {
            try {
                User user = (User) request.getSession().getAttribute(id);
                user.setUsername(userName);
                user.setUserphone(userPhone);
                user.setIdnumber(idNumber);
                user.setPassword(passWord);
                int i = userService.updateByPrimaryKey(user);
                if(i!=0){
                    message.setStatus(0);
                    message.setResult("修改成功");
                }else {
                    message.setStatus(-1);
                    message.setResult("修改失败");
                }
            } catch (Exception e) {
                if(e.getMessage().endsWith("for key 'userPhone'")||e.getMessage().endsWith("for key 'idNumber'")){
                    message.setStatus(-1);
                    message.setResult(e.getMessage());
                }else {
                    Courier courier = (Courier) request.getSession().getAttribute(id);
                    courier.setCourierphone(userPhone);
                    courier.setCouriername(userName);
                    courier.setIdnumber(idNumber);
                    courier.setPassword(passWord);
                    try {
                        int update = courierService.update(courier);
                        if(update!=0){
                            message.setResult("修改成功");
                            message.setStatus(0);
                        }else {
                            message.setStatus(-1);
                            message.setResult("修改失败");
                        }
                    } catch (RepeatPhoneException ex) {
                        message.setStatus(-1);
                        message.setResult(ex.getMessage());
                    } catch (RepeatIdNumberException ex) {
                        message.setStatus(-1);
                        message.setResult(ex.getMessage());
                    }
                }

            }
        }
        return message;
    }

}
