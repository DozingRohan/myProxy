package com.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 利用继承
 */
public class CglibProxyFactory {

    public static Object getCglibProxy(Object object){
        //设置debug信息，把动态字节码存储为class文件，供反编译查看
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\tmp");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MyInterceptor());
        //创建代理
        return enhancer.create();
    }
}

class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("hello cglib Proxy");
        Object object = methodProxy.invokeSuper(o, args);
        return object;
    }
}
