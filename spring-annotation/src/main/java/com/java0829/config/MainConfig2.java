package com.java0829.config;

import com.java0829.bean.Color;
import com.java0829.bean.ColorFactoryBean;
import com.java0829.bean.Person;
import com.java0829.bean.Red;
import com.java0829.condition.LinuxCondition;
import com.java0829.condition.MyImportBeanDefinitionRegistrar;
import com.java0829.condition.MyImportSelector;
import com.java0829.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

// 类中统一设置，满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
// 导入组件是，id默认是全类名
public class MainConfig2 {

    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  多实例
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  单实例（默认值），IOC容器启动会调用方法创建对象放到IOC容器中。
     *                                               以后每次获取就是直接从容器（map.get()）中拿
     *  懒加载：
     *          单实例bean，默认在容器启动的时候创建对象；
     *          懒加载，容器启动不创建对象，第一次使用在创建
     */
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("person")
    @Lazy
    public Person person(){
        System.out.println("给容器中添加person。。。。。");
        return new Person("张三", 20);
    }

    /**
     * @Conditional 按照一定条件进行判断，满足条件给容器中注册bean
     * 如果是Windows系统，给容器中注册bill
     * 如果是Linux系统，给容器中注册Linus
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates", 61);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 48);
    }

    /**
     * 1. 包扫描+组件标注注解
     * 2. @Bean
     * 3. @Import[快速导入组件]
     *      1. @Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     *      2. ImportSelector:返回需要导入的组件的全类名的数组
     *      3. ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4. 使用spring提供的FactoryBean（工厂bean）
     *      1. 默认获取到的是工厂bean调用getObject获取到的对象
     *      2. 要获取工厂bean本身，我们需要给id前面加一个&
     *          &factorybean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
