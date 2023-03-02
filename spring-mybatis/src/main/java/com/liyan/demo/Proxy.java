package com.liyan.demo;

/**
 * @ClassName Proxy
 * @Description TODO
 * @Author name
 * @Date 2023/2/28
 * @Version 1.0
 **/

public class Proxy implements Rent{

    private Host host;

    public Proxy(){};

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        System.out.println("租房的时候增强一下");
        host.rent();
    }

    public void seeHouse(){
        System.out.println("see house");
    }
}

