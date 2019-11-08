package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName MySenderTest
 * @Description: rabbitMQ发送测试
 * @Author jiangchengyu
 * @Date 2019/11/8
 * @Version V1.0
 **/
@Component
public class MySenderTest extends OrderApplicationTests{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());

    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());

    }
}
