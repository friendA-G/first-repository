package com.kaikeba.controller;


import com.github.pagehelper.PageHelper;
import com.kaikeba.bean.BootStrapCourier;
import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Message;
import com.kaikeba.bean.ResultData;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.CourierService;
import com.kaikeba.util.BootStrapCourierUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 15:25
 */
@Controller("courierController")
public class CourierController {

    @Resource
    private CourierService courierService;
    @Resource
    private Message message;
    @Resource
    private ResultData resultData;
    @Resource
    private Courier courier;

    @RequestMapping("courier/list.do")
    public @ResponseBody ResultData list(int pNum,int pSize,HttpServletRequest request, HttpServletResponse response){
        int pageNum = pNum/pSize+1;
        PageHelper.startPage(pageNum,pSize);
        List<Courier> all = courierService.findAll();
        if(all!=null){
            List<BootStrapCourier> couriers = BootStrapCourierUtil.getBootStrapCourier(all);
            Map console = courierService.findConsole();
            Integer size = Integer.parseInt(console.get("size").toString());
            resultData.setRows(couriers);
            resultData.setTotal(size);
        }
        return resultData;
    }

    @RequestMapping("/courier/add.do")
    public @ResponseBody Message insert(String courierName,String courierPhone,String idNumber,String passWord,String expressNumber,HttpServletRequest request, HttpServletResponse response){
        courier.setCouriername(courierName);
        courier.setCourierphone(courierPhone);
        courier.setIdnumber(idNumber);
        courier.setPassword(passWord);
        courier.setExpressnumber(expressNumber);
        courier.setLogontime(new Date());
        try {
            int insert = courierService.insert(courier);
            if (insert != 0) {
                message.setStatus(0);
                message.setResult("添加成功");
            } else {
                message.setStatus(-1);
                message.setResult("添加失败");
            }
        } catch (RepeatPhoneException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        } catch (RepeatIdNumberException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        }
        return message;
    }

    @RequestMapping("/courier/find.do")
    public @ResponseBody Message find(String courierPhone, HttpServletRequest request, HttpServletResponse response) {
        Courier courier = courierService.findByCourierPhone(courierPhone);
        if(courier!=null){
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(courier);
        }else {
            message.setStatus(-1);
            message.setResult("查询失败");
        }
        return message;
    }

    @RequestMapping("/courier/delete.do")
    public @ResponseBody Message delete(int id, HttpServletRequest request, HttpServletResponse response){
        int i = courierService.deleteByPrimaryKey(id);
        if(i!=0){
            message.setStatus(0);
            message.setResult("删除成功");
        }else {
            message.setStatus(-1);
            message.setResult("删除失败");
        }
        return message;
    }

    @RequestMapping("/courier/update.do")
    public @ResponseBody Message update(int id,String courierName,String courierPhone,String idNumber,String passWord,String expressNumber,HttpServletRequest request, HttpServletResponse response){
        courier.setId(id);
        courier.setCouriername(courierName);
        courier.setCourierphone(courierPhone);
        courier.setIdnumber(idNumber);
        courier.setPassword(passWord);
        try {
            int update = courierService.update(courier);
            if(update!=0){
                message.setStatus(0);
                message.setResult("更新成功");
            }else {
                message.setStatus(-1);
                message.setResult("更新失败");
            }
        } catch (RepeatPhoneException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        } catch (RepeatIdNumberException e) {
            message.setStatus(-1);
            message.setResult(e.getMessage());
        }
        return message;
    }

}
