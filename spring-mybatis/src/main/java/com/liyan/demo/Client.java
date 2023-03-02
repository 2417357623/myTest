package com.liyan.demo;

/**
 * @ClassName Client
 * @Description TODO
 * @Author name
 * @Date 2023/2/28
 * @Version 1.0
 **/

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        //代理除了租房子，还会做一些附属的操作.
        proxy.rent();
        proxy.seeHouse();
    }
}

