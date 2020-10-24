package com.java0829.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 声明式事务
 *
 * 环境搭建:
 * 1. 导入相关依赖
 *          数据源、数据库驱动、Spring-jdbc模块
 * 2. 配置数据源、JdbcTemplate（spring提供的简化数据库操作的工具）操作数据
 * 3. 给方法上标注@Transactional 表示当前方法是一个事务方法
 * 4. @EnableTransactionManagement 开启基于注解的事务管理功能
 * 5. 配置事务管理器来控制事务 DataSourceTransactionManager
 */
@EnableTransactionManagement
@ComponentScan("com.java0829.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        // Spring 对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件而已
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

}
