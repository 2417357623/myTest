package com.liyan.alg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    @Test
    public void addFirst() {
    }

    @Test
    public void addLast() {
    }

    @Test
    public void forEach() {
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(5);
        singlyLinkedList.addLast(15);
        singlyLinkedList.forEach(node -> System.out.println(node.value));
    }

    @Test
    public void get() {
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(5);
        singlyLinkedList.addLast(15);
        System.out.printf(""+singlyLinkedList.get(3));
    }

    @Test
    public void insert() {
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.insert(2,133);
        singlyLinkedList.forEach(node -> System.out.println(node.value));
    }
}