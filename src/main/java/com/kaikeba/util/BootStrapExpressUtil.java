package com.kaikeba.util;


import com.kaikeba.bean.BootStrapExpress;
import com.kaikeba.bean.Express;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gyx
 * @Date: 2021/2/25 21:51
 */
public class BootStrapExpressUtil {

    public static List<BootStrapExpress> getBootStrapExpress(List<Express> list){
        List<BootStrapExpress> data = new ArrayList<>();
        for (Express e:list) {
            BootStrapExpress bExpress = new BootStrapExpress();
            bExpress.setId(e.getId());
            bExpress.setNumber(e.getNumber());
            bExpress.setUserName(e.getUsername());
            bExpress.setUserPhone(e.getUserphone());
            bExpress.setCompany(e.getCompany());
            if(e.getCode()==null||e.getCode().isEmpty()){
                bExpress.setCode("已取件");
            }else {
                bExpress.setCode(e.getCode());
            }
            String inTime = DateFormatUtil.getDateFormat(e.getIntime());
            bExpress.setInTime(inTime);
            String outTime = null;
            if(e.getOuttime()==null||e.getOuttime().toString().isEmpty()){
                outTime = "未取件";
            }else {
                outTime = DateFormatUtil.getDateFormat(e.getOuttime());
            }
            bExpress.setOutTime(outTime);
            if(e.getStatus()==0){
                bExpress.setStatus("未取件");
            }else {
                bExpress.setStatus("已取件");
            }
            bExpress.setSysPhone(e.getSysphone());
            data.add(bExpress);
        }
        return data;
    }
}
