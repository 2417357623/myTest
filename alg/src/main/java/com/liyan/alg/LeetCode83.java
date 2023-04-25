package com.liyan.alg;

import java.util.LinkedList;

/**
 * @ClassName LeetCode83
 * @Description TODO
 * @Author name
 * @Date 2023/4/24
 * @Version 1.0
 **/

public class LeetCode83 {
    public static void main(String[] args) {
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 ;
        while((p2 = p1.next) != null){
            if(p1.val == p2.val){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
        }
        return head;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void foreach(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}

