package com.imooc.product.service;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description: 商品服务
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
public interface ProductService {
    /**
     * 查询所有商品列表
     * @return 商品列表
     */
    List<ProductInfo> findUpAll();
    /**
     * 查询商品列表
     * @param productIdList 商品id列表
     * @return 商品列表
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param stockInputList 购物车列表
     */
    void decreaseStock(List<DecreaseStockInput> stockInputList);
}
