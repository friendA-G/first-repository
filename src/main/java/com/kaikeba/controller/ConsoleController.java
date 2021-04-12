package com.kaikeba.controller;

import com.kaikeba.bean.Message;
import com.kaikeba.dao.ExpressMapper;
import com.kaikeba.service.CourierService;
import com.kaikeba.service.ExpressService;
import com.kaikeba.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/4/2 21:50
 */
@Controller("consoleController")
public class ConsoleController {

    @Resource
    private ExpressService expressService;
    @Resource
    private UserService userService;
    @Resource
    private CourierService courierService;
    @Resource
    private Message message;

    @RequestMapping("/console.do")
    public @ResponseBody Message console(){
        Map console = expressService.findConsole();
        Map console1 = userService.findConsole();
        Map console2 = courierService.findConsole();
        List list = new ArrayList();
        if(console.size()!=0){
            list.add(console);
        }else {
            list.add(-1);
        }
        if(console1.size()!=0){
            list.add(console1);
        }else {
            list.add(-1);
        }
        if(console2.size()!=0){
            list.add(console2);
        }else {
            list.add(-1);
        }
        message.setData(list);
        message.setStatus(0);
        return message;
    }
}
