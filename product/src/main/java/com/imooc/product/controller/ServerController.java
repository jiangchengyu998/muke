package com.imooc.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ServerController
 * @Description: 测试 rest
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
@RestController
@Slf4j
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product' msg";
    }
}
