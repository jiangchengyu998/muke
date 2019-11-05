package com.imooc.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName ProductClient
 * @Description: 调用商品客户端
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}
