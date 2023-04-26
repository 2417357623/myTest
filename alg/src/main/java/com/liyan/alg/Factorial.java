package com.liyan.alg;

import com.liyan.alg.structure.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName Factorial
 * @Description TODO
 * @Author name
 * @Date 2023/4/14
 * @Version 1.0
 **/

public class Factorial {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        hanota(arrayList,new ArrayList<>(),new ArrayList<>());
    }

    public static int demo(int n) {
        if (n == 1) {
            return 1;
        }
        int result;
        result = n * demo(n - 1);

        System.out.println(result);
        return result;
    }

    public static int demo2(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return demo2(n - 1) + demo2(n - 2);

    }

    //递归二分查找法，前提是数组值是顺序上升的
    public static int search(int[] a, int target) {
        int f = f(a, target, 0, a.length - 1);
        return f;
    }

    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) >>> 1;
        if (target < a[mid]) {
            j = mid - 1;
            return f(a, target, i, j);
        } else if (target > a[mid]) {
            i = mid + 1;
            return f(a, target, i, j);
        } else {
            return a[mid];
        }
    }

    public void sort(int[]a){
        bubbleSort(a,a.length -1);
    }

    public void sort2(int[]a){
        insertSort(a,1);
    }

    //递归冒泡排序，j代表未排序区域的右边界
    public void bubbleSort(int[]a,int j) {
        if(j == 0){
            return;
        }
        int temp;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i+1]){
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        j--;
        bubbleSort(a,j);
    }

/**
         * 功能:
         * 作者: 李炎
         * 关键逻辑:
         * @param
         * @return
         */
    public void insertSort(int a[],int low){

        if(low == a.length){
            return;
        }

        for(int i = 0; i<low;i++){
            int temp = a[low];
            if(a[low] < a[i]){
                for (int j = low-1; j>i-1; j--) {
                    a[j+1] = a[j];//必须用j--,j++会造成数据往后挪的时候的错误。
                }
                a[i] = temp;
                break;
            }
        }

        low++;
        insertSort(a,low);
    }

        public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            move(A.size(),A,B,C);
        }
        public static void move(int n, List<Integer> A, List<Integer> B, List<Integer> C){
            if(n == 0){
                return;
            }
            move(n-1,A,C,B);
            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
            System.out.println("-----");
            C.add(A.remove(A.size()-1));
            move(n-1,B,A,C);
        }

        public static void foreach(List<Integer> list){
            for (Integer num: list
                 ) {
                System.out.println(num);
            }
        }

}

