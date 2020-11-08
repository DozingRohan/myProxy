package com.proxy.javasist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

import java.lang.reflect.Field;

public class JavassistByteCodeFactory {

    public static Object getJavassistBytecode(Object delegate) throws Exception {
        ClassPool mPool = new ClassPool(true);
        CtClass mCtc = mPool.makeClass(delegate.getClass().getName() + "$$JavaassistProxy");
        mCtc.addInterface(mPool.get(delegate.getClass().getInterfaces()[0].getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
//        mCtc.addField(CtField.make("public " + delegate.getClass().getName() + " delegate;", mCtc));
        mCtc.addMethod(CtNewMethod.make("public void fly() {System.out.println(\"flyflyfly\");}", mCtc));
        Object bytecodeProxy = mCtc.toClass().newInstance();
//        Field filed = bytecodeProxy.getClass().getField("delegate");
//        filed.set(bytecodeProxy, delegate);
        return bytecodeProxy;
    }
}
