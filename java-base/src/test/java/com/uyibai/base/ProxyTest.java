package com.uyibai.base;

import com.uyibai.base.proxy.DebugInterface;
import com.uyibai.base.proxy.DebugInterfaceImpl;
import com.uyibai.base.proxy.DebugInvocationHandler;
import com.uyibai.base.proxy.cglib.CglibProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * Jdk动态代理和Cglib动态代理对比：
 * <p>
 * 1. Jdk动态代理本质是基于反射，Cglib动态代理本质是基于继承代理类，重写子类方法实现代理。
 * 2. Jdk动态代理代理类必须要实现接口，并且只能代理接口中的方法，Cglib动态代理，代理类本身不需要实现任何方法即可实现代理，但是由于实现原理是基于继承代理类实现，所以，代理类以及代理的方法不能用final修饰。
 * 3. Jdk动态代理基于反射实现，在运行期间完成代理工作，Cglib动态代理是通过字节码增强技术，在编译器完成代理，所以，Cglib动态代理的效率要稍高于Jdk动态代理。
 */

public class ProxyTest {

    @Test
    public void testJdkProxy(String[] args) {

        DebugInterfaceImpl targetCls = new DebugInterfaceImpl();
        DebugInvocationHandler debugHandler = new DebugInvocationHandler(targetCls);
        /**
         * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        DebugInterface debug = (DebugInterface) Proxy.newProxyInstance(targetCls.getClass().getClassLoader(), targetCls.getClass().getInterfaces(), debugHandler);
        /**
         * debug 类是 在 运行时生成的，命名方式 是 $Proxy 开头
         */
        debug.targetMethod(10);
    }


    @Test
    public void testCglibProxy() {
        /**
         * Cglib动态代理依赖MethodInterceptor 和Enhancer 类，
         * 1.1 MethodInterceptor
         * MethodInterceptor 接口只有 intercept() 一个方法，所有被代理类的方法执行最终都会转移到 intercept() 方法中进行行为增强，真实方法的执行逻辑则通过 Method 或者 MethodProxy 对象进行调用。
         * 1.2 Enhancer
         * Enhancer 类是 Cglib 中的一个字节码增强器，它为我们对代理类进行扩展时提供了极大的便利。Enhancer 类的本质是在运行时动态为代理类生成一个子类，并且拦截代理类中的所有方法。
         * 我们可以通过 Enhancer 设置 Callback 接口对代理类方法执行的前后执行一些自定义行为，其中 MethodInterceptor 接口是我们最常用的 Callback 操作
         *
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DebugInterfaceImpl.class);
        enhancer.setCallback(new CglibProxy(new DebugInterfaceImpl()));

        DebugInterface debug = (DebugInterface) enhancer.create();
        debug.targetMethod(10);
    }

}
