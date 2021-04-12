package com.kaikeba.controller.wx;

import com.kaikeba.bean.*;
import com.kaikeba.service.ExpressService;
import com.kaikeba.util.BootStrapExpressUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/4/4 16:09
 */
@Controller("wxExpressController")
public class WxExpressController {

    @Resource
    private Message message;
    @Resource
    private ExpressService expressService;


    @RequestMapping("/wx/findExpressByNumber.do")
    public @ResponseBody Message findExpressByNumber(String number, HttpServletRequest request, HttpServletResponse response){
        Express express = expressService.findByNumber(number);
        List list = new ArrayList();
        list.add(express);
        if(express!=null){
            List bExpress = BootStrapExpressUtil.getBootStrapExpress(list);
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(bExpress);
        }else {
            message.setStatus(-1);
            message.setResult("该单号不存在，查询失败");
        }
        return message;
    }

    @RequestMapping("/wx/expressList.do")
    public @ResponseBody Message findExpressListByPhone(HttpServletRequest request, HttpServletResponse response){
        String id = request.getSession().getId();
        Map express = new  HashMap();
        try {
            User user = (User) request.getSession().getAttribute(id);
            if(user!=null){
                List<Express> all = expressService.findAllByPhoneAndCode(user.getUserphone());
                List<Express> all1 = expressService.findAllByPhoneNotCode(user.getUserphone());
                if(all.size()!=0){
                    List<BootStrapExpress> express1 = BootStrapExpressUtil.getBootStrapExpress(all);
                    express.put("express1",express1);
                }else {
                    express.put("express1",null);
                }
                if(all1.size()!=0){
                    List<BootStrapExpress> express2 = BootStrapExpressUtil.getBootStrapExpress(all1);
                    express.put("express2",express2);
                }else {
                    express.put("express2",null);
                }
                if(all.size()==0&&all1.size()==0){
                    message.setStatus(-1);
                    message.setResult("暂无快递信息");
                    return message;
                }else {
                    message.setStatus(0);
                    message.setResult("查询成功");
                    message.setData(express);
                }
            }else {
                message.setStatus(-1);
                message.setResult("请先登录");
                return message;
            }
        } catch (Exception e) {
            Courier courier = (Courier) request.getSession().getAttribute(id);
            if(courier!=null){
                List<Express> all = expressService.findAllByPhoneAndCode(courier.getCourierphone());
                List<Express> all1 = expressService.findAllByPhoneNotCode(courier.getCourierphone());
                if(all.size()!=0){
                    List<BootStrapExpress> express1 = BootStrapExpressUtil.getBootStrapExpress(all);
                    express.put("express1",express1);
                }else {
                    express.put("express1",null);
                }
                if(all1.size()!=0){
                    List<BootStrapExpress> express2 = BootStrapExpressUtil.getBootStrapExpress(all1);
                    express.put("express2",express2);
                }else {
                    express.put("express2",null);
                }
                if(all.size()==0&&all1.size()==0){
                    message.setStatus(-1);
                    message.setResult("暂无快递信息");
                    return message;
                }else {
                    message.setStatus(0);
                    message.setResult("查询成功");
                    message.setData(express);
                }
            }else {
                message.setStatus(-1);
                message.setResult("请先登录");
                return message;
            }
        }
        return message;
    }

    @RequestMapping("/wx/findExpressByCode.do")
    public @ResponseBody
    Message findExpressByCode(String code, HttpServletRequest request, HttpServletResponse response) {
        Express byCode = expressService.findByCode(code);
        if(byCode!=null){
            List<Express> list = new ArrayList<>();
            list.add(byCode);
            List<BootStrapExpress> express = BootStrapExpressUtil.getBootStrapExpress(list);
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(express);
        }else {
            message.setStatus(-1);
            message.setResult("该取件码有误，请检查");
        }
        return message;
    }

    @RequestMapping("/wx/getExpressListToStatus.do")
    public @ResponseBody
    Message getExpressListToStatus(String userPhone,HttpServletRequest request, HttpServletResponse response) {
        List<Express> all = expressService.findAllByPhoneAndCode(userPhone);
        if(all.size()!=0){
            List<BootStrapExpress> expressList = BootStrapExpressUtil.getBootStrapExpress(all);
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(expressList);
        }else {
            message.setStatus(-1);
            message.setResult("该用户无快递信息");
        }
        return message;
    }

    @RequestMapping("/we/updateStatus.do")
    public @ResponseBody
    Message updateStatus(String code, HttpServletRequest request, HttpServletResponse response) {
        int i = expressService.updateExpressByCode(code);
        if(i!=0){
            message.setStatus(0);
            message.setResult("出库成功");
        }else {
            message.setStatus(0);
            message.setResult("出库失败");
        }
        return message;
    }
}
