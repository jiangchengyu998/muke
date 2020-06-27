package com.imooc.order.client;

import com.imooc.order.common.OrderId;
import com.imooc.order.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @ClassName OrderClient
 * @Description: 提供给其他服务调用的client
 * @Author jiangchengyu
 * @Date 2020年6月27日09:14:11
 * @Version V1.0
 **/
@FeignClient(name = "order", fallback = OrderClient.OrderClientFallback.class)
public interface OrderClient {

    @PostMapping("/order/getOder")
    ResultVO<OrderId> getOder(OrderId orderId);

    @Component
    @Slf4j
    static class OrderClientFallback implements OrderClient {

        @Override
        public ResultVO<OrderId> getOder(OrderId orderId) {
            ResultVO<OrderId> resultVO = new ResultVO<>();
            log.error("出错了");
            return resultVO;
        }
    }
}
