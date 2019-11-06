package com.imooc.order.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description: id生成工具类
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
