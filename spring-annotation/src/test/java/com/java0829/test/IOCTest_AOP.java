package com.java0829.test;

import com.java0829.aop.MathCalculator;
import com.java0829.config.MainConfigOfAOP;
import com.java0829.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(1, 0);

        applicationContext.close();
    }
}
