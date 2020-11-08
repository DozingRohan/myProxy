package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    public static Object getJdkProxy(Object object){
        if(object instanceof java.lang.Class){
            return createProxyWhenGetAClass(object);
        }else{
            return createProxyWhenGetAInstance(object);
        }
    }

    private static Object createProxyWhenGetAClass(Object object){
        try {
            InvocationHandler invocationHandler = null;
            Class[] clss = null;
            Class clz = (java.lang.Class)object;
            if(clz.isInterface()){
                invocationHandler = new MyInvocationHandler();
                clss = new Class[]{clz};
            }else{
                Object o = Class.forName(clz.getName()).newInstance();
                invocationHandler = new MyInvocationHandler(o);
                clss = clz.getInterfaces();
            }
            return Proxy.newProxyInstance(JdkProxyFactory.class.getClassLoader(),clss,invocationHandler);
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException("代理创建失败");
        }
    }

    private static Object createProxyWhenGetAInstance(Object object) {
        try {
            InvocationHandler invocationHandler = null;
            Class[] clss = null;
            if(object.getClass().isInterface()){
                invocationHandler = new MyInvocationHandler(object);
                clss = new Class[]{object.getClass()};
            }else{
                if(object.getClass().getInterfaces().length == 0){
                    throw new IllegalStateException("错误，没有接口");
                }
                invocationHandler = new MyInvocationHandler(object);
                clss = object.getClass().getInterfaces();
            }
            return Proxy.newProxyInstance(JdkProxyFactory.class.getClassLoader(),clss,invocationHandler);
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException("代理创建失败");
        }
    }

}




class MyInvocationHandler implements InvocationHandler{

    public Object object;

    public MyInvocationHandler(){}

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(object != null){
            if("sayHello".equals(method.getName())){
                System.out.println("hello jdk Proxy");
                return method.invoke(object,args);
            }else{
                System.out.println("Proxy~~~~~");
            }
            return method.invoke(object,args);
        }else{
            if("sayHello".equals(method.getName())){
                System.out.println("hello jdk Proxy");
                return "hello this is pure interface";
            }else{
                System.out.println(method.getName() + " : ?? you are a interface, what do you want");
                return null;
            }
        }
    }
}