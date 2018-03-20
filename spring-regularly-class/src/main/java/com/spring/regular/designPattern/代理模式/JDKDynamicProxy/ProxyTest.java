package com.spring.regular.designPattern.代理模式.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wanli zhou
 * @created 2018-03-14 1:24 PM.
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyTest pt = new ProxyTest();
        IPerson person = new Person();
        IPerson personProxy = pt.getIPersonProxy(person);
        personProxy.doSomething();
    }

    public IPerson getIPersonProxy(IPerson person){
        return (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(), new Class[]{IPerson.class}, new IPersonProxyHandler(person));
    }
    class IPersonProxyHandler implements InvocationHandler{
        Object o ;
        public IPersonProxyHandler(Object o){
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("===> 开始");
            method.invoke(o, args);
            System.out.println("===> 结束");
            return null;
        }
    }
}
