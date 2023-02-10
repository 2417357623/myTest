package com.liyan.controller;

import com.liyan.exception.BusinessException;
import com.liyan.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ProjectExceptionAdvice
 * @Description TODO
 * @Author name
 * @Date 2023/2/10
 * @Version 1.0
 **/

//@RestControllerAdvice针对rest开发风格,为rest风格开发额控制器类做增强
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //@ExceptionHandler，设置指定异常处理方案，功能等于控制器方法，出现异常后，终止源控制器，并转入当前方法执行。
    @ExceptionHandler(SystemException.class)
    public Result doException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());

    }

    @ExceptionHandler(BusinessException.class)
    public Result doException(BusinessException ex){

        return new Result(ex.getCode(),null,ex.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员，ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙");

    }
}

