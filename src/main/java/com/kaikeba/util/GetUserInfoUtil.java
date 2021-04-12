package com.kaikeba.util;

import javax.servlet.http.HttpSession;

/**
 * @Author: Gyx
 * @Date: 2021/2/26 14:14
 */
public class GetUserInfoUtil {

    public static String getUserName(HttpSession session){
        String userName = null;
        if(session.getAttribute("adminName")!=null){
            userName = (String) session.getAttribute("adminName");
        }
        return userName;
    }

    public static String getUserPone(HttpSession session){
        if(session.getAttribute("userPhone")==null) {
            return null;
        }else {
            return (String) session.getAttribute("userPhone");
        }
    }

    public static int getCode(HttpSession session,String userPhone){
         if(session.getAttribute(userPhone)!=null){
            return (int) session.getAttribute(userPhone);
         }
        return 0;
    }
}
