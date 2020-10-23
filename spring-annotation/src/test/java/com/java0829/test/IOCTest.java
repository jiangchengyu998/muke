package com.java0829.test;

import com.java0829.bean.Blue;
import com.java0829.bean.Person;
import com.java0829.config.MainConfig;
import com.java0829.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);
        Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean);

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    @Test
    public void test03(){

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 动态获取环境变量的值 Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        System.out.println("容器创建完成。。。。");
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
//        System.out.println(person == person2);

    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
    }
}
