package com.uyibai.base.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理
 *
 * Java动态代理主要有两个核心类，InvocationHandler和Proxy。
 *
 * InvocationHandler 接口  执行处理器，
 */
@Slf4j
public class DebugInvocationHandler implements InvocationHandler {

    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.debug("Proxy:{}" , proxy.getClass().getName());
        log.debug("Before method:{}", method.getName());
        Object result = method.invoke(target,args);
        log.debug("After method:" + result);

//        log.debug("invoke proxy:{}", method.invoke(proxy,args));
        return result;
    }
}
