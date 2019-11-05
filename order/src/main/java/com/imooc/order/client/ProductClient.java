package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productList);
}
