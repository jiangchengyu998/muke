package com.imooc.order.service;

import com.imooc.order.common.OrderId;
import com.imooc.order.dto.OrderDTO;

/**
 * @ClassName OrderService
 * @Description: 订单服务
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
public interface OrderService {
    OrderDTO create(OrderDTO dto);

    OrderDTO finish(String orderId);

    OrderId getOder(OrderId orderId);
}
