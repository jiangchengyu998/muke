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
    List<ProductInfo> findUpAll();
}
