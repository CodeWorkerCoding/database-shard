package com.nchu.tech.database.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fujianjian on 2017/7/6.
 */
public class CustomerCglibProxyInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
