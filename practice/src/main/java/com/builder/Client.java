package com.builder;

/**
 * @ClassName Client
 * @Description 构造者模式的实现
 * @Author name
 * @Date 2023/3/6
 * @Version 1.0
 **/

public class Client {
    private Client(Builder builder) {

    }

    public void sendMessage(String msg) {
        System.out.println(msg);
    }

    public static class Builder {
        //设置初始的属性值
        private String host = "1";
        private int port = 3333;

        public Builder setHost(String host) {
            this.host = host;
            //方便连续调用
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            //方便连续调用
            return this;
        }

        public Client build(){
            //业务校验工作，校验输入的构造参数是否合理
            return new Client(this);
        }

    }

}

