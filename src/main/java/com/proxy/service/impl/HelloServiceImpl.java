package com.proxy.service.impl;

import com.proxy.service.IHelloService;

public class HelloServiceImpl implements IHelloService {

    public String sayHello(String userName) {
        return "Hello World : " + userName;
    }

}
