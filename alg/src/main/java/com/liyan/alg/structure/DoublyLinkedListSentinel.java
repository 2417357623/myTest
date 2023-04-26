package com.liyan.alg.structure;

/**
 * @ClassName DoublyLinkedListSentinel
 * @Description 在传统的单向链表中，我们需要特别处理头节点和尾节点的情况，因为它们没有前驱节点和后继节点。
 *
 * 例如，如果我们要在链表头部插入一个节点，我们需要检查链表是否为空。如果链表为空，则需要将新节点设置为头节点和尾节点；否则，需要将新节点插入到头节点之前。
 *
 * 另外，如果我们要在链表尾部插入一个节点，我们需要检查链表是否为空或只有一个节点。如果链表为空，则需要将新节点设置为头节点和尾节点；如果链表只有一个节点，则需要将新节点插入到尾节点之后；否则，需要将新节点插入到尾节点之前。
 *
 * 类似地，如果我们要删除链表中的头节点或尾节点，也需要特殊处理。如果链表只有一个节点，则需要将头节点和尾节点都设置为 null；否则，需要将头节点或尾节点的后继节点作为新的头节点或尾节点。
 *
 * 这些特判操作使得代码实现变得复杂，容易出错。而使用单向链表哨兵可以避免这些问题，使代码更加简洁和高效。
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

