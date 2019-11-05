package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description: 类目服务
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
