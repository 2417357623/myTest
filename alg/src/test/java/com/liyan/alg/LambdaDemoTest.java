package com.liyan.alg;

import com.liyan.alg.lambda.LambdaDemo;
import org.junit.Test;

public class LambdaDemoTest {
    LambdaDemo lambdaDemo = new LambdaDemo();

    @Test
    public void newThread() {
    }

    @Test
    public void newThread_2() {
        lambdaDemo.newThread();
        lambdaDemo.newThread_2();
    }


    @Test
    public void calculateNum() {
    }

    @Test
    public void calculate() {
        lambdaDemo.calculate();
        lambdaDemo.calculate_2();
    }
}