package com.imooc.order.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description: 返回值枚举
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
