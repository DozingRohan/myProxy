package com.proxy;

import com.proxy.cglib.CglibProxyFactory;
import com.proxy.javasist.JavassistByteCodeFactory;
import com.proxy.javasist.JavassistProxyFactory;
import com.proxy.jdk.JdkProxyFactory;
import com.proxy.service.IFlyService;
import com.proxy.service.impl.FlyServiceImpl;

import java.lang.reflect.Method;

/**
 * 动态改变方法的逻辑
 */
public class Test {

    public static void main(String[] args) throws Exception {
        int x = 10000;
        /**
         * jdk的代理机制：使用接口，然后生成字节码为这个接口的实现类，并且拦截方法，也可以传入实现类，取实现类的接口，然后执行拦截
         */
//        IHelloService helloService = (IHelloService) JdkProxyFactory.getJdkProxy(new HelloServiceImpl());
//        System.out.println(helloService.sayHello("lpj"));
//        IFlyService flyService = (IFlyService) JdkProxyFactory.getJdkProxy(FlyServiceImpl.class);
//        flyService.fly();


        /**
         * cglib代理机制(FastClass机制)：使用继承的方式
         *
         * FlyServiceImpl$$EnhancerByCGLIB$$7af39d2$$FastClassByCGLIB$$6dab5714.class -- 代理类的FastClass
         * FlyServiceImpl$$EnhancerByCGLIB$$7af39d2.class --代理类
         * FlyServiceImpl$$FastClassByCGLIB$$d0dc684a.class --目标类的FastClass
         *
         */
//        IHelloService helloService = (IHelloService) CglibProxyFactory.getCglibProxy(new HelloServiceImpl());
//        System.out.println(helloService.sayHello("lpj"));
//        IFlyService flyService = (IFlyService) CglibProxyFactory.getCglibProxy(new FlyServiceImpl());
//        flyService.fly();



        /**
         * 代理对象生成速度对比
         * jdk time-cost:17 ms
         * cglib time-cost:114 ms
         * javasisProxy time-cost:90 ms
         * javasisByteCode time-cost:62 ms
         */
//        long start = System.currentTimeMillis();
//        IFlyService helloService = (IFlyService) JdkProxyFactory.getJdkProxy(new FlyServiceImpl());
//        long end = System.currentTimeMillis();
//        IFlyService flyService = (IFlyService) CglibProxyFactory.getCglibProxy(new FlyServiceImpl());
//        long send = System.currentTimeMillis();
//        IFlyService jsis1 = (IFlyService) JavassistProxyFactory.getJavassistProxy(new FlyServiceImpl());
//        long send1 = System.currentTimeMillis();
//        IFlyService jsis2 = (IFlyService) JavassistByteCodeFactory.getJavassistBytecode(new FlyServiceImpl());
//        long send2 = System.currentTimeMillis();
//        System.out.println("jdk time-cost:" + (end - start) + " ms");
//        System.out.println("cglib time-cost:" + (send - end) + " ms");
//        System.out.println("javasisProxy time-cost:" + (send1 - send) + " ms");
//        System.out.println("javasisByteCode time-cost:" + (send2 - send1) + " ms");


        /**
         * 代理对象执行速度对比
         * jdk exec time-cost:129 ms
         * cglib exec time-cost:212 ms
         * javasist exec time-cost:212 ms
         */
//        long start = System.currentTimeMillis();
//        IFlyService flyService1 = (IFlyService) JdkProxyFactory.getJdkProxy(new FlyServiceImpl());
//        for(int i = 0 ; i < x ; i ++){
//            flyService1.fly();
//        }
//        long end = System.currentTimeMillis();
//        IFlyService flyService2 = (IFlyService) CglibProxyFactory.getCglibProxy(new FlyServiceImpl());
//        for(int i = 0 ; i < x ; i ++){
//            flyService2.fly();
//        }
//        long send = System.currentTimeMillis();
//        IFlyService jsis1 = (IFlyService) JavassistProxyFactory.getJavassistProxy(new FlyServiceImpl());
//        for(int i = 0 ; i < x ; i ++){
//            jsis1.fly();
//        }
//        long send1 = System.currentTimeMillis();
//        IFlyService jsis2 = (IFlyService) JavassistByteCodeFactory.getJavassistBytecode(new FlyServiceImpl());
//        for(int i = 0 ; i < x ; i ++){
//            jsis2.fly();
//        }
//        long send2 = System.currentTimeMillis();
//        System.out.println("jdk exec time-cost:" + (end - start) + " ms");
//        System.out.println("cglib exec time-cost:" + (send - end) + " ms");
//        System.out.println("javasisProxy exec time-cost:" + (send1 - send) + " ms");
//        System.out.println("javasisByteCode exec time-cost:" + (send2 - send1) + " ms");


    }

}
