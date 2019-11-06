package com.imooc.order.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description: 订单状态枚举
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
