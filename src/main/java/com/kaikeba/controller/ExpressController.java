package com.kaikeba.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaikeba.bean.*;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.CourierService;
import com.kaikeba.service.ExpressService;
import com.kaikeba.util.BootStrapExpressUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 15:28
 */
@Controller("expressController")
public class ExpressController {

    @Resource
    private ExpressService expressService;
    @Resource
    private Message message;
    @Resource
    private Express express;
    @Resource
    private ResultData resultData;


    @RequestMapping("/express/insert.do")
    public @ResponseBody Message insert(String number,String company,String userName,String userPhone,HttpServletRequest request, HttpServletResponse response){
        express.setNumber(number);
        express.setCompany(company);
        express.setUsername(userName);
        express.setUserphone(userPhone);
        express.setSysphone("14715046330");
        try {
            int insert = expressService.insert(express);
            if(insert==0){
                message.setStatus(-1);
                message.setResult("添加失败");
            }else {
                message.setStatus(0);
                message.setResult("添加成功");
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

    @RequestMapping("/express/list.do")
    public @ResponseBody ResultData list(int pNumber,int pSize,HttpServletRequest request, HttpServletResponse response){
        int pageNum = pNumber/pSize+1;
        PageHelper.startPage(pageNum,pSize);
        List<Express> all = expressService.findAll();
        if(all!=null){
            List<BootStrapExpress> bExpress = BootStrapExpressUtil.getBootStrapExpress(all);
            Map console = expressService.findConsole();
            Integer data1_size = Integer.parseInt(console.get("data1_size").toString());
            resultData.setRows(bExpress);
            resultData.setTotal(data1_size);
        }
        return resultData;
    }

    @RequestMapping("/express/find.do")
    public @ResponseBody Message find(String number,HttpServletRequest request, HttpServletResponse response){
        Express byNumber = expressService.findByNumber(number);
        if(byNumber!=null){
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(byNumber);
        }else {
            message.setStatus(-1);
            message.setResult("查询失败，请检查单号是否正确");
        }
        return message;
    }

    @RequestMapping("/express/delete.do")
    public @ResponseBody Message delete(int id,HttpServletRequest request, HttpServletResponse response){
        int i = expressService.delete(id);
        if(i!=0){
            message.setStatus(0);
            message.setResult("删除成功");
        }else {
            message.setStatus(-1);
            message.setResult("删除失败");
        }
        return message;
    }

    @RequestMapping("/express/update.do")
    public @ResponseBody Message update(int id,String number,String company,String userName,String userPhone,int status,String sysPhone,boolean is,HttpServletRequest request, HttpServletResponse response){
        express.setId(id);
        express.setNumber(number);
        express.setCompany(company);
        express.setUsername(userName);
        express.setUserphone(userPhone);
        express.setStatus(status);
        express.setSysphone(sysPhone);
        if(is){
            express.setCode("1");
            express.setOuttime(new Date());
        }
        int i = expressService.updateByPrimaryKey(express);
        if(i!=0){
            message.setStatus(0);
            message.setResult("更新成功");
        }else {
            message.setStatus(-1);
            message.setResult("更新失败");
        }
        return message;
    }

}
