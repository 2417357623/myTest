package com.learn.debug;

import com.learn.bean.Person;

public class DebugTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setPersonID(2);
        new DebugTest().test();
        System.out.println("0");

    }

    public void test(){
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
    }

}
