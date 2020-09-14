package com.Proxy.Dynamic;

/**
 * 这是基于jdk的动态代理，代理的类要实现接口
 */
public class DemoDynamic {
    public static void main(String[] args) {
        //MetricsCollectorProxy使用举例
        UserControllerProxy proxy = new UserControllerProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());

        for (int i = 0; i < 10000; i++) {
            userController.register("123", "123");
            userController.login("123", "123");
        }
    }
}
