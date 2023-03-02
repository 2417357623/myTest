package com.liyan.reflection_test;

/**
 * @ClassName test2
 * @Description TODO
 * @Author name
 * @Date 2023/2/15
 * @Version 1.0
 **/

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<User> userClass = User.class;

        Class<?> c1 = Class.forName("com.liyan.reflection_test.User");
    }
}

