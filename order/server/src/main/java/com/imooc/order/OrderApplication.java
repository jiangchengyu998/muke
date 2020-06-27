package com.imooc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/**
//@SpringBootApplication
//@EnableDiscoveryClient    // 作为
//@EnableCircuitBreaker
// 包含上面的三個
 * @author Administrator
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.imooc.product.client")
@ComponentScan(basePackages = "com.imooc")
@EnableHystrix
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
