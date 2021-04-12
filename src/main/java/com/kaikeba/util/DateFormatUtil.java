package com.kaikeba.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Gyx
 * @Date: 2021/2/23 16:56
 */
public class DateFormatUtil {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDateFormat(Date date){
        return dateFormat.format(date);
    }

    public static long getTime(String time){
        try {
            Date parse = dateFormat.parse(time);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
         return 0;
    }
}
