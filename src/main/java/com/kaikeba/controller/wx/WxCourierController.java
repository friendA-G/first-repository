package com.kaikeba.controller.wx;

import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Express;
import com.kaikeba.bean.Message;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.ExpressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author: Gyx
 * @Date: 2021/4/4 23:39
 */
@Controller("wxCourierController")
public class WxCourierController {

    @Resource
    private Message message;
    @Resource
    private Express express;
    @Resource
    private ExpressService expressService;


    @RequestMapping("/wx/insertExpress.do")
    public @ResponseBody Message insertExpress(String number,String company,String userName,String userPhone,HttpServletRequest request, HttpServletResponse response){
        String id = request.getSession().getId();
        Courier courier = (Courier) request.getSession().getAttribute(id);
        express.setUsername(userName);
        express.setUserphone(userPhone);
        express.setCompany(company);
        express.setNumber(number);
        express.setIntime(new Date());
        express.setSysphone(courier.getCourierphone());
        try {
            int insert = expressService.insert(express);
            if(insert!=0){
                message.setStatus(0);
                message.setResult("添加成功");
            }else {
                message.setStatus(-1);
                message.setResult("添加失败");
            }
        } catch (RepeatIdNumberException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        } catch (RepeatPhoneException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        }
        return message;
    }

}
