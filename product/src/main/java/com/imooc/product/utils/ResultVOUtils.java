package com.imooc.product.utils;

import com.imooc.product.VO.ResultVO;

/**
 * @ClassName ResultVOUtils
 * @Description: 返回工具类
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);

        return resultVO;
    }
}
