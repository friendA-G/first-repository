package com.kaikeba.controller;


import com.github.pagehelper.PageHelper;
import com.kaikeba.bean.BootStrapUser;
import com.kaikeba.bean.Message;
import com.kaikeba.bean.ResultData;
import com.kaikeba.bean.User;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.UserService;
import com.kaikeba.util.BootStrapUserUtil;
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
 * @Date: 2021/3/29 15:27
 */
@Controller("userController")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private Message message;
    @Resource
    private ResultData resultData;
    @Resource
    private User user;


    @RequestMapping("/user/list.do")
    public @ResponseBody ResultData list(int pageNum, int pageSize, HttpServletRequest request, HttpServletResponse response){
        int pNum = pageNum/pageSize+1;
        PageHelper.startPage(pNum,pageSize);
        List<User> all = userService.findAll();
        if(all!=null){
            List<BootStrapUser> users = BootStrapUserUtil.getBootStrapUser(all);
            Map console = userService.findConsole();
            Integer size = Integer.parseInt(console.get("size").toString());
            resultData.setRows(users);
            resultData.setTotal(size);
        }
        return resultData;
    }

    @RequestMapping("/user/add.do")
    public @ResponseBody Message add(String userName,String userPhone,String idNumber,String passWord,HttpServletRequest request, HttpServletResponse response){
        user.setUsername(userName);
        user.setUserphone(userPhone);
        user.setIdnumber(idNumber);
        user.setPassword(passWord);
        user.setLogontime(new Date());
        try {
            int insert = userService.insert(user);
            if (insert==1){
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

    @RequestMapping("/user/find.do")
    public @ResponseBody Message find(String userPhone,HttpServletRequest request, HttpServletResponse response){
        User byPhone = userService.findByPhone(userPhone);
        if(byPhone!=null){
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(byPhone);
        }else {
            message.setStatus(-1);
            message.setResult("该用户不存在，查询失败");
        }
        return message;
    }

    @RequestMapping("/user/delete.do")
    public @ResponseBody Message delete(int id,HttpServletRequest request, HttpServletResponse response){
        int delete = userService.delete(id);
        if(delete!=0){
            message.setStatus(0);
            message.setResult("删除成功");
        }else {
            message.setStatus(-1);
            message.setResult("删除失败");
        }
        return message;
    }

    @RequestMapping("/user/update.do")
    public @ResponseBody Message update(int id,String userName,String userPhone,String idNumber,String passWord,HttpServletRequest request, HttpServletResponse response){
        user.setId(id);
        user.setUsername(userName);
        user.setUserphone(userPhone);
        user.setIdnumber(idNumber);
        user.setPassword(passWord);
        try {
            int i = userService.updateByPrimaryKey(user);
            if(i!=0){
                message.setStatus(0);
                message.setResult("修改成功");
            }else {
                message.setStatus(-1);
                message.setResult("修改失败");
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
