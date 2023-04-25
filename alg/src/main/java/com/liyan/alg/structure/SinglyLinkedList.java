package com.liyan.alg.structure;

import java.util.function.Consumer;

/**
 * @ClassName SinglyLinkedList
 * @Description TODO
 * @Author name
 * @Date 2023/4/13
 * @Version 1.0
 **/

public class SinglyLinkedList {
    private Node head;

    public static class Node {
        public int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //向链表头部添加
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    //向链表尾部添加
    public void addLast(int value) {
        if(head == null){
            head = new Node(value,null);
        }else if(head != null){
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node(value,null);
        }
    }

    //遍历
    public void forEach(Consumer<Node> consumer){
        Node node = head;
        while(node != null){
            consumer.accept(node);
            node = node.next;
        }
    }

    public void loop(){
        recursion(head);
    }

    private void recursion(Node curr){
        if(curr == null){
            return;
        }
        System.out.println(curr.value);
        curr = curr.next;
        recursion(curr);
    }
    public int get(int index){
        int i = 0;
        for (Node node = head; node != null; node = node.next,i++){
            if(i == index){
                return node.value;
            }
        }
        throw new IllegalArgumentException();
    }

    public void insert(int index,int value){
        int i = 0;
        for (Node node = head; node != null;node = node.next,i++){
            if (i == index-1){
                node.next = new Node(value,node.next);
            }
        }
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void demo(){
        ListNode o5 = new  ListNode(5, null);
        ListNode o4 = new  ListNode(4, o5);
        ListNode o3 = new  ListNode(3, o4);
        ListNode o2 = new  ListNode(2, o3);
        ListNode o1 = new  ListNode(1, o2);
        ListNode listNode = reverseList(o1);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

