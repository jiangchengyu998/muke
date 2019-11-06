package com.imooc.product.service.impl;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName ProductServiceImpl
 * @Description: 商品服务
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有商品列表
     * @return 商品列表
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 查询商品列表
     * @param productIdList 商品id列表
     * @return 商品列表
     */
    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, productInfoOutput);
                    return productInfoOutput;
                })
                .collect(Collectors.toList());
    }

    /**
     * 扣库存
     * @param stockInputList 购物车列表
     */
    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> stockInputList) {
        stockInputList.forEach(cartDTO -> {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());

            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            // 判断商品是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        });
    }

}
