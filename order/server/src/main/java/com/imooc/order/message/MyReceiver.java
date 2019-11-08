package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyReceiver
 * @Description: rabbitMQ 监听
 * @Author jiangchengyu
 * @Date 2019/11/8
 * @Version V1.0
 **/
@Slf4j
@Component
public class MyReceiver {

//  1. @RabbitListener(queues = "myQueue")
    // 2. 自动声明队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3. 自动创建， Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MyReceiver:{}", message);

    }

    /**
     * 数码供应商服务  接收消息
     * @param message 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message){
        log.info("processComputer:{}", message);

    }

    /**
     * 数码供应商服务  接收消息
     * @param message 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message){
        log.info("processFruit:{}", message);

    }
}
