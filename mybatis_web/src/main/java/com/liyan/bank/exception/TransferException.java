package com.liyan.bank.exception;

/**
 * @ClassName TransferException
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 21:47
 * @Version 1.0
 */
public class TransferException extends Exception{
    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }
}
