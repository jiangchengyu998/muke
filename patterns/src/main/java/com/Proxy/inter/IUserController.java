package com.Proxy.inter;


import com.Proxy.demo.UserVo;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
