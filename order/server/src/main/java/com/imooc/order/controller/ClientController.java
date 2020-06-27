package com.imooc.order.controller;

import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ClientController
 * @Description: 客户端 控制器
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
@RestController
@Slf4j
public class ClientController {

    @Resource
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707", 3)));
        return "ok";
    }
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private LoadBalancerClient balancerClient;

//    @GetMapping("/getProductMsg")
//    public String getProductMsg(){
        // 1. 第一种方式（直接使用RestTemplate, url 写死 ）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        // 2. 第二种（利用LoadBalancerClient通过应用名获取url和端口，然后通过 RestTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = balancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
//        String response = restTemplate.getForObject(url, String.class);

        //3. 第三种方式（@LoadBalanced, 可以在restTemplate使用名字）
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

//        log.info("response={}", response);
//        return response;
//    }
}
