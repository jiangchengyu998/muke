package com.imooc.order.message;

import com.imooc.order.utils.JsonUtil;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProductInfoReciver
 * @Description: 减库存消息接收者
 * @Author jiangchengyu
 * @Date 2019/11/12
 * @Version V1.0
 **/
@Component
@Slf4j
public class ProductInfoReciver {
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        // message =>  ProductInfoOutput
        ProductInfoOutput productInfoOutput = (ProductInfoOutput)JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列【{}】接收到消息：{}", "productInfo",  productInfoOutput);

        // 保存到redis

    }
}
