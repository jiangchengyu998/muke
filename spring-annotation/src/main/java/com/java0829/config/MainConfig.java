package com.java0829.config;

import com.java0829.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 配置类等于以前的配置文件
@Configuration
@ComponentScan(value = "com.java0829",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
// value 指定要扫描的包
// excludeFilters = Filter[] ,指定扫描的时候按照规则排除哪些主键
// includeFilters = Filter[] ,指定扫描的时候按照规则包含那些主键，useDefaultFilters = false
// FilterType.ANNOTATION 按照注解
// FilterType.ASSIGNABLE_TYPE 按照类型
public class MainConfig {

    // 给容器注册一个bean，名字是方法名
    @Bean("person")
    public Person person01(){
        return new Person("lisi", 20);
    }
}
