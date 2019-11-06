package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testSave(){
        OrderMaster master = new OrderMaster();
        master.setOrderId("123456");
        master.setBuyerAddress("广州市海珠区");
        master.setBuyerName("测试");
        master.setBuyerOpenid("sdafadfasdfasdfas");
        master.setBuyerPhone("15078367322");
        master.setOrderAmount(new BigDecimal("299"));
        master.setOrderStatus(OrderStatusEnum.NEW.getCode());
        master.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster orderMaster = orderMasterRepository.save(master);
        Assert.assertTrue(orderMaster != null);
    }
}
