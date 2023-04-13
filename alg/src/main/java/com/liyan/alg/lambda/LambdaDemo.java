package com.liyan.alg.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

/**
 * @ClassName LambdaDemo
 * @Description TODO
 * @Author name
 * @Date 2023/4/11
 * @Version 1.0
 **/

public class LambdaDemo {
    public static void main(String[] args) {

        methodQuote();
    }

    public void newThread() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程1");
            }
        }).start();
    }

    public void newThread_2() {
        new Thread(() -> {
            System.out.println("线程1");
        }).start();
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10, b = 20;
        return operator.applyAsInt(a, b);
    }

    public void calculate() {
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(i);

    }

    public void calculate_2() {
        int i = calculateNum((right, left) -> right + left);
        System.out.println(i);

    }

    public  static  List<Apple> filterApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory
             ) {
            if ("green".equals(apple.getColor())){
                result.add(apple);
                System.out.println(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples_2(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory
        ) {
           if(predicate.test(apple)){
               result.add(apple);
               System.out.println(apple);
           }
        }

        return result;
    }

    public static void demo(){
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red"));
        apples.add(new Apple("green"));

        List<Apple> apples1 = filterApples(apples);

        filterApples_2(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        });

        filterApples_2(apples,apple -> apple.getColor().equals("green"));

    }

    public static void  methodQuote(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer con = System.out::println;
        con.accept("hello");
    }


}



