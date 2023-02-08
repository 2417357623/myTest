package com.liyan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAdvice
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/

@Component
@Aspect
public class MyAdvice {

    //当生成的bean里面有这个切入点对应的方法时，进入代理模式，会执行aop这里写的通用方法。
    @Pointcut("execution(void com.liyan.dao.BookDao.update())")
    private void pt(){}

//    @Before("pt()")
//    public void method() {
//        System.out.println(System.currentTimeMillis());
//    }

//    @Around("pt()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("before");
//        //表示对原始对象的调用,并且如果原来的方法有返回值，这里在做增强，代理的时候需要把这个返回值拿到并且返回回去。
//        Object ret = pjp.proceed();
//        System.out.println("after");
//        return ret;
//    }

    @Around("pt()")
    public Object around_2(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        for(int i = 0;i < 10000;i++){
            pjp.proceed();
        }
        long end = System.currentTimeMillis();

        //可以拿到执行这个aop的原始类，原始方法的信息
        Signature signature = pjp.getSignature();
        System.out.println(signature.getDeclaringType());
        System.out.println(signature.getName());
        System.out.println("万次执行"+ signature.getDeclaringType() + "." + signature.getName() + "--->" + (end-start));


        return end;
    }
}


