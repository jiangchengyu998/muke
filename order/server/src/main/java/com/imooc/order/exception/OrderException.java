package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

/**
 * @ClassName OrderException
 * @Description: 订单异常
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
