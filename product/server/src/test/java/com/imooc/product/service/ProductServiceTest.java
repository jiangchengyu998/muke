package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Component
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll(){
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertTrue(upAll.size() > 0);

    }

    @Test
    public void findList(){
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock(){
        DecreaseStockInput cartDTO = new DecreaseStockInput("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(cartDTO));

    }

}
