package com.proxy.javasist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

public class JavassistProxyFactory {

    public static Object getJavassistProxy(final Object delegate) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(delegate.getClass().getInterfaces());
        Class<?> proxyClass = proxyFactory.createClass();
        Object javassistProxy = proxyClass.newInstance();
        ((ProxyObject) javassistProxy).setHandler(new JavaAssitInterceptor(delegate));
        return javassistProxy;
    }

}

class JavaAssitInterceptor implements MethodHandler {

    final Object delegate;

    JavaAssitInterceptor(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object self, Method m, Method proceed,Object[] args) throws Throwable {
        return m.invoke(delegate, args);
    }
}
