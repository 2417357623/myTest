package com.liyan.reflect;

import com.liyan.proxy.BigStar;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;


public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, IOException, InstantiationException {
        Class<?> clazz = Class.forName("com.liyan.proxy.BigStar");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors){
            System.out.println(constructor);
        }

        System.out.println("========");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name);

        System.out.println(name.getModifiers());

        System.out.println("=====");
        BigStar s = new BigStar("李四");
        name.set(s,"张三");
        System.out.println(s);

        //declared正式宣布的
        System.out.println("===method====");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method);
        }

        Method sing = clazz.getDeclaredMethod("sing", String.class);
        System.out.println(sing);

        String name1 = sing.getName();
        System.out.println(name1);

        sing.setAccessible(true);
        Object result = sing.invoke(s, "lala");
        System.out.println(result);

        System.out.println("===反射作用1=====");
        Class<?> clazzStudent = Class.forName("com.liyan.reflect.Student");
        Field[] declaredFields = clazzStudent.getDeclaredFields();
        Student student = new Student(1,"liyan");
        Teacher teacher = new Teacher(2, "zhang", "math");

        //除了student，这个方法可以处理任何Object，因为是反射动态做的
        saveObject(student);
        saveObject(teacher);

        System.out.println("===反射作用2=====");
        create();

    }

    public static void saveObject(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields){
            field.setAccessible(true);
            String studentName = field.getName();
            Object value = field.get(obj);
            System.out.println(studentName + ":" + value);

        }

    }

    public static void create() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\myTest\\practice\\src\\main\\resources\\prop.properties");
        properties.load(fileInputStream);
        fileInputStream.close();

        //获取配置文件信息
        String classname = (String) properties.get("classname");
        String method = (String) properties.get("method");

        Class<?> clazz = Class.forName(classname);

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        System.out.println(o);

        Method declaredMethod = clazz.getDeclaredMethod(method);
        declaredMethod.invoke(o);

    }

}
