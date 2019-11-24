package com.imooc.user.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description:
 * @Author jiangchengyu
 * @Date 2019/11/5
 * @Version V1.0
 **/
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "买家角色有误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
