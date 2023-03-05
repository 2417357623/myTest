package com.liyan.proxy;

import java.lang.reflect.InvocationTargetException;

//动态代理的两种实现
public class ProxyTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.createProxy(bigStar);

        proxy.sing("lala");


        BigStar star = new BigStar("liyan");
        Star proxy_2 = (Star) ProxyUtil.createProxy_2(star);
        System.out.println("代理对象执行");
        proxy_2.sing("lala");

        Player player = new Player();
        Run proxy_21 = (Run) ProxyUtil.createProxy_2(player);
        proxy_21.run();


    }
}
