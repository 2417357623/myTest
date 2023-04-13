package com.liyan.alg.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author name
 * @Date 2023/4/12
 * @Version 1.0
 **/

public class StreamDemo {
    public static void main(String[] args) {
        demo();
//        StreamDemo.createStream();
    }


    public static void demo() {
        List<Integer> num = new ArrayList<Integer>();
        num.add(12);
        num.add(1);
        num.add(14);
        num.add(34);
        num.add(34);
        num.stream()
                .distinct()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer < 16;
                    }
                })
                .limit(3)
                .skip(1)
                .forEach(integer -> System.out.println(integer));
    }

    //创建流
    public static void createStream() {
        List<Integer> num = new ArrayList<Integer>();
        Stream stream = num.stream();
        Stream<Integer> s = num.parallelStream();

        int[] array = new int[]{1,2,3,54};
        IntStream stream1 = Arrays.stream(array);

        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,2);
        map.put(1,2);

        Set<Map.Entry<Object, Object>> entrySet = map.entrySet();
        Stream<Map.Entry<Object, Object>> stream2 = entrySet.stream();

    }
}

