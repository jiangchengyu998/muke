package com.Proxy.cglib;

public class DemoTest {
    public static void main(String[] args) {
        UserControllerProxy userControllerProxy = new UserControllerProxy();
        UserController controllerProxy = (UserController)userControllerProxy.createProxy(new UserController());

        for (int i = 0; i < 10000; i++) {
            controllerProxy.register("123", "123");
            controllerProxy.login("123", "123");
        }
    }
}
