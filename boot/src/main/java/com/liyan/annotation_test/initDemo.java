package com.liyan.annotation_test;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface initDemo {
    //String为注解参数类型，name为注解参数名,有默认值，在使用注解的时候就不用再显式赋值
    String name() default "";

    int age();

}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface initDemo_2 {
    //如果只有一个，默认用value
    String value();

}
