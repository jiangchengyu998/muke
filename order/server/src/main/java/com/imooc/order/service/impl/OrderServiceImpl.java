package com.imooc.order.service.impl;

import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @ClassName OrderServiceImpl
 * @Description: 订单服务
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    /**
     * @param orderDTO 订单数据
     * @return 创建的订单实体
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        //  查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        // 计算总价
        AtomicReference<BigDecimal> orderAmount = new AtomicReference<>(new BigDecimal(BigInteger.ZERO));
        orderDTO.getOrderDetailList().forEach(orderDetail -> {
            productInfoList.forEach(productInfo -> {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    // 单价*数量
                    orderAmount.set(productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount.get()));

                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            });
        });
        // 扣库存（调用商品服务）
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount.get());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {

        // 1. 查询订单
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if (!orderMasterOptional.isPresent()) {
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 2. 判断订单状态
        OrderMaster orderMaster = orderMasterOptional.get();
        if (OrderStatusEnum.NEW.getCode() != orderMaster.getOrderStatus()) {
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        // 3. 修改订单状态为已经完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);

        // 4. 查询订单详情
        List<OrderDetail> detailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(detailList)){
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXITS);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(detailList);

        return orderDTO;
    }
}
