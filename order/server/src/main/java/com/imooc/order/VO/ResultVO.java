package com.imooc.order.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description: 返回
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;
}
