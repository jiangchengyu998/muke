package com.java0829.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    /**
     *
     * @param context 能使用的上下文环境
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 判断是否Windows系统
        // 1. 能获取到IOC使用 beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 获取当前的环境变量
        Environment environment = context.getEnvironment();
        // 4. 获取bean定义注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
