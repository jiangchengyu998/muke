package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendMessageController
 * @Description: 发送消息控制器
 * @Author jiangchengyu
 * @Date 2019/11/8
 * @Version V1.0
 **/
@RestController
public class SendMessageController {

    @Autowired
    public StreamClient streamClient;

//    @RequestMapping("/sendMessage")
//    public void process(){
//        String message = "now " + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * 发送orderdto对象
     */
    @RequestMapping("/sendMessage")
    public void process(){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");

        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
