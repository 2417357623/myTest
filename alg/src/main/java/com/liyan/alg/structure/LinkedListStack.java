package com.liyan.alg.structure;

/**
 * @ClassName LinkedListStack
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/4/26 18:49
 * @Version 1.0
 */
public class LinkedListStack<T> {

    ListNode<T> head;
    private int size;
    private int capacity;
    private class ListNode<T>{
        T val;
        ListNode<T> next;

        public ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public LinkedListStack(int capacity){
        head = new ListNode<T>(null,null);
        this.capacity = capacity;
    }

    public boolean push(T val){
        if(isFull()){
            return false;
        }
        head.next = new ListNode<T>(val,head.next);
        size++;
        return true;
    }

    public boolean isEmpty(){
        return head.next == null;
    }
    public boolean isFull(){
        return size == capacity;
    }


}
