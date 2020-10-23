package com.java0829.condition;

import com.java0829.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     *                把所有需要添加到容器中的bean，调用
     *                 BeanDefinitionRegistry.registerBeanDefinition 手工注册
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.java0829.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.java0829.bean.Blue");
        BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
        if (red && blue) {
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
