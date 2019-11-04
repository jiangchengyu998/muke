package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("12312");
        orderDetail.setProductId("45678");
        orderDetail.setProductName("皮蛋廋肉粥");
        orderDetail.setProductPrice(new BigDecimal("2.5"));
        orderDetail.setProductQuantity(2);

        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(save!=null);
    }
}
