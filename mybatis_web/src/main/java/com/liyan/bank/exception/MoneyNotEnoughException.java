package com.liyan.bank.exception;

/**
 * @ClassName MoneyNotEnoughException
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 21:40
 * @Version 1.0
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
