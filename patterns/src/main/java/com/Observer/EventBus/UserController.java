package com.Observer.EventBus;


import com.Observer.v2.RegNotificationObserver;
import com.Observer.v2.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;


public class UserController {
    private UserService userService; // 依赖注入

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        //eventBus = new EventBus(); // 同步阻塞模式
        userService = new UserService();
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, password);

        eventBus.post(userId);

        return userId;
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.setRegObservers(Collections.singletonList(new RegNotificationObserver()));
        userController.register("15078367322", "123456");
    }
}
