package com.imooc.product.common;

import lombok.Data;

/**
 * @ClassName DecreaseStockInput
 * @Description: 减库存入参
 * @Author jiangchengyu
 * @Date 2019/11/6
 * @Version V1.0
 **/
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
