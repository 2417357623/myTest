package com.liyan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAdvice_2
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/
@Component
@Aspect
public class MyAdvice_2 {
    @Pointcut("execution(String com.liyan.dao.BookDao.findName(..))")
    private void pt() {
    }

//    @Before("pt()")
//    public void before(JoinPoint jp){
//        System.out.println("before");
//    }

    //aop不仅可以拿到源方法的参数，还可以对原参数进行修改并重新运行。
    //aop也是可以对原方法进行增强，添加功能。
    @Around("pt()")
    public Object around(JoinPoint jp) throws Throwable {
        //获取源方法的输入参数
        Object[] args = jp.getArgs();
        //修改源代码的输入参数
        args[0] = 1;
        System.out.println("before");
        ProceedingJoinPoint jp1 = (ProceedingJoinPoint) jp;
        //把修改后的参数传给jp来重新执行
        Object proceed = jp1.proceed(args);
        System.out.println("after");
        return proceed;
    }


}

