package com.kaikeba.util;

import com.kaikeba.bean.BootStrapCourier;
import com.kaikeba.bean.BootStrapUser;
import com.kaikeba.bean.Courier;
import com.kaikeba.bean.User;
import com.kaikeba.util.DateFormatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 21:42
 */
public class BootStrapCourierUtil {

    public static List<BootStrapCourier> getBootStrapCourier(List<Courier> list){
        List<BootStrapCourier> bList = new ArrayList<>();
        for (Courier u:list){
            BootStrapCourier courier = new BootStrapCourier();
            courier.setId(u.getId());
            courier.setCourierName(u.getCouriername());
            courier.setCourierPhone(u.getCourierphone());
            courier.setPassWord(u.getPassword());
            courier.setIdNumber(u.getIdnumber());
            String expressNumber = null;
            if(Integer.parseInt(u.getExpressnumber())>100000){
                expressNumber = "10W+";
            }else if(Integer.parseInt(u.getExpressnumber())>50000){
                expressNumber = "5W+";
            }else if(Integer.parseInt(u.getExpressnumber())>10000){
                expressNumber = "1W+";
            }else {
                expressNumber = u.getExpressnumber();
            }
            courier.setExpressNumber(expressNumber);
            String logonTime = DateFormatUtil.getDateFormat(u.getLogontime());
            courier.setLogonTime(logonTime);
            String loginTime = null;
            if(u.getLogintime()==null||u.getLogintime().toString().isEmpty()){
                loginTime = "未登录";
            } else {
                loginTime = DateFormatUtil.getDateFormat(u.getLogintime());
            }
            courier.setLoginTime(loginTime);
            bList.add(courier);
        }
        return bList;
    }
}
