package com.liyan.reflection_test;

import com.liyan.annotation_test.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName test
 * @Description TODO
 * @Author name
 * @Date 2023/2/15
 * @Version 1.0
 **/


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c1 = Class.forName("com.liyan.reflection_test.User");
        Class<?> c2 = Class.forName("com.liyan.reflection_test.User");
        //说明取到的是一个class类型的对象，而且这只能有一个
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        //针对任何想动态加载，运行的类，必须先获取相应的class对象
        User user = new User();
        Class<? extends User> c3 = user.getClass();
        System.out.println(c3.hashCode());

        Class<User> c4 = User.class;
        System.out.println(c4.hashCode());

//        类加载过程
//        1. 加载到内存，会产生一个class对象。
//        2. 看main方法，链接，给类变量（static）赋初始值
//        3. 执行代码，new A，产生A类对象，并赋值。


        //测试类的初始化
        System.out.println("-------");
        User user1 = new User();

        //获取类的运行时结构
        System.out.println(c1.getName());

        System.out.println("------");

        Field[] f = c1.getDeclaredFields();
        //循环遍历
        for(Field field : f){
            System.out.println(field);
        }
        System.out.println("===");

        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("===");
        Method[] methods = c1.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }

        System.out.println("==========");

        //动态创建对象
        Class<?> c5 = Class.forName("com.liyan.reflection_test.User");

        //构造一个对象,区别类对象
        User user2 = (User) c1.newInstance();
        System.out.println(user2);

        System.out.println("-========");
        //利用反射获取一个方法
        Method save = c5.getDeclaredMethod("save", null);
        save.invoke(user2,null);

        System.out.println("======");
        //反射获取注解信息
        Class<?> c6 = Class.forName("com.liyan.reflection_test.User");
        Table annotation = c6.getAnnotation(Table.class);
        System.out.println(annotation.value());

    }
}

