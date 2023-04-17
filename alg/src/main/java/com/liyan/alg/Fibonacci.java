package com.liyan.alg;

/**
 * @ClassName Fibonacci
 * @Description 之前的递归值会包含一个自身的调用，这个包含多个对自身的调用。被称为多路递归
 * @Author name
 * @Date 2023/4/17
 * @Version 1.0
 **/

public class Fibonacci {

    public int fibo(int num){
        if(num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        int result;
        result = fibo(num - 1) + fibo( num - 2);
        return result;
    }
}

