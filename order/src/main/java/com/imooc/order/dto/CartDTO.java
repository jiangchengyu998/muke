package com.imooc.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CartDTO
 * @Description: 购物车dto
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
@NoArgsConstructor
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private int productQuantity;

    public CartDTO(String productId, int productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
