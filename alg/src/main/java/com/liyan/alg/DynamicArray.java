package com.liyan.alg;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @ClassName DynamicArray
 * @Description TODO
 * @Author name
 * @Date 2023/4/11
 * @Version 1.0
 **/

public class DynamicArray {

    private int size = 0;
    private int capacity = 8;
    private int[] array = new int[capacity];

    public void addLast(int element) {
        if (size == capacity) {
            capacity = capacity + 10;
        }
        array[size] = element;
        size++;
    }

    public void add(int element, int index) {
        if (index >= 0 && index < size) {
            for (int i = size - 1; i > index - 1; i--) {
                array[i + 1] = array[i];
            }
        }
        array[index] = element;
        size ++;
    }



    @Override
    public String toString() {
        String list = "有这些数";
        for (int num: array
             ) {
            list  = list + "," + num;
        }
        return list;
    }

    //提供一个遍历方法，但不指定行为，可以通过外部参数来定义行为的内容，把函数作为了参数
    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    public int remove(int index){
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return array[index];
    }

}

