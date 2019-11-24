package com.imooc.user.utils;


import com.imooc.user.VO.ResultVO;
import com.imooc.user.enums.ResultEnum;

/**
 * @ClassName ResultVOUtils
 * @Description: 返回工具类
 * @Author jiangchengyu
 * @Date 2019/11/3
 * @Version V1.0
 **/
public class ResultVOUtils {
    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());

        return resultVO;
    }
}
