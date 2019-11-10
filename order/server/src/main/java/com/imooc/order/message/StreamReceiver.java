package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName StreamReceiver
 * @Description: stream消息接收
 * @Author jiangchengyu
 * @Date 2019/11/8
 * @Version V1.0
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object object) {
//
//        log.info("StreamReceiver:{}", object);
//    }

    /**
     * 接收orderDto 对象
     * @param object
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO object) {

        log.info("StreamReceiver:{}", object);

        // 返送要返回的消息
        return "ok";
    }
    /**
     * 接收orderDto 对象
     * @param message
     */
    @StreamListener(StreamClient.INPUT2)
    public void process2(String message) {

        log.info("StreamReceiver:{}", message);

    }
}
