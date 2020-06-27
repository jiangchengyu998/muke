package com.imooc.order.controller;

import com.imooc.order.common.ResultVO;
import com.imooc.order.common.OrderId;
import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName OrderController
 * @Description: 订单控制器
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 校验参数
     * 以下步骤在Service做
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价
     * 4. 扣库存（调用商品服务）
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid @RequestBody OrderForm orderForm, ResultVO<BindingResult> bindingResult ) {

        if (bindingResult.getData() != null && bindingResult.getData().hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getData().getFieldError()).getDefaultMessage());
        }
        // orderForm --> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (orderDTO == null) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);
        if (result == null) {
            return ResultVOUtils.fail("下单有误");
        }
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);
    }

    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId){
        return ResultVOUtils.success(orderService.finish(orderId));
    }

    @PostMapping("/getOder")
    public ResultVO<OrderId> getOder(@RequestBody OrderId orderId){
        return ResultVOUtils.success(orderService.getOder(orderId));
    }

}
