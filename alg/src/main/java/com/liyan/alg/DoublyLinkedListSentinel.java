package com.liyan.alg;

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
}

