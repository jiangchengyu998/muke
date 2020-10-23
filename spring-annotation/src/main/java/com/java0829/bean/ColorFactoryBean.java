package com.java0829.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean.....");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    // 控制是否单例
    // true 是单例
    // false 多实例，每次获取重新new
    public boolean isSingleton() {
        return false;
    }
}
