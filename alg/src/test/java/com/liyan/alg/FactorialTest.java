package com.liyan.alg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FactorialTest {
    Factorial factorial = new Factorial();
    @Test
    public void search() {
        int a[] = new int[]{1,2,3,4,7,20,55,78};
        int search = Factorial.search(a, 2);
        System.out.println(search);
    }

    @Test
    public void sort() {
        int a[] = new int[]{12,2,31,40,7,20,55,78};
        factorial.sort(a);
        Arrays.stream(a)
                .forEach(num -> System.out.println(num));
    }

    @Test
    public void sort2() {
        int a[] = new int[]{12,2,31,40,7,20,55,78};
        factorial.sort2(a);
        Arrays.stream(a)
                .forEach(num -> System.out.println(num));
    }
}