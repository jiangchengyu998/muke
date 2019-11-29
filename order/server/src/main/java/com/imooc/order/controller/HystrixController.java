package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    // 超时配置
//    @HystrixCommand(fallbackMethod = "fallback")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder",
                Collections.singletonList("157875227953464068"),
                String.class);
//        throw new RuntimeException("发生异常了");
    }

    private String fallback(){
        return "太拥挤，稍后再试";
    }

    private String defaultFallback(){
        return "默认提示：太拥挤了，稍后再试。。。";
    }
}
