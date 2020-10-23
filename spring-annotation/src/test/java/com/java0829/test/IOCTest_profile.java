package com.java0829.test;

import com.java0829.bean.Yellow;
import com.java0829.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_profile {

    // 1、使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=dev
    // 2、代码的方式激活某种环境
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 1. 创建一个applicationContext
        // 2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("prod");
        // 3. 注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
