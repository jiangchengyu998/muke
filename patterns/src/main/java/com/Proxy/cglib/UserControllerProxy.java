package com.Proxy.cglib;


import com.Proxy.demo.MetricsCollector;
import com.Proxy.demo.RequestInfo;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserControllerProxy {

    private MetricsCollector metricsCollector;

    public UserControllerProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(proxiedObject.getClass());
        enhancer.setCallback(new MyMethodInterceptor(proxiedObject));
        return enhancer.create();

    }

    public class MyMethodInterceptor implements MethodInterceptor {

        private Object proxiedObject;

        public MyMethodInterceptor(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            long startTimestamp = System.currentTimeMillis();

            Object o1 = methodProxy.invokeSuper(obj, args);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = method.getName();
//            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return o1;
        }
    }

}

