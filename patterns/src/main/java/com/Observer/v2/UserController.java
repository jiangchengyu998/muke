package com.Observer.v2;

/*

public class UserController {
    private UserService userService; // 依赖注入
    private PromotionService promotionService; // 依赖注入

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);  // 发放投资体验金
        return userId;
    }
}

 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class UserController {
    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;

    public UserController(Executor executor) {    this.executor = executor;  }

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);

        for (RegObserver observer : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.handleRegSuccess(userId);
                }
            });
        }

        return userId;
    }
}