package com.liyan.alg;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void fibo() {
        int fibo = fibonacci.fibo(8);
        System.out.println(fibo);
    }
}