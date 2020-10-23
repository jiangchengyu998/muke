package com.java0829.test;

import com.java0829.bean.Boss;
import com.java0829.bean.Car;
import com.java0829.bean.Color;
import com.java0829.config.MainConfigOfAutowired;
import com.java0829.config.MainConfigOfLifeCycle;
import com.java0829.dao.BookDao;
import com.java0829.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        printBeans(applicationContext);
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        System.out.println(applicationContext);

        applicationContext.close();

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
