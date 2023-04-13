package com.liyan.alg;

import java.lang.annotation.Target;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author name
 * @Date 2023/4/10
 * @Version 1.0
 **/

public class BinarySearch {


    public static int binarySearchBasic(int a[],int target) {
       int i = 0, j = a.length - 1;
        int mid ;
        while(i<=j){
           mid =  (int)Math.floor((i+j)>>>1);
           if(target < a[mid]){  //都用小于号
               j = mid - 1 ;  //如果将high的值设置为mid，将无法排除中间值，而这个中间值已经被判断过不等于要查找的值，因此不应该再将其作为下一轮查找的范围。
           }else if (a[mid] < target){
               i = mid + 1;
           }else {
               System.out.println("找到了target");
               return mid;
           }
       }
        return -1;

    }

    public static int binarySearchLeftmost(int a[],int target) {
        int i = 0, j = a.length - 1;
        int mid ;
        int candidate = -1;
        while(i<=j){
            mid =  (int)Math.floor((i+j)>>>1);
            if(target < a[mid]){  //都用小于号
                j = mid - 1 ;  //如果将high的值设置为mid，将无法排除中间值，而这个中间值已经被判断过不等于要查找的值，因此不应该再将其作为下一轮查找的范围。
            }else if (a[mid] < target){
                i = mid + 1;
            }else {
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;

    }

    //大于等于目标的最靠左的位置，可以用来求排名，求前任
    public static int binarySearchLeftmost2(int a[],int target) {
        int i = 0, j = a.length - 1;
        int mid ;
        while(i<=j){
            mid =  (int)Math.floor((i+j)>>>1);
            if(target <= a[mid]){  //都用小于号
                j = mid - 1 ;  //如果将high的值设置为mid，将无法排除中间值，而这个中间值已经被判断过不等于要查找的值，因此不应该再将其作为下一轮查找的范围。
            }else if (a[mid] < target){
                i = mid + 1;
            }
        }
        return i;

    }
}

