package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductVO
 * @Description: 商品VO
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
@Data
public class CategoryVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
}
