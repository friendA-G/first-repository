package com.kaikeba.util;

import com.kaikeba.bean.BootStrapUser;
import com.kaikeba.bean.User;
import com.kaikeba.util.DateFormatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 20:08
 */
public class BootStrapUserUtil {

    public static List<BootStrapUser> getBootStrapUser(List<User> list){
        List<BootStrapUser> bList = new ArrayList<>();
        for (User u:list){
           BootStrapUser user = new BootStrapUser();
           user.setId(u.getId());
           user.setUserName(u.getUsername());
           user.setUserPhone(u.getUserphone());
           user.setPassWord(u.getPassword());
           user.setIdNumber(u.getIdnumber());
           String logonTime = DateFormatUtil.getDateFormat(u.getLogontime());
           user.setLogonTime(logonTime);
           String loginTime = null;
           if(u.getLogintime()==null||u.getLogintime().toString().isEmpty()){
               loginTime = "未登录";
           } else {
               loginTime = DateFormatUtil.getDateFormat(u.getLogintime());
           }
           user.setLoginTime(loginTime);
           bList.add(user);
        }
        return bList;
    }
}
