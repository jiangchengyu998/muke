package com.imooc.product.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description: 商品状态枚举
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
