package com.imooc.product.service;

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
    List<ProductInfo> findList(List<String> productIdList);
}
