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


}

