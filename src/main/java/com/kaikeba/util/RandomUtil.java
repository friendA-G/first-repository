package com.kaikeba.util;

import java.util.Random;

/**
 * @Author: Gyx
 * @Date: 2021/2/25 17:06
 */
public class RandomUtil {
    private static Random random = new Random();

    public static int getCode(){
       return (random.nextInt(900000) + 100000);
    }
}
