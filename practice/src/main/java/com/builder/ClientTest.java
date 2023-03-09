package com.builder;

/**
 * @ClassName ClientTest
 * @Description 建造者模式
 * @Author name
 * @Date 2023/3/6
 * @Version 1.0
 **/

public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client.Builder().setHost("11").setPort(22).build();
        client.sendMessage("test");
        System.out.println();
    }
}

