package com.liyan.alg;


import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {


    @Test
    public void testBinarySearchBasic() {

        int[] a = new int[]{1,20,35,44,22,44};
        int target = 35;

        Assert.assertEquals(2,BinarySearch.binarySearchBasic(a, target));
        int i = BinarySearch.binarySearchBasic(a, target);
    }
}