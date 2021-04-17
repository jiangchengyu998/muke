package com.Proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这是基于jdk的动态代理，代理的类要实现接口
 */
public class DemoDynamic {
    public static void main(String[] args) {
        //MetricsCollectorProxy使用举例
//        UserControllerProxy proxy = new UserControllerProxy();
//        IUserController userController = (IUserController) proxy.createProxy(new UserController());
//
//        for (int i = 0; i < 10000; i++) {
//            userController.register("123", "123");
//            userController.login("123", "123");
//        }

        UserController userController = new UserController();

        IUserController iUserController = (IUserController)Proxy.newProxyInstance(UserController.class.getClassLoader(), UserController.class.getInterfaces(),new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("hello");
                Object invoke = method.invoke(userController, args);
                System.out.println("傻逼ba");

                return invoke;
            }
        });


        iUserController.login("233", "sfsd");

    }
}
