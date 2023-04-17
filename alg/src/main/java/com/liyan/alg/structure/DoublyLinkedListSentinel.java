package com.liyan.alg.structure;

/**
 * @ClassName DoublyLinkedListSentinel
 * @Description TODO
 * @Author name
 * @Date 2023/4/13
 * @Version 1.0
 **/

public class DoublyLinkedListSentinel {


    Node head;
    Node tail;

    public DoublyLinkedListSentinel(){
        Node head = new Node(null, null, 0);
        Node tail = new Node(head, null, 0);
        head.next = tail;
        tail.prev = head;
    }
    static class Node {
        Node prev;
        Node next;
        int value;

        public Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public Node findNode(int index){
        int i = -1;
        for(Node p = head; p != tail; p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    public void insert(int index,int value){
        Node prev = findNode(index - 1);
        if (prev == null){
            //抛出异常
        }
        Node next = findNode(index);
        Node node = new Node(prev, next, value);
        prev.next = node;
        next.prev = node;
    }

    public void remove(int index){
        Node prev = findNode(index - 1);
        Node removed = prev.next;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addLast(int value){
        Node prev = tail.prev;
        Node node = new Node(prev, tail, value);
        prev.next = node;
        tail.prev = node;
    }
}

