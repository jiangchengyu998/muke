package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @ClassName ProductException
 * @Description: 订单异常类
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
