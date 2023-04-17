package com.liyan.alg;

import com.liyan.alg.structure.DynamicArray;
import org.junit.Test;

public class DynamicArrayTest {
    DynamicArray array = new DynamicArray();

    @Test
    public void addLast() {
    }

    @Test
    public void add() {


        array.addLast(1);
        array.addLast(17);
        array.addLast(3);
        array.addLast(199);
        array.add(12, 3);
        System.out.println(array.toString());
    }

    @Test
    public void forEach() {
        array.forEach(element -> System.out.println(element));
    }


    @Test
    public void remove() {
        array.addLast(1);
        array.addLast(17);
        array.addLast(3);
        array.addLast(199);
        array.remove(1);
        array.forEach(element -> System.out.println(element));
    }
}